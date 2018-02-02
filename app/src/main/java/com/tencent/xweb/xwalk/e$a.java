package com.tencent.xweb.xwalk;

import android.webkit.WebChromeClient.CustomViewCallback;

public class e$a implements CustomViewCallback {
    org.xwalk.core.CustomViewCallback AsW;

    e$a(org.xwalk.core.CustomViewCallback customViewCallback) {
        this.AsW = customViewCallback;
    }

    public final void onCustomViewHidden() {
        this.AsW.onCustomViewHidden();
    }
}
