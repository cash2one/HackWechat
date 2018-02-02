package com.tencent.xweb.x5;

import android.view.View;
import com.tencent.smtt.sdk.WebChromeClient;

public class b extends WebChromeClient {
    public final void cIT() {
        super.onHideCustomView();
    }

    public View getVideoLoadingProgressView() {
        return super.getVideoLoadingProgressView();
    }
}
