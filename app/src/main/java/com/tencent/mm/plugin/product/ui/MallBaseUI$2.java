package com.tencent.mm.plugin.product.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class MallBaseUI$2 implements OnClickListener {
    final /* synthetic */ MallBaseUI pfg;

    MallBaseUI$2(MallBaseUI mallBaseUI) {
        this.pfg = mallBaseUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.pfg.finish();
    }
}
