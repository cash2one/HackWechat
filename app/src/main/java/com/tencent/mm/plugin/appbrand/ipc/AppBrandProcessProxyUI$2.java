package com.tencent.mm.plugin.appbrand.ipc;

import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

class AppBrandProcessProxyUI$2 extends ResultReceiver {
    final /* synthetic */ OnClickListener jbb;
    final /* synthetic */ OnClickListener jbc;
    final /* synthetic */ OnClickListener jbd;

    AppBrandProcessProxyUI$2(Handler handler, OnClickListener onClickListener, OnClickListener onClickListener2, OnClickListener onClickListener3) {
        this.jbb = onClickListener;
        this.jbc = onClickListener2;
        this.jbd = onClickListener3;
        super(handler);
    }

    protected final void onReceiveResult(int i, Bundle bundle) {
        if (-1 == i && this.jbb != null) {
            this.jbb.onClick(null, i);
        }
        if (-2 == i && this.jbc != null) {
            this.jbc.onClick(null, i);
        }
        if (-3 == i && this.jbd != null) {
            this.jbd.onClick(null, i);
        }
    }
}
