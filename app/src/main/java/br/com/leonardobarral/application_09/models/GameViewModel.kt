package br.com.leonardobarral.application_09.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel:ViewModel() {

    private val _searchStudio = MutableLiveData<String>()
    val searchStudios: LiveData<String> = _searchStudio

    fun updateSearchStudio(novoValor:String){
        _searchStudio.value = novoValor
    }

    private val _listGame = MutableLiveData<List<Game>>()
    val listGame:LiveData<List<Game>> = _listGame

    fun updateListGame(novoValor: List<Game>){
        _listGame.value = novoValor
    }

}