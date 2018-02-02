package com.tencent.mm.plugin.webview.ui.tools;

import android.os.RemoteException;
import com.tencent.mm.plugin.webview.modeltools.g.c;
import com.tencent.mm.sdk.platformtools.x;

class WebViewUI$28 implements c {
    final /* synthetic */ WebViewUI tAv;

    WebViewUI$28(WebViewUI webViewUI) {
        this.tAv = webViewUI;
    }

    public final void sT(String str) {
        try {
            if (this.tAv.juQ != null) {
                this.tAv.juQ.c(str, null);
            } else {
                x.i("MicroMsg.WebViewUI", "viewCaptureCallback, invoker is null");
            }
        } catch (RemoteException e) {
            x.e("MicroMsg.WebViewUI", "recog failed");
        }
    }
}
