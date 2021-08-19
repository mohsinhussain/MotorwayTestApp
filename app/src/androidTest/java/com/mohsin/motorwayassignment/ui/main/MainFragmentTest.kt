package com.mohsin.motorwayassignment.ui.main

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mohsin.motorwayassignment.R
import junit.framework.TestCase
import org.hamcrest.Matchers.containsString
import org.hamcrest.Matchers.not
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainFragmentTest: TestCase() {

    private lateinit var scenario: FragmentScenario<MainFragment>

    @Before
    fun setup() {
        scenario = launchFragmentInContainer(themeResId = R.style.Theme_MotorwayAssignment)
        scenario.moveToState(Lifecycle.State.STARTED)
    }

    @Test
    fun testInputTextFieldIsNotEmptyWhenAppStarts() {
        onView(withId(R.id.inputTextField)).check(matches(withText("This is the initial text. We will be observing this information.")))
    }

    @Test
    fun testEnteringTextUpdatesWordCount() {
        val testString = " This is a test string"
        val expectedString = "Word Count: 16"
        onView(withId(R.id.inputTextField)).perform(typeText(testString))
        onView(withId(R.id.wordCountTextView)).check(matches(withText(expectedString)))
    }

}