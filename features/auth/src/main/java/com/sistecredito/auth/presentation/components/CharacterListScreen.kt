package com.sistecredito.auth.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items


import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.unit.dp


import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.sistecredito.auth.presentation.DataViewModel



@Composable
fun CharacterListScreen(
    navController: NavController,
    viewModel: DataViewModel = hiltViewModel()
){
    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize()){
        if(state.error.isNotBlank()){
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
        if(state?.data?.results != null){
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state?.data!!.results){ character ->
                    CharacterListItem(character = character) {}
                    //Text(character.name)
                }
            }
        }
    }


}