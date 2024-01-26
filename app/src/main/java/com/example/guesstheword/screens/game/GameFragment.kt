/*
 * Copyright (C) 2019 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.guesstheword.screens.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.guesstheword.R
import com.example.guesstheword.databinding.GameFragmentBinding
import com.google.android.material.snackbar.Snackbar

/**
 * Fragment where the game is played
 */
class GameFragment : Fragment() {


    // The current word
    private var word = ""

    // The current score
    private var score = 0

    // The list of words - the front of the list is the next word to guess
    private lateinit var wordList: MutableList<String>

    private lateinit var binding: GameFragmentBinding

    private val gameVM : GameViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate view and obtain an instance of the binding class
        binding = GameFragmentBinding.inflate(inflater,container,false)

        gameVM.i = 3

        resetList()
        nextWord()

        binding.correctButton.setOnClickListener { onCorrect() }
        binding.skipButton.setOnClickListener { onSkip() }
        updateScoreText()
        updateWordText()

        return binding.root

    }

    /**
     * Resets the list of words and randomizes the order
     */
    private fun resetList() {
        wordList = mutableListOf(
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

    /** Methods for buttons presses **/

    private fun onSkip() {
        score--
        nextWord()
    }

    private fun onCorrect() {
        score++
        nextWord()
    }

    /**
     * Moves to the next word in the list
     */
    private fun nextWord() {
        if (!wordList.isEmpty()) {
            //Select and remove a word from the list
            word = wordList.removeAt(0)
        }
        else{
            word = getString(R.string.word_empty)
            //Snackbar.make(binding.Root,R.string.word_empty, Snackbar.LENGTH_SHORT).show()
            //de forma automática recoge el view en el que se ha pulsado con requireView()
            Snackbar.make(requireView(),R.string.word_empty, Snackbar.LENGTH_SHORT).show()
            disableButtons()
        }
        //como si la lista está vacía se deshabilitan los botones, no se incrementará ni reducirá
        //la puntuación. Si se pudiesen pulsar los botones, el updateScore debería ir en la parte
        //del if (debajo de word = wordList.removeAt(0)
        updateWordText()
        updateScoreText()
    }




    /** Methods for updating the UI **/

    private fun disableButtons(){
        binding.correctButton.isEnabled = false
        binding.skipButton.isEnabled = false
    }

    private fun updateWordText() {
        binding.wordText.text = word
    }

    private fun updateScoreText() {
        binding.scoreText.text = score.toString()
    }
}
