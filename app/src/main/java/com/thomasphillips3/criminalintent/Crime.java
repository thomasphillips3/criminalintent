package com.thomasphillips3.criminalintent;

import java.util.UUID;

/**
 * Created by thomas on 11/30/16.
 */

public class Crime {
    private UUID mId;
    private String mTitle;

    public Crime() {
        mId = UUID.randomUUID();
    }

    public UUID getId() {

        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
