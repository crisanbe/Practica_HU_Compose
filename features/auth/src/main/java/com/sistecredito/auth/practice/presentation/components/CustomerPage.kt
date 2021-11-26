package com.sistecredito.auth.practice.presentation.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.sistecredito.auth.practice.presentation.viewmodel.CustomerViewModel
import kotlin.math.min

@Composable
fun CustomerPage(
    navController: NavController,
    viewModel: CustomerViewModel = hiltViewModel()
) {

    val state = viewModel.state.value
    val scrollState = rememberLazyListState()
    val offset = min(1f,1 -
            (scrollState.firstVisibleItemScrollOffset / 600f
                    + scrollState.firstVisibleItemIndex))
    val size by animateDpAsState(targetValue = max(100.dp, 140.dp * offset))



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

        Surface(color = MaterialTheme.colors.background) {
            Column {
                Surface(elevation = 4.dp) {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Card(
                            modifier = Modifier.padding(16.dp),
                            shape = CircleShape,
                            border = BorderStroke(
                                width = 2.dp,
                                color = Color.Green
                            )
                        ) {
                             Image(
                                painter = rememberImagePainter(
                                    data = null,
                                    builder = {
                                        transformations(CircleCropTransformation())
                                    }
                                ),
                                contentDescription = null,
                                modifier = androidx.compose.ui.Modifier
                                    .size(size)
                            )
                        }
                        Text(
                            text = state.data[0]?.title.toString(),
                            modifier = Modifier
                                .padding(16.dp)
                                .align(Alignment.CenterVertically)
                        )
                    }
                }
                val dummyContenList = (0..100).map { it.toString() }//cuando llegue el scrool a cero se infla la imagen
                LazyColumn(state = scrollState) {
                    items(dummyContenList){ dummyItem ->
                        Text(text = dummyItem, modifier = Modifier.padding(24.dp))
                    }
                }
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


















