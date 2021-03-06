package ir.adicom.app.beginneridea.espresso

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import ir.adicom.app.beginneridea.R
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class EspressoActivityTest {
    @get:Rule var activityScenarioRule = activityScenarioRule<EspressoActivity>()

    @Test
    fun changeText_sameActivity() {
        onView(withId(R.id.editTextUserInput))
            .perform(typeText("STRING_TO_BE_TYPED"), closeSoftKeyboard())
        onView(withId(R.id.changeTextBt)).perform(click())

        onView(withId(R.id.textToBeChanged)).check(matches(withText("STRING_TO_BE_TYPED")))
    }

    @Test
    fun changeText_newActivity() {
        onView(withId(R.id.editTextUserInput)).perform(typeText("STRING_TO_BE_TYPED"),
            closeSoftKeyboard())
        onView(withId(R.id.activityChangeTextBtn)).perform(click())

        onView(withId(R.id.show_text_view)).check(matches(withText("STRING_TO_BE_TYPED")))
    }

    @Test
    fun checkButton_isDisplayed() {
        onView(withText("Change Text")).check(matches(isDisplayed()))
    }
}