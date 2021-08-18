package com.mohsin.motorwayassignment

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.mohsin.motorwayassignment.ui.main.MainViewModel
import junit.framework.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mock
import org.mockito.Mockito

class MainViewModelTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Test
    fun testWordCountIsZeroIfInputIsEmpty() {
        val mainViewModel = MainViewModel()
        mainViewModel.getWordCount("")
        Assert.assertEquals("Word Count: 0", mainViewModel.wordCount.value)
    }

    @Test
    fun testWordCountIsEqualToActualWordCountIfStringIsNotEmpty() {
        val mainViewModel = MainViewModel()
        val testString = "This is a test string."
        mainViewModel.getWordCount(testString)
        Assert.assertEquals("Word Count: 5", mainViewModel.wordCount.value)
    }
}