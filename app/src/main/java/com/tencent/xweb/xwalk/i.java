package com.tencent.xweb.xwalk;

import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings.RenderPriority;
import com.tencent.xweb.n;
import org.xwalk.core.XWalkSettings;
import org.xwalk.core.XWalkView;

public final class i extends n {
    XWalkView Atq;

    public i(XWalkView xWalkView) {
        this.Atq = xWalkView;
    }

    public final void setSupportZoom(boolean z) {
        this.Atq.getSettings().setSupportZoom(z);
    }

    public final void setMediaPlaybackRequiresUserGesture(boolean z) {
        this.Atq.getSettings().setMediaPlaybackRequiresUserGesture(z);
    }

    public final void setBuiltInZoomControls(boolean z) {
        this.Atq.getSettings().setBuiltInZoomControls(z);
    }

    public final void cIp() {
    }

    public final void setLoadWithOverviewMode(boolean z) {
        this.Atq.getSettings().setLoadWithOverviewMode(z);
    }

    public final void cIq() {
        this.Atq.getSettings().setSaveFormData(false);
    }

    public final void cIr() {
    }

    public final void setTextZoom(int i) {
        this.Atq.getSettings().setTextZoom(i);
    }

    public final void setUseWideViewPort(boolean z) {
        this.Atq.getSettings().setUseWideViewPort(z);
    }

    public final void setLayoutAlgorithm(LayoutAlgorithm layoutAlgorithm) {
        this.Atq.getSettings().setLayoutAlgorithm(XWalkSettings.LayoutAlgorithm.values()[layoutAlgorithm.ordinal()]);
    }

    public final void cIs() {
        this.Atq.getSettings().setDefaultFontSize(8);
    }

    public final void setLoadsImagesAutomatically(boolean z) {
        this.Atq.getSettings().setLoadsImagesAutomatically(z);
    }

    public final void setJavaScriptEnabled(boolean z) {
        this.Atq.getSettings().setJavaScriptEnabled(z);
    }

    public final void setPluginsEnabled(boolean z) {
    }

    public final void setDatabasePath(String str) {
    }

    public final void cIt() {
        this.Atq.getSettings().setAppCacheEnabled(true);
    }

    public final void setAppCachePath(String str) {
        this.Atq.getSettings().setAppCachePath(str);
    }

    public final void cIu() {
    }

    public final void cIv() {
        this.Atq.getSettings().setDatabaseEnabled(true);
    }

    public final void cIw() {
        this.Atq.getSettings().setDomStorageEnabled(true);
    }

    public final void setGeolocationEnabled(boolean z) {
    }

    public final void setJavaScriptCanOpenWindowsAutomatically(boolean z) {
        this.Atq.getSettings().setJavaScriptCanOpenWindowsAutomatically(z);
    }

    public final void setDefaultTextEncodingName(String str) {
    }

    public final void setUserAgentString(String str) {
        this.Atq.getSettings().setUserAgentString(str);
    }

    public final String getUserAgentString() {
        return this.Atq.getUserAgentString();
    }

    public final void setRenderPriority(RenderPriority renderPriority) {
    }

    public final void cIx() {
        this.Atq.getSettings().setCacheMode(-1);
    }

    public final void cIy() {
    }
}
