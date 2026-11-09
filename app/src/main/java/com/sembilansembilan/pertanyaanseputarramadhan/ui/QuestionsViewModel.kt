package com.sembilansembilan.pertanyaanseputarramadhan.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.sembilansembilan.pertanyaanseputarramadhan.data.Question
import com.sembilansembilan.pertanyaanseputarramadhan.data.SettingsStore
import com.sembilansembilan.pertanyaanseputarramadhan.data.ramadhanQuestions
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

/** Daftar 99 Pertanyaan: pencarian + expand/collapse + bookmark. */
class QuestionsViewModel(private val settingsStore: SettingsStore) : ViewModel() {

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    private val _expandedId = MutableStateFlow<Int?>(null)
    val expandedId: StateFlow<Int?> = _expandedId

    /** Pencarian di judul + pertanyaan + jawaban (case-insensitive). */
    val filteredQuestions: StateFlow<List<Question>> = combine(_searchQuery) { (query) ->
        val q = query.trim().lowercase()
        if (q.isEmpty()) {
            ramadhanQuestions
        } else {
            ramadhanQuestions.filter { item ->
                item.title.lowercase().contains(q) ||
                    item.question.lowercase().contains(q) ||
                    item.answer.lowercase().contains(q)
            }
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), ramadhanQuestions)

    fun setSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun toggleExpanded(id: Int) {
        _expandedId.value = if (_expandedId.value == id) null else id
    }

    fun toggleBookmark(id: Int) {
        viewModelScope.launch { settingsStore.toggleBookmark("q:$id") }
    }

    class Factory(private val settingsStore: SettingsStore) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(QuestionsViewModel::class.java)) {
                return QuestionsViewModel(settingsStore) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
