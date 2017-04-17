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
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class CrimeListActivityTest3 {

    @Rule
    public ActivityTestRule<CrimeListActivity> mActivityTestRule = new ActivityTestRule<>(CrimeListActivity.class);

    @Test
    public void crimeListActivityTest3() {
        ViewInteraction actionMenuItemView = onView(
                allOf(withId(R.id.menu_item_new_crime), withContentDescription("New Crime"), isDisplayed()));
        actionMenuItemView.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.crime_title), isDisplayed()));
        appCompatEditText.perform(replaceText("test crime"), closeSoftKeyboard());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.crime_date), withText("Sunday, Apr 16, 2017"), isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(android.R.id.button1), withText("OK"),
                        withParent(allOf(withClassName(is("com.android.internal.widget.ButtonBarLayout")),
                                withParent(withClassName(is("android.widget.LinearLayout"))))),
                        isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.crime_time), withText("9:03 PM"), isDisplayed()));
        appCompatButton3.perform(click());

        ViewInteraction appCompatCheckedTextView = onView(
                allOf(withClassName(is("android.support.v7.widget.AppCompatCheckedTextView")), withText("PM"),
                        withParent(allOf(withClassName(is("android.widget.LinearLayout")),
                                withParent(withClassName(is("android.widget.RelativeLayout"))))),
                        isDisplayed()));
        appCompatCheckedTextView.perform(click());

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(android.R.id.button1), withText("OK"),
                        withParent(allOf(withId(R.id.buttonPanel),
                                withParent(withId(R.id.parentPanel)))),
                        isDisplayed()));
        appCompatButton4.perform(click());

        ViewInteraction appCompatCheckBox = onView(
                allOf(withId(R.id.crime_solved), withText("Solved"), isDisplayed()));
        appCompatCheckBox.perform(click());

        ViewInteraction appCompatImageButton = onView(
                allOf(withContentDescription("Navigate up"),
                        withParent(allOf(withId(R.id.action_bar),
                                withParent(withId(R.id.action_bar_container)))),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction actionMenuItemView2 = onView(
                allOf(withId(R.id.menu_item_show_total), withContentDescription("Show Total"), isDisplayed()));
        actionMenuItemView2.perform(click());

        ViewInteraction textView = onView(
                allOf(withText("1 crime"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        textView.check(matches(withText("1 crime")));

        ViewInteraction textView2 = onView(
                allOf(withText("CriminalIntent"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                0),
                        isDisplayed()));
        textView2.check(matches(withText("CriminalIntent")));

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.list_item_crime_title_text_view), withText("test crime"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.crime_recycler_view),
                                        0),
                                0),
                        isDisplayed()));
        textView3.check(matches(withText("test crime")));

        ViewInteraction textView4 = onView(
                allOf(withId(R.id.list_item_crime_date_text_view), withText("Thu Apr 20 04:20:00 PDT 2017"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.crime_recycler_view),
                                        0),
                                1),
                        isDisplayed()));
        textView4.check(matches(withText("Thu Apr 20 04:20:00 PDT 2017")));

        ViewInteraction checkBox = onView(
                allOf(withId(R.id.list_item_crime_solved_check_box),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.crime_recycler_view),
                                        0),
                                2),
                        isDisplayed()));
        checkBox.check(matches(isDisplayed()));

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
