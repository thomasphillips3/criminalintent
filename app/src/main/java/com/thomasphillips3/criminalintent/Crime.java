package com.thomasphillips3.criminalintent;

import java.util.Date;
import java.util.UUID;

/**
 * Created by thomas on 11/30/16.
 */

public class Crime {
    private UUID mId;
    private String mTitle;
    private String mSuspect;

    public String getPhotoFilename() {
        return "IMG_" + getId().toString() + ".jpg";
    }

    public long getContactId() {
        return mContactId;
    }

    public void setContactId(long contactId) {
        mContactId = contactId;
    }

    private long mContactId;
    private Date mDate;
    private boolean mSolved;

    public String getSuspect() {
        return mSuspect;
    }

    public void setSuspect(String suspect) {
        mSuspect = suspect;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public Crime() {
        this(UUID.randomUUID());
    }

    public Crime(UUID id) {
        mId = id;
        mDate = new Date();
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

    @Override
    public String toString() {
        return mTitle;
    }
}
