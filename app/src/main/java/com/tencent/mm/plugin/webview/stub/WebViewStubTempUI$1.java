package com.tencent.mm.plugin.webview.stub;

import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

class WebViewStubTempUI$1 extends ResultReceiver {
    final /* synthetic */ OnClickListener tvN;
    final /* synthetic */ OnClickListener tvO;

    WebViewStubTempUI$1(Handler handler, OnClickListener onClickListener, OnClickListener onClickListener2) {
        this.tvN = onClickListener;
        this.tvO = onClickListener2;
        super(handler);
    }

    protected final void onReceiveResult(int i, Bundle bundle) {
        switch (i) {
            case 0:
                this.tvN.onClick(null, 0);
                return;
            case 1:
                this.tvO.onClick(null, 0);
                return;
            default:
                return;
        }
    }
}
