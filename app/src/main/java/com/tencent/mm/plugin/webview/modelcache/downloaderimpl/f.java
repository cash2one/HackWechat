package com.tencent.mm.plugin.webview.modelcache.downloaderimpl;

public final class f {
    public final String aBD;
    public final String appId;
    public final Exception exception;
    public final String fMh;
    public final String fMi;
    public final int fMj;
    public final long fMk;
    public final String filePath;
    public final String url;
    public final String version;

    public f(String str, String str2, String str3, String str4, String str5, String str6, int i, String str7, long j, Exception exception) {
        this.url = str;
        this.filePath = str2;
        this.version = str3;
        this.appId = str4;
        this.fMh = str5;
        this.fMi = str6;
        this.fMj = i;
        this.aBD = str7;
        this.fMk = j;
        this.exception = exception;
    }

    public final String toString() {
        return "WebViewCacheResponseWrapper{url='" + this.url + '\'' + ", filePath='" + this.filePath + '\'' + ", version='" + this.version + '\'' + ", appId='" + this.appId + '\'' + ", domain='" + this.fMh + '\'' + ", packageId='" + this.fMi + '\'' + ", cacheType=" + this.fMj + ", contentType='" + this.aBD + '\'' + ", contentLength=" + this.fMk + ", exception=" + this.exception + '}';
    }
}
