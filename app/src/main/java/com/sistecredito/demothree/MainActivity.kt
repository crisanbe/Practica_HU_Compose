package com.sistecredito.demothree

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sistecredito.auth.practice.presentation.components.CustomerPage
import com.sistecredito.auth.productos.presentation.components.ProductPage

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
                    NavHost(navController, startDestination = Screen.CostumerPage.route
                    ) {
                        composable(route = Screen.CostumerPage.route){
                            ProductPage(){ navigationMealId ->//meal_category_id
                                //navController.navigate("destination_meal_details/$navigationMealId")
                            }
                        }

                    }
                }
            }
        }
    }
}
