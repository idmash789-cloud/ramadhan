package com.sembilansembilan.pertanyaanseputarramadhan.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.sembilansembilan.pertanyaanseputarramadhan.data.PissQuestion
import com.sembilansembilan.pertanyaanseputarramadhan.data.SettingsStore
import com.sembilansembilan.pertanyaanseputarramadhan.data.pissKtbQuestions
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

/** Daftar Tanya Jawab PISS-KTB: pencarian + expand/collapse + bookmark. */
class PissKtbViewModel(private val settingsStore: SettingsStore) : ViewModel() {

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    private val _expandedId = MutableStateFlow<Int?>(null)
    val expandedId: StateFlow<Int?> = _expandedId

    /** Pencarian di judul + pertanyaan + jawaban (case-insensitive). */
    val filteredQuestions: StateFlow<List<PissQuestion>> = combine(_searchQuery) { (query) ->
        val q = query.trim().lowercase()
        if (q.isEmpty()) {
            pissKtbQuestions
        } else {
            pissKtbQuestions.filter { item ->
                item.title.lowercase().contains(q) ||
                    item.question.lowercase().contains(q) ||
                    item.answer.lowercase().contains(q)
            }
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), pissKtbQuestions)

    fun setSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun toggleExpanded(id: Int) {
        val expanding = _expandedId.value != id
        _expandedId.value = if (expanding) id else null
        // QW-1: hitung jawaban yang dibuka untuk pemicu prompt rating.
        if (expanding) {
            viewModelScope.launch { settingsStore.recordDetailOpen() }
        }
    }

    fun toggleBookmark(id: Int) {
        viewModelScope.launch { settingsStore.toggleBookmark("p:$id") }
    }

    class Factory(private val settingsStore: SettingsStore) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(PissKtbViewModel::class.java)) {
                return PissKtbViewModel(settingsStore) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
