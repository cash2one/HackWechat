package com.tencent.xweb.sys;

import android.net.Uri;
import android.os.Build.VERSION;
import android.webkit.WebResourceRequest;
import com.tencent.xweb.a.a;
import com.tencent.xweb.l;
import java.util.Map;

public class c$e implements l {
    private Uri Arf;
    a Arg;
    private boolean hasUserGesture;
    private boolean isMainFrame;
    private String method;
    private Map<String, String> requestHeaders;

    public c$e(WebResourceRequest webResourceRequest) {
        if (VERSION.SDK_INT >= 21) {
            this.Arf = webResourceRequest.getUrl();
            this.isMainFrame = webResourceRequest.isForMainFrame();
            this.hasUserGesture = webResourceRequest.hasGesture();
            this.method = webResourceRequest.getMethod();
            this.requestHeaders = webResourceRequest.getRequestHeaders();
            this.Arg = new a(this);
        }
    }

    public final Uri getUrl() {
        return this.Arf;
    }

    public final boolean isForMainFrame() {
        return this.isMainFrame;
    }

    public final boolean hasGesture() {
        return this.hasUserGesture;
    }

    public final String getMethod() {
        return this.method;
    }

    public final Map<String, String> getRequestHeaders() {
        return this.requestHeaders;
    }
}
