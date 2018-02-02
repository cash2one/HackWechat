package com.tencent.mm.plugin.webview.stub;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class WebViewStubTempUI$4 implements OnCancelListener {
    final /* synthetic */ WebViewStubTempUI tvQ;

    WebViewStubTempUI$4(WebViewStubTempUI webViewStubTempUI) {
        this.tvQ = webViewStubTempUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.tvQ.finish();
    }
}
