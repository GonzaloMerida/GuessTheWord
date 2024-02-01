package com.example.guesstheword.repositories

class WordsRepository {

    //private lateinit var _wordList : MutableList<String>
    //private var _wordList : MutableList<String> = mutableListOf()
    private var _wordList: MutableList<String> = mutableListOf()

    init {
        initList()
    }

    fun initList() : MutableList<String> {
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
        return resetList()
    }

    fun resetList(): MutableList<String> {
        _wordList.shuffle()
        return _wordList
    }

    val wordList: MutableList<String>
        get() =_wordList
}
