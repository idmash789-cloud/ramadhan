package com.sembilansembilan.pertanyaanseputarramadhan

import android.app.Activity
import android.os.Bundle
import android.os.SystemClock
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
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
import com.sembilansembilan.pertanyaanseputarramadhan.imsakiyah.SunnahReminderScheduler
import com.sembilansembilan.pertanyaanseputarramadhan.imsakiyah.TadarusReminderWorker
import com.sembilansembilan.pertanyaanseputarramadhan.ui.HomeViewModel
import com.sembilansembilan.pertanyaanseputarramadhan.ui.PissKtbViewModel
import com.sembilansembilan.pertanyaanseputarramadhan.ui.QuestionsViewModel
import com.sembilansembilan.pertanyaanseputarramadhan.ui.SettingsViewModel
import com.sembilansembilan.pertanyaanseputarramadhan.ui.SunnahViewModel
import com.sembilansembilan.pertanyaanseputarramadhan.ui.TadarusViewModel
import com.sembilansembilan.pertanyaanseputarramadhan.ui.ZakatViewModel
import com.sembilansembilan.pertanyaanseputarramadhan.ui.components.AdBanner
import com.sembilansembilan.pertanyaanseputarramadhan.ui.screens.BookmarksScreen
import com.sembilansembilan.pertanyaanseputarramadhan.ui.screens.BukuSakuDetailScreen
import com.sembilansembilan.pertanyaanseputarramadhan.ui.screens.BukuSakuScreen
import com.sembilansembilan.pertanyaanseputarramadhan.ui.screens.HomeScreen
import com.sembilansembilan.pertanyaanseputarramadhan.ui.screens.KultumDetailScreen
import com.sembilansembilan.pertanyaanseputarramadhan.ui.screens.KultumScreen
import com.sembilansembilan.pertanyaanseputarramadhan.ui.screens.NuOnlineDetailScreen
import com.sembilansembilan.pertanyaanseputarramadhan.ui.screens.NuOnlineScreen
import com.sembilansembilan.pertanyaanseputarramadhan.ui.screens.PissKtbScreen
import com.sembilansembilan.pertanyaanseputarramadhan.ui.screens.QuestionsScreen
import com.sembilansembilan.pertanyaanseputarramadhan.ui.screens.SettingsScreen
import com.sembilansembilan.pertanyaanseputarramadhan.ui.screens.SunnahScreen
import com.sembilansembilan.pertanyaanseputarramadhan.ui.screens.TadarusScreen
import com.sembilansembilan.pertanyaanseputarramadhan.ui.screens.ZakatScreen
import com.sembilansembilan.pertanyaanseputarramadhan.ui.theme.RamadhanTheme
import com.sembilansembilan.pertanyaanseputarramadhan.util.AdMobHelper
import com.sembilansembilan.pertanyaanseputarramadhan.util.ConsentManager
import com.sembilansembilan.pertanyaanseputarramadhan.util.InterstitialGate
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val settingsStore = SettingsStore(applicationContext)
        // Inisialisasi iklan setelah UMP mengizinkan permintaan iklan.
        ConsentManager.requestConsent(this) {
            AdMobHelper.initialize(this)
        }
        // Jadwalkan ulang pengingat bila aktif (mis. setelah aplikasi di-update).
        lifecycleScope.launch {
            val settings = settingsStore.getSettings()
            if (settings.remindersEnabled) {
                ReminderScheduler.schedule(applicationContext, settings.cityName)
            }
            // QW-4: jadwalkan ulang pengingat puasa sunnah bila aktif.
            if (settings.sunnahRemindersEnabled) {
                SunnahReminderScheduler.schedule(applicationContext)
            }
        }
        lifecycleScope.launch {
            settingsStore.settings
                .map { it.tadarusReminderEnabled }
                .distinctUntilChanged()
                .collect { enabled ->
                    TadarusReminderWorker.updateSchedule(applicationContext, enabled)
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
                val pissVm: PissKtbViewModel = viewModel(factory = PissKtbViewModel.Factory(settingsStore))
                val zakatVm: ZakatViewModel = viewModel(factory = ZakatViewModel.Factory(settingsStore))
                val sunnahVm: SunnahViewModel = viewModel(factory = SunnahViewModel.Factory())
                val tadarusVm: TadarusViewModel = viewModel(factory = TadarusViewModel.Factory(settingsStore))
                AppNav(settingsVm, homeVm, questionsVm, pissVm, zakatVm, sunnahVm, tadarusVm)
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
    pissVm: PissKtbViewModel,
    zakatVm: ZakatViewModel,
    sunnahVm: SunnahViewModel,
    tadarusVm: TadarusViewModel,
) {
    val navController = rememberNavController()
    val backStack by navController.currentBackStackEntryAsState()
    val currentRoute = backStack?.destination?.route ?: "home"
    Scaffold(
        topBar = {
            NavigationBar(
                windowInsets = WindowInsets.statusBars.only(WindowInsetsSides.Top + WindowInsetsSides.Horizontal)
            ) {
                for (tab in tabs) {
                    NavigationBarItem(
                        selected = currentRoute == tab.route,
                        onClick = {
                            if (tab.route == "home") {
                                navController.popBackStack("home", inclusive = false)
                            } else {
                                navController.navigate(tab.route) {
                                    popUpTo("home") { saveState = true }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        },
                        icon = { Icon(tab.icon, contentDescription = tab.label) },
                        label = { Text(tab.label) }
                    )
                }
            }
        },
        bottomBar = { AdBanner() }
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
                    onOpenBukuSaku = { navController.navigate("bukusaku") },
                    onOpenNu = { navController.navigate("nu") },
                    onOpenPiss = { navController.navigate("piss") },
                    onOpenKultum = { navController.navigate("kultum") },
                    onOpenZakat = { navController.navigate("zakat") },
                    onOpenSunnah = { navController.navigate("sunnah") },
                    onOpenTadarus = { navController.navigate("tadarus") }
                )
            }
            composable("questions") { QuestionsScreen(questionsVm, settingsVm) }
            composable("zakat") { ZakatScreen(zakatVm) }
            composable("sunnah") { SunnahScreen(sunnahVm) }
            composable("tadarus") { TadarusScreen(tadarusVm) }
            composable("nu") {
                NuOnlineScreen(
                    settingsVm = settingsVm,
                    onOpenArticle = { articleId -> navController.navigate("nu/$articleId") }
                )
            }
            composable(
                "nu/{articleId}",
                arguments = listOf(navArgument("articleId") { type = NavType.StringType })
            ) { entry ->
                val articleId = entry.arguments?.getString("articleId") ?: ""
                NuOnlineDetailScreen(
                    articleId = articleId,
                    settingsVm = settingsVm,
                    onBack = readingBackAction { navController.popBackStack() }
                )
            }
            composable("piss") { PissKtbScreen(pissVm, settingsVm) }
            composable("kultum") {
                KultumScreen(
                    settingsVm = settingsVm,
                    onOpenKultum = { night -> navController.navigate("kultum/$night") }
                )
            }
            composable(
                "kultum/{night}",
                arguments = listOf(navArgument("night") { type = NavType.IntType })
            ) { entry ->
                val night = entry.arguments?.getInt("night") ?: 1
                KultumDetailScreen(
                    night = night,
                    settingsVm = settingsVm,
                    onBack = readingBackAction { navController.popBackStack() }
                )
            }
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
                    onBack = readingBackAction { navController.popBackStack() }
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
                    onOpenSection = { sectionId -> navController.navigate("bukusaku/$sectionId") },
                    onOpenArticle = { articleId -> navController.navigate("nu/$articleId") },
                    onOpenPiss = { id ->
                        pissVm.setSearchQuery("")
                        pissVm.toggleExpanded(id)
                        navController.navigate("piss")
                    },
                    onOpenKultum = { night -> navController.navigate("kultum/$night") }
                )
            }
            composable("settings") { SettingsScreen(settingsVm) }
        }
    }
}

@Composable
private fun readingBackAction(onExit: () -> Unit): () -> Unit {
    val activity = LocalContext.current as? Activity
    val openedAt = remember { SystemClock.elapsedRealtime() }
    val adsReady by AdMobHelper.adsReady.collectAsState()
    LaunchedEffect(activity, adsReady) {
        if (activity != null && adsReady) InterstitialGate.preload(activity.applicationContext)
    }
    val close = {
        if (activity == null) {
            onExit()
        } else {
            InterstitialGate.onReadingExit(activity, openedAt, onExit)
        }
    }
    BackHandler(onBack = close)
    return close
}
