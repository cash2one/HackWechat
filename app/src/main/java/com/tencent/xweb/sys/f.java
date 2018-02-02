package com.tencent.xweb.sys;

import android.os.Build.VERSION;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import com.tencent.smtt.utils.o;
import com.tencent.xweb.n;

public final class f extends n {
    String ArA = "";
    WebView Arz;

    public f(WebView webView) {
        this.Arz = webView;
        getUserAgentString();
    }

    public final void setSupportZoom(boolean z) {
        this.Arz.getSettings().setSupportZoom(z);
    }

    public final void setMediaPlaybackRequiresUserGesture(boolean z) {
        if (VERSION.SDK_INT >= 17) {
            this.Arz.getSettings().setMediaPlaybackRequiresUserGesture(z);
        }
    }

    public final void setBuiltInZoomControls(boolean z) {
        this.Arz.getSettings().setBuiltInZoomControls(z);
    }

    public final void cIp() {
        this.Arz.getSettings().setDisplayZoomControls(false);
    }

    public final void setLoadWithOverviewMode(boolean z) {
        this.Arz.getSettings().setLoadWithOverviewMode(z);
    }

    public final void cIq() {
        this.Arz.getSettings().setSaveFormData(false);
    }

    public final void cIr() {
        this.Arz.getSettings().setJavaScriptEnabled(false);
    }

    public final void setTextZoom(int i) {
        this.Arz.getSettings().setTextZoom(i);
    }

    public final void setUseWideViewPort(boolean z) {
        this.Arz.getSettings().setUseWideViewPort(z);
    }

    public final void setLayoutAlgorithm(LayoutAlgorithm layoutAlgorithm) {
        this.Arz.getSettings().setLayoutAlgorithm(layoutAlgorithm);
    }

    public final void cIs() {
        this.Arz.getSettings().setDefaultFontSize(8);
    }

    public final void setLoadsImagesAutomatically(boolean z) {
        this.Arz.getSettings().setLoadsImagesAutomatically(z);
    }

    public final void setJavaScriptEnabled(boolean z) {
        this.Arz.getSettings().setJavaScriptEnabled(z);
    }

    public final void setPluginsEnabled(boolean z) {
        o.b(this.Arz.getSettings(), "setPluginsEnabled", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(z)});
    }

    public final void setDatabasePath(String str) {
        this.Arz.getSettings().setDatabasePath(str);
    }

    public final void cIt() {
        this.Arz.getSettings().setJavaScriptEnabled(true);
    }

    public final void setAppCachePath(String str) {
        this.Arz.getSettings().setAppCachePath(str);
    }

    public final void cIu() {
        this.Arz.getSettings().setAppCacheMaxSize(10485760);
    }

    public final void cIv() {
        this.Arz.getSettings().setDatabaseEnabled(true);
    }

    public final void cIw() {
        this.Arz.getSettings().setDomStorageEnabled(true);
    }

    public final void setGeolocationEnabled(boolean z) {
        this.Arz.getSettings().setJavaScriptEnabled(z);
    }

    public final void setJavaScriptCanOpenWindowsAutomatically(boolean z) {
        this.Arz.getSettings().setJavaScriptCanOpenWindowsAutomatically(z);
    }

    public final void setDefaultTextEncodingName(String str) {
        this.Arz.getSettings().setDefaultTextEncodingName(str);
    }

    public final void setUserAgentString(String str) {
        this.ArA = str;
        this.Arz.getSettings().setUserAgentString(str);
    }

    public final String getUserAgentString() {
        if (this.ArA == null || this.ArA.isEmpty()) {
            try {
                this.ArA = this.Arz.getSettings().getUserAgentString();
            } catch (Exception e) {
            }
        }
        return this.ArA;
    }

    public final void setRenderPriority(RenderPriority renderPriority) {
        this.Arz.getSettings().setRenderPriority(renderPriority);
    }

    public final void cIx() {
        this.Arz.getSettings().setCacheMode(-1);
    }

    public final void cIy() {
        if (VERSION.SDK_INT >= 21) {
            this.Arz.getSettings().setMixedContentMode(0);
        }
    }
}
