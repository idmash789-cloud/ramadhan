package com.sembilansembilan.pertanyaanseputarramadhan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.QuestionAnswer
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.sembilansembilan.pertanyaanseputarramadhan.data.DarkMode
import com.sembilansembilan.pertanyaanseputarramadhan.data.SettingsStore
import com.sembilansembilan.pertanyaanseputarramadhan.imsakiyah.ReminderScheduler
import com.sembilansembilan.pertanyaanseputarramadhan.ui.HomeViewModel
import com.sembilansembilan.pertanyaanseputarramadhan.ui.QuestionsViewModel
import com.sembilansembilan.pertanyaanseputarramadhan.ui.SettingsViewModel
import com.sembilansembilan.pertanyaanseputarramadhan.ui.screens.BookmarksScreen
import com.sembilansembilan.pertanyaanseputarramadhan.ui.screens.BukuSakuDetailScreen
import com.sembilansembilan.pertanyaanseputarramadhan.ui.screens.BukuSakuScreen
import com.sembilansembilan.pertanyaanseputarramadhan.ui.screens.HomeScreen
import com.sembilansembilan.pertanyaanseputarramadhan.ui.screens.QuestionsScreen
import com.sembilansembilan.pertanyaanseputarramadhan.ui.screens.SettingsScreen
import com.sembilansembilan.pertanyaanseputarramadhan.ui.theme.RamadhanTheme
import com.sembilansembilan.pertanyaanseputarramadhan.util.AdMobHelper
import com.sembilansembilan.pertanyaanseputarramadhan.util.ConsentManager
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val settingsStore = SettingsStore(applicationContext)
        // UMP consent dulu; iklan diinisialisasi setelah alur persetujuan
        // selesai (atau gagal — mis. offline — iklan tetap jalan).
        ConsentManager.requestConsent(this) {
            AdMobHelper.initialize(this)
        }
        // Jadwalkan ulang pengingat bila aktif (mis. setelah aplikasi di-update).
        lifecycleScope.launch {
            val settings = settingsStore.getSettings()
            if (settings.remindersEnabled) {
                ReminderScheduler.schedule(applicationContext, settings.cityName)
            }
        }
        setContent {
            val settingsVm: SettingsViewModel = viewModel(factory = SettingsViewModel.Factory(settingsStore))
            val settings by settingsVm.settings.collectAsState()
            val darkTheme = when (settings.darkMode) {
                DarkMode.LIGHT -> false
                DarkMode.DARK -> true
                DarkMode.SYSTEM -> androidx.compose.foundation.isSystemInDarkTheme()
            }
            RamadhanTheme(darkTheme = darkTheme) {
                val homeVm: HomeViewModel = viewModel(factory = HomeViewModel.Factory(settingsStore))
                val questionsVm: QuestionsViewModel = viewModel(factory = QuestionsViewModel.Factory(settingsStore))
                AppNav(settingsVm, homeVm, questionsVm)
            }
        }
    }
}

private data class Tab(val route: String, val label: String, val icon: ImageVector)

private val tabs = listOf(
    Tab("home", "Beranda", Icons.Filled.Home),
    Tab("questions", "99 Tanya", Icons.Filled.QuestionAnswer),
    Tab("bukusaku", "Buku Saku", Icons.Filled.MenuBook),
    Tab("bookmarks", "Bookmark", Icons.Filled.Bookmark),
    Tab("settings", "Pengaturan", Icons.Filled.Settings)
)

@Composable
fun AppNav(
    settingsVm: SettingsViewModel,
    homeVm: HomeViewModel,
    questionsVm: QuestionsViewModel,
) {
    val navController = rememberNavController()
    val backStack by navController.currentBackStackEntryAsState()
    val currentRoute = backStack?.destination?.route ?: "home"
    Scaffold(
        bottomBar = {
            NavigationBar {
                for (tab in tabs) {
                    NavigationBarItem(
                        selected = currentRoute == tab.route,
                        onClick = {
                            navController.navigate(tab.route) {
                                popUpTo("home") { saveState = true }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = { Icon(tab.icon, contentDescription = tab.label) },
                        label = { Text(tab.label) }
                    )
                }
            }
        }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(padding)
        ) {
            composable("home") {
                HomeScreen(
                    homeVm = homeVm,
                    onOpenQuestions = { navController.navigate("questions") },
                    onOpenBukuSaku = { navController.navigate("bukusaku") }
                )
            }
            composable("questions") { QuestionsScreen(questionsVm, settingsVm) }
            composable("bukusaku") {
                BukuSakuScreen(
                    settingsVm = settingsVm,
                    onOpenSection = { sectionId -> navController.navigate("bukusaku/$sectionId") }
                )
            }
            composable(
                "bukusaku/{sectionId}",
                arguments = listOf(navArgument("sectionId") { type = NavType.StringType })
            ) { entry ->
                val sectionId = entry.arguments?.getString("sectionId") ?: ""
                BukuSakuDetailScreen(
                    sectionId = sectionId,
                    settingsVm = settingsVm,
                    onBack = { navController.popBackStack() }
                )
            }
            composable("bookmarks") {
                BookmarksScreen(
                    settingsVm = settingsVm,
                    onOpenQuestion = { id ->
                        questionsVm.setSearchQuery("")
                        questionsVm.toggleExpanded(id)
                        navController.navigate("questions")
                    },
                    onOpenSection = { sectionId -> navController.navigate("bukusaku/$sectionId") }
                )
            }
            composable("settings") { SettingsScreen(settingsVm) }
        }
    }
}
