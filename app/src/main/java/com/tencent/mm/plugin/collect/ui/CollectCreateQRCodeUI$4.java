package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet_core.ui.view.a;
import com.tencent.mm.plugin.wxpay.a$i;

class CollectCreateQRCodeUI$4 implements OnClickListener {
    final /* synthetic */ CollectCreateQRCodeUI lma;

    CollectCreateQRCodeUI$4(CollectCreateQRCodeUI collectCreateQRCodeUI) {
        this.lma = collectCreateQRCodeUI;
    }

    public final void onClick(View view) {
        CollectCreateQRCodeUI.c(this.lma);
        a.a(this.lma, this.lma.getString(a$i.uIx), CollectCreateQRCodeUI.b(this.lma), "", 32, new 1(this), new 2(this));
    }
}
