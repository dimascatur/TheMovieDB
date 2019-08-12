package com.dicoding.picodiploma.themoviedb.ui.home;

import android.content.Context;
import android.content.Intent;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import com.dicoding.picodiploma.themoviedb.R;
import com.dicoding.picodiploma.themoviedb.utils.EspressoIdlingResource;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class HomeActivityTest {

    @Rule
    public ActivityTestRule<HomeActivity> activityRule = new ActivityTestRule<HomeActivity>(HomeActivity.class) {
        @Override
        protected Intent getActivityIntent() {
            Context targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
            Intent result = new Intent(targetContext, HomeActivity.class);
            return result;
        }
    };

    @Before
    public void setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource());

    }

    @After
    public void tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @Test
    public void TestFavoriteMovie() {
        onView(withText("Spider Man Far From Home")).check(ViewAssertions.matches(isDisplayed()));
        onView(withText("Spider Man Far From Home")).perform(click());
        onView(withId(R.id.img_bg)).check(ViewAssertions.matches(isDisplayed()));
        onView(withId(R.id.action_bookmark)).perform(click());
        pressBack();
        onView(withId(R.id.favorite_movie)).check(ViewAssertions.matches(isDisplayed()));
        onView(withId(R.id.favorite_movie)).perform(click());
        onView(withId(R.id.rv_favorite_movie)).check(ViewAssertions.matches(isDisplayed()));
        onView(withText("Spider Man Far From Home")).check(ViewAssertions.matches(isDisplayed()));
        onView(withText("Spider Man Far From Home")).perform(click());
        onView(withId(R.id.img_bg)).check(ViewAssertions.matches(isDisplayed()));
        onView(withId(R.id.action_bookmark)).perform(click());
    }

    @Test
    public void TestFavoriteTvShow(){
        onView(withId(R.id.action_tvShow)).perform(click());
        onView(withText("One-Punch Man")).check(ViewAssertions.matches(isDisplayed()));
        onView(withText("One-Punch Man")).perform(click());
        onView(withId(R.id.img_bg)).check(ViewAssertions.matches(isDisplayed()));
        onView(withId(R.id.action_bookmark)).perform(click());
        pressBack();
        onView(withId(R.id.favorite_tv)).check(ViewAssertions.matches(isDisplayed()));
        onView(withId(R.id.favorite_tv)).perform(click());
        onView(withId(R.id.rv_favorite_tv)).check(ViewAssertions.matches(isDisplayed()));
        onView(withText("One-Punch Man")).check(ViewAssertions.matches(isDisplayed()));
        onView(withText("One-Punch Man")).perform(click());
        onView(withId(R.id.img_bg)).check(ViewAssertions.matches(isDisplayed()));
        onView(withId(R.id.action_bookmark)).perform(click());
    }

    @Test
    public void TestNavigationView() {
        onView(withId(R.id.action_movie)).perform(click());
        onView(withText("Spider Man Far From Home")).check(ViewAssertions.matches(isDisplayed()));
        onView(withId(R.id.action_tvShow)).perform(click());
        onView(withText("One-Punch Man")).check(ViewAssertions.matches(isDisplayed()));
        onView(withId(R.id.favorite_movie)).perform(click());
        onView(withId(R.id.favorite_tv)).perform(click());
    }
}