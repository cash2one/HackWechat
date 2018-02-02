package com.tencent.xweb.x5;

import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;

public class g$c implements CustomViewCallback {
    IX5WebChromeClient.CustomViewCallback ArN;

    g$c(IX5WebChromeClient.CustomViewCallback customViewCallback) {
        this.ArN = customViewCallback;
    }

    public final void onCustomViewHidden() {
        this.ArN.onCustomViewHidden();
    }
}
