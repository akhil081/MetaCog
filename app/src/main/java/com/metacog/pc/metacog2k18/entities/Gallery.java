package com.metacog.pc.metacog2k18.entities;

import android.app.Activity;
import android.content.Intent;

import com.mzelzoghbi.zgallery.Constants;
import com.mzelzoghbi.zgallery.activities.ZGalleryActivity;
import com.mzelzoghbi.zgallery.entities.ZColor;
import java.util.ArrayList;

public class Gallery {
    private Activity mActivity;
    private ArrayList<String> imagesURLs;
    private String title;
    private int toolbarColor = -1;
    private ZColor color;
    private int selectedImgPosition;
    private ZColor backgroundColor;

    private Gallery() {
    }

    public static Gallery with(Activity activity, ArrayList<String> imagesURLs) {
        return new Gallery(activity, imagesURLs);
    }


    private Gallery(Activity activity, ArrayList<String> imagesURLs) {
        this.imagesURLs = imagesURLs;
        this.mActivity = activity;
    }

    public Gallery setTitle(String title) {
        this.title = title;
        return this;
    }

    public Gallery setToolbarColorResId(int colorResId) {
        this.toolbarColor = colorResId;
        return this;
    }

    public Gallery setToolbarTitleColor(ZColor color) {
        this.color = color;
        return this;
    }

    public Gallery setGalleryBackgroundColor(ZColor backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public void show() {
        Intent gridActivity = new Intent(mActivity, ZGalleryActivity.class);
        gridActivity.putExtra(Constants.IntentPassingParams.IMAGES, imagesURLs);
        gridActivity.putExtra(Constants.IntentPassingParams.TITLE, title);
        gridActivity.putExtra(Constants.IntentPassingParams.TOOLBAR_COLOR_ID, toolbarColor);
        gridActivity.putExtra(Constants.IntentPassingParams.TOOLBAR_TITLE_COLOR, color);
        gridActivity.putExtra(Constants.IntentPassingParams.SELECTED_IMG_POS, selectedImgPosition);
        gridActivity.putExtra(Constants.IntentPassingParams.BG_COLOR, backgroundColor);
        mActivity.startActivity(gridActivity);
    }
}
