package com.sistecredito.demothree

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sistecredito.auth.serie.presentation.getAll.components.SeriePage
import com.sistecredito.auth.serie.presentation.getById.components.SerieDetailPage

import com.sistecredito.demothree.navigation.Screen
import com.sistecredito.demothree.ui.theme.DemothreeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemothreeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                    /*val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CharacterListScreen.route
                    ) {
                        composable(
                            route = Screen.CharacterListScreen.route
                        ) {
                            CharacterListScreen(navController)
                        }

                    }*/
                    val navController = rememberNavController()
                    NavHost(navController, startDestination = Screen.SeriePage.route
                    ) {
                        composable(route = Screen.SeriePage.route){
                            SeriePage(navController)
                        }
                        composable(route = "serie_detail"+"/{serieId}"){
                            SerieDetailPage()
                        }

                    }
                }
            }
        }
    }
}
