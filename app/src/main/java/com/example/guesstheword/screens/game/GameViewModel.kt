package com.example.guesstheword.screens.game

import android.provider.Settings.Global.getString
import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.android.material.snackbar.Snackbar

class GameViewModel : ViewModel() {

    private var _score : Int = 0
    val score get() = _score

    private var _word : String = ""
    val word get() = _word

    private var _wordList : MutableList<String> = mutableListOf<String>()
    val wordList get() = _wordList


    init {
        Log.i("GameViewModel", "GameViewModel creado!")
        resetList()
        nextWord()
    }
    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel", "GameViewModel destruido!")
    }

    fun resetList() {
        _wordList = mutableListOf(
            "queen",
            "hospital",
            "basketball",
            "cat",
            "change",
            "snail",
            "soup",
            "calendar",
            "sad",
            "desk",
            "guitar",
            "home",
            "railway",
            "zebra",
            "jelly",
            "car",
            "crow",
            "trade",
            "bag",
            "roll",
            "bubble"
        )
        wordList.shuffle()
    }

    fun onSkip() {
        _score--
        nextWord()
    }

    fun onCorrect() {
        _score++
        nextWord()
    }

    fun nextWord() {
        if (!wordList.isEmpty()) {
            //Select and remove a word from the list
            _word = wordList.removeAt(0)
        }
       // else{
       //     _word = getString(R.string.word_empty)
            //Snackbar.make(binding.Root,R.string.word_empty, Snackbar.LENGTH_SHORT).show()
            //de forma automática recoge el view en el que se ha pulsado con requireView()
        //    Snackbar.make(requireView(),R.string.word_empty, Snackbar.LENGTH_SHORT).show()
        //    disableButtons()
       // }
    }


}