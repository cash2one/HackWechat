package com.tencent.xweb.x5;

import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings.RenderPriority;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebSettings.TextSize;
import com.tencent.smtt.sdk.WebView;
import com.tencent.xweb.n;
import com.tencent.xweb.n.a;

public final class k extends n {
    WebView Asi;

    public k(WebView webView) {
        this.Asi = webView;
    }

    public final void setSupportZoom(boolean z) {
        this.Asi.getSettings().setSupportZoom(z);
    }

    public final void setMediaPlaybackRequiresUserGesture(boolean z) {
        this.Asi.getSettings().setMediaPlaybackRequiresUserGesture(z);
    }

    public final void setBuiltInZoomControls(boolean z) {
        this.Asi.getSettings().setBuiltInZoomControls(z);
    }

    public final void cIp() {
        this.Asi.getSettings().setDisplayZoomControls(false);
    }

    public final void setLoadWithOverviewMode(boolean z) {
        this.Asi.getSettings().setLoadWithOverviewMode(z);
    }

    public final void cIq() {
        this.Asi.getSettings().setSaveFormData(false);
    }

    public final void cIr() {
        this.Asi.getSettings().setJavaScriptEnabled(false);
    }

    public final void setTextZoom(int i) {
        this.Asi.getSettings().setTextZoom(i);
    }

    public final synchronized void a(a aVar) {
        this.Asi.getSettings().setTextSize(TextSize.valueOf(aVar.name()));
    }

    public final void setUseWideViewPort(boolean z) {
        this.Asi.getSettings().setUseWideViewPort(z);
    }

    public final void setLayoutAlgorithm(LayoutAlgorithm layoutAlgorithm) {
        this.Asi.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.values()[layoutAlgorithm.ordinal()]);
    }

    public final void cIs() {
        this.Asi.getSettings().setDefaultFontSize(8);
    }

    public final void setLoadsImagesAutomatically(boolean z) {
        this.Asi.getSettings().setLoadsImagesAutomatically(z);
    }

    public final void setJavaScriptEnabled(boolean z) {
        this.Asi.getSettings().setJavaScriptEnabled(z);
    }

    public final void setPluginsEnabled(boolean z) {
        this.Asi.getSettings().setPluginsEnabled(z);
    }

    public final void setDatabasePath(String str) {
        this.Asi.getSettings().setDatabasePath(str);
    }

    public final void cIt() {
        this.Asi.getSettings().setJavaScriptEnabled(true);
    }

    public final void setAppCachePath(String str) {
        this.Asi.getSettings().setAppCachePath(str);
    }

    public final void cIu() {
        this.Asi.getSettings().setAppCacheMaxSize(10485760);
    }

    public final void cIv() {
        this.Asi.getSettings().setDatabaseEnabled(true);
    }

    public final void cIw() {
        this.Asi.getSettings().setDomStorageEnabled(true);
    }

    public final void setGeolocationEnabled(boolean z) {
        this.Asi.getSettings().setJavaScriptEnabled(z);
    }

    public final void setJavaScriptCanOpenWindowsAutomatically(boolean z) {
        this.Asi.getSettings().setJavaScriptCanOpenWindowsAutomatically(z);
    }

    public final void setDefaultTextEncodingName(String str) {
        this.Asi.getSettings().setDefaultTextEncodingName(str);
    }

    public final void setUserAgentString(String str) {
        this.Asi.getSettings().setUserAgentString(str);
    }

    public final String getUserAgentString() {
        return this.Asi.getSettings().getUserAgentString();
    }

    public final void setRenderPriority(RenderPriority renderPriority) {
        this.Asi.getSettings().setRenderPriority(WebSettings.RenderPriority.values()[renderPriority.ordinal()]);
    }

    public final void cIx() {
        this.Asi.getSettings().setCacheMode(-1);
    }

    public final void cIy() {
        this.Asi.getSettings().setMixedContentMode(0);
    }
}
