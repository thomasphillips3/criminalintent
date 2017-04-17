package com.thomasphillips3.criminalintent;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class CrimeListActivityTest2 {

    @Rule
    public ActivityTestRule<CrimeListActivity> mActivityTestRule = new ActivityTestRule<>(CrimeListActivity.class);

    @Test
    public void crimeListActivityTest2() {
        ViewInteraction actionMenuItemView = onView(
                allOf(withId(R.id.menu_item_new_crime), withContentDescription("New Crime"), isDisplayed()));
        actionMenuItemView.perform(click());

        ViewInteraction textView = onView(
                allOf(withText("CriminalIntent"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        textView.check(matches(withText("CriminalIntent")));

        ViewInteraction textView2 = onView(
                allOf(withText("Title"),
                        childAtPosition(
                                withParent(withId(R.id.activity_crime_pager_view_pager)),
                                0),
                        isDisplayed()));
        textView2.check(matches(withText("Title")));

        ViewInteraction editText = onView(
                allOf(withId(R.id.crime_title), withText("Enter a crime."),
                        childAtPosition(
                                withParent(withId(R.id.activity_crime_pager_view_pager)),
                                1),
                        isDisplayed()));
        editText.check(matches(withText("Enter a crime.")));

        ViewInteraction textView3 = onView(
                allOf(withText("Details"),
                        childAtPosition(
                                withParent(withId(R.id.activity_crime_pager_view_pager)),
                                2),
                        isDisplayed()));
        textView3.check(matches(withText("Details")));

        ViewInteraction button = onView(
                allOf(withId(R.id.crime_date),
                        childAtPosition(
                                withParent(withId(R.id.activity_crime_pager_view_pager)),
                                3),
                        isDisplayed()));
        button.check(matches(isDisplayed()));

        ViewInteraction button2 = onView(
                allOf(withId(R.id.crime_time),
                        childAtPosition(
                                withParent(withId(R.id.activity_crime_pager_view_pager)),
                                4),
                        isDisplayed()));
        button2.check(matches(isDisplayed()));

        ViewInteraction checkBox = onView(
                allOf(withId(R.id.crime_solved),
                        childAtPosition(
                                withParent(withId(R.id.activity_crime_pager_view_pager)),
                                5),
                        isDisplayed()));
        checkBox.check(matches(isDisplayed()));

        ViewInteraction button3 = onView(
                allOf(withId(R.id.crime_suspect),
                        childAtPosition(
                                withParent(withId(R.id.activity_crime_pager_view_pager)),
                                6),
                        isDisplayed()));
        button3.check(matches(isDisplayed()));

        ViewInteraction button4 = onView(
                allOf(withId(R.id.call_suspect_button),
                        childAtPosition(
                                withParent(withId(R.id.activity_crime_pager_view_pager)),
                                7),
                        isDisplayed()));
        button4.check(matches(isDisplayed()));

        ViewInteraction button5 = onView(
                allOf(withId(R.id.crime_report),
                        childAtPosition(
                                withParent(withId(R.id.activity_crime_pager_view_pager)),
                                8),
                        isDisplayed()));
        button5.check(matches(isDisplayed()));

        ViewInteraction button6 = onView(
                allOf(withId(R.id.delete_crime_button),
                        childAtPosition(
                                withParent(withId(R.id.activity_crime_pager_view_pager)),
                                9),
                        isDisplayed()));
        button6.check(matches(isDisplayed()));

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
