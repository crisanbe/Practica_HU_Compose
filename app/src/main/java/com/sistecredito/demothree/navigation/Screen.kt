package com.sistecredito.demothree.navigation

sealed class Screen(val route : String){
    object CharacterListScreen : Screen("character_list_screen")
    object LoginPage : Screen("login_page")
    object LoginTrainigScreen : Screen("login_screen")
}
