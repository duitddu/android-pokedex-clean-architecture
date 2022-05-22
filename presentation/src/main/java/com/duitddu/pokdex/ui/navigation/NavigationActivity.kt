package com.duitddu.pokdex.ui.navigation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.duitddu.pokdex.ui.theme.PokedexTheme
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NavigationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexTheme {
                rememberSystemUiController().apply { ConfigSystemUi(this) }
                Scaffold {
                    val navController = rememberNavController()
                    NavigationScreen(navController)
                }
            }
        }
    }

    @Composable
    private fun ConfigSystemUi(controller: SystemUiController) {
        controller.apply {
            setSystemBarsColor(
                color = MaterialTheme.colors.primary
            )
        }
    }
}