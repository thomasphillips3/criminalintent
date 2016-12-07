package com.thomasphillips3.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by thomas on 12/6/16.
 */

public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}