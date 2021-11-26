package com.sistecredito.auth.practice.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.sistecredito.auth.practice.presentation.viewmodel.CustomerViewModel

@Composable
fun CustomerPage(
    navController: NavController,
    viewModel: CustomerViewModel = hiltViewModel()
) {

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
        if(state?.data!= null){

            if (state?.data.isEmpty()){
                Text(text = "La lista llega vacia🤐")
            }else{
                val tokenaux = state.data[0]?.url.toString()
                Text(text = "El token que llega es ($tokenaux)")
            }

        }
    }


}


















