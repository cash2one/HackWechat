package com.tencent.mm.ui.contact;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.contact.m.a;

class MMBaseSelectContactUI$3 implements a {
    final /* synthetic */ MMBaseSelectContactUI yTk;

    MMBaseSelectContactUI$3(MMBaseSelectContactUI mMBaseSelectContactUI) {
        this.yTk = mMBaseSelectContactUI;
    }

    public final void r(String str, int i, boolean z) {
        x.i("MicroMsg.MMBaseSelectContactUI", "Callback SearchEnd Count=%d", new Object[]{Integer.valueOf(i)});
        if (!z || i != 0) {
            MMBaseSelectContactUI.c(this.yTk);
        } else if (bh.ov(str)) {
            MMBaseSelectContactUI.a(this.yTk);
        } else {
            MMBaseSelectContactUI.b(this.yTk);
        }
    }
}
