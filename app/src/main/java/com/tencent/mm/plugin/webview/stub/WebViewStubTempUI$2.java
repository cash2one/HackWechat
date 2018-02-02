package com.tencent.mm.plugin.webview.stub;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.ResultReceiver;

class WebViewStubTempUI$2 implements OnClickListener {
    final /* synthetic */ ResultReceiver tvP;
    final /* synthetic */ WebViewStubTempUI tvQ;

    WebViewStubTempUI$2(WebViewStubTempUI webViewStubTempUI, ResultReceiver resultReceiver) {
        this.tvQ = webViewStubTempUI;
        this.tvP = resultReceiver;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.tvP.send(0, null);
        this.tvQ.finish();
    }
}
