package com.tencent.smtt.sdk;

import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.io.InputStream;
import java.util.Map;

class SystemWebViewClient$WebResourceResponseImpl2 extends WebResourceResponse {
    android.webkit.WebResourceResponse mWebResourceResponse;

    public SystemWebViewClient$WebResourceResponseImpl2(android.webkit.WebResourceResponse webResourceResponse) {
        this.mWebResourceResponse = webResourceResponse;
    }

    public InputStream getData() {
        return this.mWebResourceResponse.getData();
    }

    public String getEncoding() {
        return this.mWebResourceResponse.getEncoding();
    }

    public String getMimeType() {
        return this.mWebResourceResponse.getMimeType();
    }

    public String getReasonPhrase() {
        return this.mWebResourceResponse.getReasonPhrase();
    }

    public Map<String, String> getResponseHeaders() {
        return this.mWebResourceResponse.getResponseHeaders();
    }

    public int getStatusCode() {
        return this.mWebResourceResponse.getStatusCode();
    }

    public void setData(InputStream inputStream) {
        this.mWebResourceResponse.setData(inputStream);
    }

    public void setEncoding(String str) {
        this.mWebResourceResponse.setEncoding(str);
    }

    public void setMimeType(String str) {
        this.mWebResourceResponse.setMimeType(str);
    }

    public void setResponseHeaders(Map<String, String> map) {
        this.mWebResourceResponse.setResponseHeaders(map);
    }

    public void setStatusCodeAndReasonPhrase(int i, String str) {
        this.mWebResourceResponse.setStatusCodeAndReasonPhrase(i, str);
    }
}
