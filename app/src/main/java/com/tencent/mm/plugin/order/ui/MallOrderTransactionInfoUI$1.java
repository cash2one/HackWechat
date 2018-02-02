package com.tencent.mm.plugin.order.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class MallOrderTransactionInfoUI$1 implements OnClickListener {
    final /* synthetic */ MallOrderTransactionInfoUI pcH;

    MallOrderTransactionInfoUI$1(MallOrderTransactionInfoUI mallOrderTransactionInfoUI) {
        this.pcH = mallOrderTransactionInfoUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.pcH.finish();
    }
}
