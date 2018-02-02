package com.samsung.android.sdk.look.airbutton;

import android.graphics.drawable.Drawable;
import android.view.View;

public class SlookAirButtonAdapter$AirButtonItem {
    private Object mData = null;
    private String mDescription = null;
    private Drawable mImage = null;
    private String mSubDescription = null;
    private View mView = null;

    public SlookAirButtonAdapter$AirButtonItem(View view, Object obj) {
        if (view == null && obj == null) {
            throw new IllegalArgumentException("You should set the View and Object in Param");
        }
        set(view, obj);
    }

    public SlookAirButtonAdapter$AirButtonItem(Drawable drawable, String str, Object obj) {
        if (drawable == null && str == null && obj == null) {
            throw new IllegalArgumentException("You should set the Drawable, String and Object in Param");
        }
        set(drawable, str, obj);
    }

    public SlookAirButtonAdapter$AirButtonItem(Drawable drawable, String str, String str2, Object obj) {
        if (drawable == null && str == null && str2 == null && obj == null) {
            throw new IllegalArgumentException("You should set the Drawable, String, subDescription and Object in Param");
        }
        set(drawable, str, str2, obj);
    }

    public void set(View view, Object obj) {
        this.mView = view;
        this.mData = obj;
    }

    public void set(Drawable drawable, String str, Object obj) {
        this.mImage = drawable;
        this.mDescription = str;
        this.mData = obj;
    }

    public void set(Drawable drawable, String str, String str2, Object obj) {
        this.mImage = drawable;
        this.mDescription = str;
        this.mSubDescription = str2;
        this.mData = obj;
    }

    public View getView() {
        return this.mView;
    }

    public Drawable getImage() {
        return this.mImage;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public String getSubDescription() {
        return this.mSubDescription;
    }

    public Object getData() {
        return this.mData;
    }
}
