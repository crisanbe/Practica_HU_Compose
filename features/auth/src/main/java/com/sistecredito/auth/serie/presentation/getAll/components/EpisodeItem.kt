package com.sistecredito.auth.serie.presentation.getAll.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.sistecredito.auth.serie.data.remote.dto.ResultsDto

@Composable
fun EpisodeItem(
    episode: ResultsDto,
    onItemClick:(ResultsDto) -> Unit
){

    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 2.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
            .clickable {
                onItemClick(episode)
            }
    ) {
        Row(modifier = Modifier.animateContentSize()) {
            Image(
                painter = rememberImagePainter(episode.url),
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
                    text = episode.name,
                    style = MaterialTheme.typography.h6
                )
            }
        }
    }


}