package com.tencent.smtt.sdk;

import android.webkit.WebView;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult;

public class WebView$HitTestResult {
    @Deprecated
    public static final int ANCHOR_TYPE = 1;
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
    private HitTestResult mHitTestResultImpl;
    private WebView.HitTestResult mSysHitTestResult;

    public WebView$HitTestResult() {
        this.mSysHitTestResult = null;
        this.mHitTestResultImpl = null;
        this.mSysHitTestResult = null;
    }

    public WebView$HitTestResult(WebView.HitTestResult hitTestResult) {
        this.mSysHitTestResult = null;
        this.mHitTestResultImpl = null;
        this.mSysHitTestResult = hitTestResult;
    }

    public WebView$HitTestResult(HitTestResult hitTestResult) {
        this.mSysHitTestResult = null;
        this.mHitTestResultImpl = hitTestResult;
        this.mSysHitTestResult = null;
    }

    public String getExtra() {
        return this.mHitTestResultImpl != null ? this.mHitTestResultImpl.getExtra() : this.mSysHitTestResult != null ? this.mSysHitTestResult.getExtra() : "";
    }

    public int getType() {
        return this.mHitTestResultImpl != null ? this.mHitTestResultImpl.getType() : this.mSysHitTestResult != null ? this.mSysHitTestResult.getType() : 0;
    }

    public void setExtra(String str) {
        if (this.mHitTestResultImpl != null) {
            this.mHitTestResultImpl.setExtra(str);
        }
    }

    public void setType(int i) {
        if (this.mHitTestResultImpl != null) {
            this.mHitTestResultImpl.setType(i);
        }
    }
}
