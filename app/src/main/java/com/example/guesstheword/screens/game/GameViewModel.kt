package com.example.guesstheword.screens.game

import android.util.Log
import androidx.lifecycle.ViewModel

//los view model nunca pueden tener instancias de fragmentos, es decir nunca deben tener instancias
//de elementos de capas superiores (UI). Solo pueden haber instancias de objetos de capas inferiores
//UI o Fragment, puede tener instancia del view model, pero no al revés.
class GameViewModel : ViewModel() {

    var i = 0

    init {
        Log.i("GameViewModel", "GameViewModel creado!")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel", "GameViewModel destruido!")
    }
}