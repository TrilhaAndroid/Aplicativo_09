package br.com.leonardobarral.application_09.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.leonardobarral.application_09.componets.CardGameComponent
import br.com.leonardobarral.application_09.componets.CardStudioComponent
import br.com.leonardobarral.application_09.models.GameViewModel
import br.com.leonardobarral.application_09.repositories.getAllGames
import br.com.leonardobarral.application_09.repositories.getGamesByStudio

@Composable
fun GameScreen(gameViewModel: GameViewModel) {

    val searchStudio by gameViewModel.searchStudios.observeAsState(initial = "")
    val listGame by gameViewModel.listGame.observeAsState(initial = getAllGames())

    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Meus jogos favoritos",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = searchStudio,
            onValueChange = {
                gameViewModel.updateSearchStudio(it)
                gameViewModel.updateListGame(getGamesByStudio(searchStudio))
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Nome do estúdio")
            },
            trailingIcon = {
                IconButton(onClick = {
                }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = ""
                    )
                }
            }
        )
        Spacer(modifier = Modifier.height(8.dp))

        LazyRow(userScrollEnabled = true ){
            items(listGame){ it ->
                CardStudioComponent(
                    game = it,
                    updateSearchStudio = {
                        gameViewModel.updateSearchStudio(it)
                    },
                    updateListGame = {gameViewModel.updateListGame(getGamesByStudio(searchStudio))}
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn(
            userScrollEnabled = true
        ){
            items(listGame){
                CardGameComponent(game = it)
                Spacer(modifier = Modifier.height(5.dp))
            }
        }
    }
}
