package com.shakiba.test.model;

import android.graphics.drawable.Drawable;

public class CategoryModel {
    private Drawable imageView;
    private String textView;

    public CategoryModel(Drawable imageView, String textView) {
        this.imageView = imageView;
        this.textView = textView;
    }

    public Drawable getImageView() {
        return imageView;
    }

    public void setImageView(Drawable imageView) {
        this.imageView = imageView;
    }

    public String getTextView() {
        return textView;
    }

    public void setTextView(String textView) {
        this.textView = textView;
    }
}
