package br.com.leonardobarral.application_09.componets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.com.leonardobarral.application_09.models.Game

@Composable
fun CardStudioComponent(
    game: Game,
    updateSearchStudio: (String) -> Unit,
    updateListGame:() -> Unit
) {
    Card (
        modifier = Modifier
            .minimumInteractiveComponentSize()
            .height(50.dp)
            .padding(4.dp),
        colors = CardDefaults.cardColors(
            contentColor = Color(0x00000000)
        )
    ){
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ){
            Button(
                modifier = Modifier.fillMaxSize(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0x00000000)
                ),
                onClick = {
                    updateSearchStudio(game.studio)
                    updateListGame()
                }) {
                Text(text = game.studio,color= Color.DarkGray)
            }
        }
    }

}