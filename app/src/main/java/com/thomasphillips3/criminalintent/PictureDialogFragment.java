package com.thomasphillips3.criminalintent;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by thomas on 5/4/17.
 */

public class PictureDialogFragment extends DialogFragment {
    public static final String EXTRA_PHOTO = "com.thomasphillips3.android.criminalintent.photo";

    private Bitmap mPhoto;

    static PictureDialogFragment newInstance(Bitmap bitmap) {
        Bundle args = new Bundle();
        args.putParcelable(EXTRA_PHOTO, bitmap);

        PictureDialogFragment pictureDialogFragment = new PictureDialogFragment();
        pictureDialogFragment.setArguments(args);

        return pictureDialogFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.photo_view, container, false);
        mPhoto = (Bitmap) getArguments().getParcelable(EXTRA_PHOTO);
        ImageView zoomedImage = (ImageView) v.findViewById(R.id.zoomed_image);
        zoomedImage.setImageBitmap(mPhoto);
        return v;
    }
}
