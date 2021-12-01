package com.sistecredito.shared.commons

sealed class Screen(val route : String){
    object CharacterListScreen : Screen("character_list_screen")
    object LoginPage : Screen("login_page")
    object LoginTrainigScreen : Screen("login_screen")
    object CostumerPage : Screen("costumer_page")
    object ProductPage : Screen("producto_page")
    object SeriePage : Screen("serie_page")
    object SerieDetailPage: Screen("serie_detail")
}
