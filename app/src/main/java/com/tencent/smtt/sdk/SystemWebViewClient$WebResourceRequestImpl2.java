package com.tencent.smtt.sdk;

import android.net.Uri;
import android.os.Build.VERSION;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.utils.o;
import java.util.Map;

class SystemWebViewClient$WebResourceRequestImpl2 implements WebResourceRequest {
    android.webkit.WebResourceRequest mWebResourceRequest;

    SystemWebViewClient$WebResourceRequestImpl2(android.webkit.WebResourceRequest webResourceRequest) {
        this.mWebResourceRequest = webResourceRequest;
    }

    public String getMethod() {
        return this.mWebResourceRequest.getMethod();
    }

    public Map<String, String> getRequestHeaders() {
        return this.mWebResourceRequest.getRequestHeaders();
    }

    public Uri getUrl() {
        return this.mWebResourceRequest.getUrl();
    }

    public boolean hasGesture() {
        return this.mWebResourceRequest.hasGesture();
    }

    public boolean isForMainFrame() {
        return this.mWebResourceRequest.isForMainFrame();
    }

    public boolean isRedirect() {
        if (VERSION.SDK_INT >= 24) {
            Object f = o.f(this.mWebResourceRequest, "isRedirect");
            if (f instanceof Boolean) {
                return ((Boolean) f).booleanValue();
            }
        }
        return false;
    }
}
