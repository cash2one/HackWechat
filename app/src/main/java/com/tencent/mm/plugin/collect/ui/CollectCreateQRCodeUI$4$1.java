package com.tencent.mm.plugin.collect.ui;

import com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeUI.4;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.h$b;

class CollectCreateQRCodeUI$4$1 implements h$b {
    final /* synthetic */ 4 lmb;

    CollectCreateQRCodeUI$4$1(4 4) {
        this.lmb = 4;
    }

    public final boolean v(CharSequence charSequence) {
        if (bh.ov(charSequence.toString())) {
            CollectCreateQRCodeUI.a(this.lmb.lma, "");
            CollectCreateQRCodeUI.d(this.lmb.lma);
        } else {
            CollectCreateQRCodeUI.a(this.lmb.lma, charSequence.toString());
            CollectCreateQRCodeUI.d(this.lmb.lma);
        }
        return true;
    }
}
