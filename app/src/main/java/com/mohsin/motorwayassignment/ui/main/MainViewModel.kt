package com.mohsin.motorwayassignment.ui.main

import androidx.lifecycle.*

class MainViewModel : ViewModel() {

    //variable that will listen to user's input
    val userInput = MutableLiveData<String>("This is the initial text. We will be overserving this information.")
    //variable that will display the word count
    val wordCount = MutableLiveData("Word Count: 0")


    // Here word count is being updated which bound layout, updating itself on the view
    fun getWordCount(input: String) {
        val trimmedStr = input.trim()
        if (trimmedStr.isEmpty()) {
            wordCount.value = "Word Count: 0"
        } else {
            wordCount.value = "Word Count: " + trimmedStr.split("\\s+".toRegex()).size.toString()
        }
    }
}