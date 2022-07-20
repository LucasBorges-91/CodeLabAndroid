package br.com.portal.tiptime

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.containsString
import androidx.test.espresso.assertion.ViewAssertions.matches


import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
//    @Test
//    fun useAppContext() {
//        // Context of the app under test.
//        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
//        assertEquals("br.com.portal.tiptime", appContext.packageName)
//    }

    @get:Rule()
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun calculate_18_percent_tip() {
        onView(withId(R.id.cost_of_service_tiet))
            .perform(typeText("50.00"))

        onView(withId(R.id.calculate_bt)).perform(scrollTo(), click())

        onView(withId(R.id.tip_result_tv))
            .check(matches(withText(containsString("$9.00"))))
    }

    @Test
    fun calculate_tip_cost_service_empty() {
        onView(withId(R.id.cost_of_service_tiet))
            .perform(typeText(""))

        onView(withId(R.id.calculate_bt)).perform(scrollTo(), click())

        onView(withId(R.id.tip_result_tv))
            .check(matches(withText(containsString("$0.0"))))
    }

    @Test
    fun calculate_20_percent_tip() {
        onView(withId(R.id.cost_of_service_tiet))
            .perform(typeText("50.00"))

        onView(withId(R.id.tip_twenty_rb)).perform(click())
        onView(withId(R.id.calculate_bt)).perform(scrollTo(), click())

        onView(withId(R.id.tip_result_tv))
            .check(matches(withText(containsString("$10.00"))))
    }

    @Test
    fun calculate_15_percent_tip() {
        onView(withId(R.id.cost_of_service_tiet))
            .perform(typeText("50.00"))

        onView(withId(R.id.tip_fifteen_rb)).perform(click())
        onView(withId(R.id.calculate_bt)).perform(scrollTo(), click())

        onView(withId(R.id.tip_result_tv))
            .check(matches(withText(containsString("$8.00"))))
    }

    @Test
    fun calculate_15_percent_tip_uncheked_roundUp() {
        onView(withId(R.id.cost_of_service_tiet))
            .perform(typeText("50.00"))

        onView(withId(R.id.tip_fifteen_rb)).perform(click())
        onView(withId(R.id.round_tip_switch)).perform(click())
        onView(withId(R.id.calculate_bt)).perform(scrollTo(), click())

        onView(withId(R.id.tip_result_tv))
            .check(matches(withText(containsString("$7.50"))))
    }
}