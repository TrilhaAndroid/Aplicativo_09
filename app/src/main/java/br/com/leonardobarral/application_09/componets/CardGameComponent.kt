package br.com.leonardobarral.application_09.componets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.leonardobarral.application_09.models.Game

@Composable
fun CardGameComponent(game: Game) {



    Card (
        modifier = Modifier
            .fillMaxSize(),
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray
        )
    ){
        Row (
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp),
            verticalAlignment = Alignment.CenterVertically

        ){
            Column (
                modifier = Modifier
                    .fillMaxWidth(0.8f),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ){
                Text(
                    text = game.title,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = game.studio,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Gray
                )
            }
            Column (
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.End
            ){
                Text(
                    text = "${game.releaseYear}",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Blue,
                    modifier = Modifier
                        .fillMaxHeight(),

                )
            }
        }
    }
}