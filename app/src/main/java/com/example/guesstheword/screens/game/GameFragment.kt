package com.example.guesstheword.screens.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.guesstheword.databinding.GameFragmentBinding

/**
 * Fragment where the game is played
 */
class GameFragment : Fragment() {

    private lateinit var binding: GameFragmentBinding

    private val gameVM : GameViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate view and obtain an instance of the binding class
        binding = GameFragmentBinding.inflate(inflater,container,false)

        //initialization.
        updateScoreText()
        updateWordText()

        //Listeners
        binding.correctButton.setOnClickListener { onCorrect() }
        binding.skipButton.setOnClickListener { onSkip() }

        return binding.root

    }

    fun onSkip() {
        gameVM.onSkip()
        updateWordText()
        updateScoreText()
    }

    fun onCorrect() {
        gameVM.onCorrect()
        updateWordText()
        updateScoreText()
    }


    /** Methods for updating the UI **/

    private fun updateWordText() {
        binding.wordText.text = gameVM.word
    }

    private fun updateScoreText() {
        binding.scoreText.text = gameVM.score.toString()
    }

    private fun disableButtons(){
        binding.correctButton.isEnabled = false
        binding.skipButton.isEnabled = false
    }
}