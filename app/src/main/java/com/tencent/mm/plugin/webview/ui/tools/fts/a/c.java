package com.tencent.mm.plugin.webview.ui.tools.fts.a;

public final class c {
    String bhd;
    String iconUrl;
    long timestamp;
    public String title;
    public String url;

    public c(String str, String str2, String str3, String str4, long j) {
        this.url = str;
        this.title = str2;
        this.bhd = str3;
        this.iconUrl = str4;
        this.timestamp = j;
    }

    public final String toString() {
        return "[url " + this.url + ", title " + this.title + ", source " + this.bhd + ", iconUrl " + this.iconUrl + ", timestamp " + this.timestamp + "]";
    }
}
