package com.sistecredito.auth.character.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.sistecredito.auth.character.data.remote.dto.Result

@Composable
fun CharacterListItem(character: Result, onItemClick: (Result) -> Unit) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable{onItemClick(character)}
        .padding(30.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            text = "${character.name} . ${character.created} (${character.gender})",
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = if(character.status == "Alive") "active" else "inactive",
            color = if(character.status == "Dead") Color.Green else Color.Red,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}