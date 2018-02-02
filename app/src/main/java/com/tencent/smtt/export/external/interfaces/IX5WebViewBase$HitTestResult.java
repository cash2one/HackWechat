package com.tencent.smtt.export.external.interfaces;

import android.graphics.Bitmap;
import android.graphics.Point;

public class IX5WebViewBase$HitTestResult {
    @Deprecated
    public static final int ANCHOR_TYPE = 1;
    public static final int BUTTON_TYPE = 10;
    public static final int EDIT_TEXT_TYPE = 9;
    public static final int EMAIL_TYPE = 4;
    public static final int GEO_TYPE = 3;
    @Deprecated
    public static final int IMAGE_ANCHOR_TYPE = 6;
    public static final int IMAGE_TYPE = 5;
    public static final int PHONE_TYPE = 2;
    public static final int SRC_ANCHOR_TYPE = 7;
    public static final int SRC_IMAGE_ANCHOR_TYPE = 8;
    public static final int UNKNOWN_TYPE = 0;
    private Object mData;
    private String mExtra;
    private boolean mIsFromSinglePress = false;
    private Point mPoint;
    private int mType = 0;

    protected Bitmap getBitmapData() {
        return null;
    }

    public Object getData() {
        return this.mData;
    }

    public String getExtra() {
        return this.mExtra;
    }

    public Point getHitTestPoint() {
        return new Point(this.mPoint);
    }

    public int getType() {
        return this.mType;
    }

    public boolean isFromSinglePress() {
        return this.mIsFromSinglePress;
    }

    public void setData(Object obj) {
        this.mData = obj;
    }

    public void setExtra(String str) {
        this.mExtra = str;
    }

    public void setHitTestPoint(Point point) {
        this.mPoint = point;
    }

    public void setIsFromSinglePress(boolean z) {
        this.mIsFromSinglePress = z;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
