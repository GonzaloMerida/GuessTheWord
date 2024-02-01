package com.example.guesstheword.screens.game

import android.provider.Settings.Global.getString
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras
import com.google.android.material.snackbar.Snackbar
import com.example.guesstheword.R
import com.example.guesstheword.app.MyApp
import com.example.guesstheword.repositories.WordsRepository

class GameViewModel(val wordsRepository: WordsRepository) : ViewModel() {

    companion object {
        const val WORD_EMPTY = "no word"

        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                // Get the Application object from extras
                val application = checkNotNull(extras[APPLICATION_KEY])

                return GameViewModel(
                    (application as MyApp).appContainer.wordsRepository,
                ) as T
            }
        }
    }

    private var _score : Int = 0
    val score get() = _score

    private var _word : String = ""
    val word get() = _word

    private var _wordList : MutableList<String> = mutableListOf<String>()
    val wordList get() = _wordList

    init {
        Log.i("GameViewModel", "GameViewModel creado!")
        _wordList = wordsRepository.initList()
        nextWord()
    }
    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel", "GameViewModel destruido!")
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
        else{
            _word = WORD_EMPTY
        }
       //else{
       //     _word = getString(R.string.word_empty)
            //Snackbar.make(binding.Root,R.string.word_empty, Snackbar.LENGTH_SHORT).show()
            //de forma automática recoge el view en el que se ha pulsado con requireView()
        //    Snackbar.make(requireView(),R.string.word_empty, Snackbar.LENGTH_SHORT).show()
        //    disableButtons()
       // }
    }

}