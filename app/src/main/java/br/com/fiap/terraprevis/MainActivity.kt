package br.com.fiap.terraprevis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import br.com.fiap.terraprevis.screens.AlertsScreen
import br.com.fiap.terraprevis.screens.DashboardScreen
import br.com.fiap.terraprevis.screens.MapScreen
import br.com.fiap.terraprevis.ui.theme.TerraPrevisTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TerraPrevisTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainNavigationContainer()
                }
            }
        }
    }
}


data class NavigationItem(val title: String, val icon: ImageVector, val screenIndex: Int)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainNavigationContainer() {

    var selectedScreen by remember { mutableStateOf(1) }


    val navigationItems = listOf(
        NavigationItem("Mapa", Icons.Default.LocationOn, 0),
        NavigationItem("Painel", Icons.Default.Home, 1),
        NavigationItem("Alertas", Icons.Default.Warning, 2)
    )

    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.primary
            ) {
                navigationItems.forEach { item ->
                    NavigationBarItem(
                        selected = selectedScreen == item.screenIndex,
                        onClick = { selectedScreen = item.screenIndex },
                        label = { Text(text = item.title) },
                        icon = {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.title,
                                tint = if (selectedScreen == item.screenIndex)
                                    MaterialTheme.colorScheme.primary
                                else
                                    MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f)
                        )
                    )
                }
            }
        }
    ) { innerPadding ->

        Box(modifier = Modifier.padding(innerPadding)) {
            when (selectedScreen) {
                0 -> MapScreen()
                1 -> DashboardScreen()
                2 -> AlertsScreen()
            }
        }
    }
}