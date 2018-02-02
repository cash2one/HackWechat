package com.tencent.xweb.x5;

import android.net.Uri;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.xweb.l;
import java.util.Map;

public class g$b implements l {
    private Uri Arf;
    private boolean hasUserGesture;
    private boolean isMainFrame;
    private String method;
    private Map<String, String> requestHeaders;

    public g$b(WebResourceRequest webResourceRequest) {
        this.Arf = webResourceRequest.getUrl();
        this.isMainFrame = webResourceRequest.isForMainFrame();
        this.hasUserGesture = webResourceRequest.hasGesture();
        this.method = webResourceRequest.getMethod();
        this.requestHeaders = webResourceRequest.getRequestHeaders();
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
