package com.sistecredito.auth.productos.presentation.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.sistecredito.auth.practice.presentation.components.MealCategory
import com.sistecredito.auth.productos.data.remote.dto.ResultDto
import com.sistecredito.auth.productos.presentation.viewmodel.ProductViewModel

@Composable
fun ProductPage(
    navigationCallback: (String) -> Unit,
) {
    val viewModel: ProductViewModel = hiltViewModel()
    val state = viewModel.state.value


    Box(modifier = Modifier.fillMaxSize()) {
        if (state.error.isNotBlank()) {
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


        LazyColumn(modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(15.dp)) {
            state.data?.let {
                items(it.results) { meal ->
                    MealCategor(meal, navigationCallback)
                }
            }

        }
    }
}
    @Composable
    fun MealCategor(meal: ResultDto, navigationCallback: (String) -> Unit) {
        var isExpanded by remember { mutableStateOf(false) }
        Card(
            shape = RoundedCornerShape(8.dp),
            elevation = 2.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .clickable {
                    navigationCallback(meal.name)//pasamos la posicion po medio del navigationCallback
                }
        ) {
            Row(modifier = Modifier.animateContentSize()) {
                Image(
                    painter = rememberImagePainter(meal.url),
                    contentDescription = null,
                    modifier = Modifier
                        .size(88.dp)
                        .padding(4.dp)
                        .align(Alignment.CenterVertically)
                )
                Column(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .fillMaxWidth(0.8f)
                        .padding(16.dp)
                ) {
                    Text(
                        text = meal.name,
                        style = MaterialTheme.typography.h6
                    )
                }
            }
        }


}



/*
if(state?.data!= null){

    if (state?.data.isEmpty()){
        Text(text = "La lista llega vacia🤐")
    }else{
        val tokenaux = state.data[0]?.title.toString()
        Text(text = "El token que llega es ($tokenaux)")
    }

}
*/


















