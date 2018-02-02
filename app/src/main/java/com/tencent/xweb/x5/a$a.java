package com.tencent.xweb.x5;

import com.tencent.smtt.sdk.DownloadListener;

public class a$a implements DownloadListener {
    android.webkit.DownloadListener ArD;

    public a$a(android.webkit.DownloadListener downloadListener) {
        this.ArD = downloadListener;
    }

    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        if (this.ArD != null) {
            this.ArD.onDownloadStart(str, str2, str3, str4, j);
        }
    }
}
