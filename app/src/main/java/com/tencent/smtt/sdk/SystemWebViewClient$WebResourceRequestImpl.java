package com.tencent.smtt.sdk;

import android.net.Uri;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import java.util.Map;

class SystemWebViewClient$WebResourceRequestImpl implements WebResourceRequest {
    private boolean hasUserGesture;
    private boolean isMainFrame;
    private boolean isRedirect;
    private String method;
    private Map<String, String> requestHeaders;
    final /* synthetic */ SystemWebViewClient this$0;
    private String url;

    public SystemWebViewClient$WebResourceRequestImpl(SystemWebViewClient systemWebViewClient, String str, boolean z, boolean z2, boolean z3, String str2, Map<String, String> map) {
        this.this$0 = systemWebViewClient;
        this.url = str;
        this.isMainFrame = z;
        this.isRedirect = z2;
        this.hasUserGesture = z3;
        this.method = str2;
        this.requestHeaders = map;
    }

    public String getMethod() {
        return this.method;
    }

    public Map<String, String> getRequestHeaders() {
        return this.requestHeaders;
    }

    public Uri getUrl() {
        return Uri.parse(this.url);
    }

    public boolean hasGesture() {
        return this.hasUserGesture;
    }

    public boolean isForMainFrame() {
        return this.isMainFrame;
    }

    public boolean isRedirect() {
        return this.isRedirect;
    }
}
