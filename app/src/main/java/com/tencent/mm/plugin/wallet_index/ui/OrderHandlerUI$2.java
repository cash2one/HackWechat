package com.tencent.mm.plugin.wallet_index.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class OrderHandlerUI$2 implements OnClickListener {
    final /* synthetic */ OrderHandlerUI taW;

    OrderHandlerUI$2(OrderHandlerUI orderHandlerUI) {
        this.taW = orderHandlerUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.taW.finish();
    }
}
