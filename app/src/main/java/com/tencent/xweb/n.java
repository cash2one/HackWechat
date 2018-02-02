package com.tencent.xweb;

import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings.RenderPriority;

public abstract class n {
    public abstract void cIp();

    public abstract void cIq();

    @Deprecated
    public abstract void cIr();

    public abstract void cIs();

    public abstract void cIt();

    @Deprecated
    public abstract void cIu();

    public abstract void cIv();

    public abstract void cIw();

    public abstract void cIx();

    public abstract void cIy();

    public abstract String getUserAgentString();

    public abstract void setAppCachePath(String str);

    public abstract void setBuiltInZoomControls(boolean z);

    @Deprecated
    public abstract void setDatabasePath(String str);

    public abstract void setDefaultTextEncodingName(String str);

    public abstract void setGeolocationEnabled(boolean z);

    public abstract void setJavaScriptCanOpenWindowsAutomatically(boolean z);

    public abstract void setJavaScriptEnabled(boolean z);

    public abstract void setLayoutAlgorithm(LayoutAlgorithm layoutAlgorithm);

    public abstract void setLoadWithOverviewMode(boolean z);

    public abstract void setLoadsImagesAutomatically(boolean z);

    public abstract void setMediaPlaybackRequiresUserGesture(boolean z);

    public abstract void setPluginsEnabled(boolean z);

    @Deprecated
    public abstract void setRenderPriority(RenderPriority renderPriority);

    public abstract void setSupportZoom(boolean z);

    public abstract void setTextZoom(int i);

    public abstract void setUseWideViewPort(boolean z);

    public abstract void setUserAgentString(String str);

    public synchronized void a(a aVar) {
        setTextZoom(aVar.value);
    }
}
