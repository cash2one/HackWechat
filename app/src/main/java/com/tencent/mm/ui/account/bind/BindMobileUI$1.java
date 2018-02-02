package com.tencent.mm.ui.account.bind;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class BindMobileUI$1 implements OnClickListener {
    final /* synthetic */ String xTw;
    final /* synthetic */ BindMobileUI xTx;

    BindMobileUI$1(BindMobileUI bindMobileUI, String str) {
        this.xTx = bindMobileUI;
        this.xTw = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        BindMobileUI.a(this.xTx, this.xTw);
    }
}
