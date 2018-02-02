package com.tencent.mm.plugin.aa.ui;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.d.a;

class PaylistAAUI$9 implements a {
    final /* synthetic */ PaylistAAUI ikp;

    PaylistAAUI$9(PaylistAAUI paylistAAUI) {
        this.ikp = paylistAAUI;
    }

    public final void aW(Object obj) {
        x.i("MicroMsg.PaylistAAUI", "onInterrupt: %s", obj);
        PaylistAAUI.a(this.ikp, obj == null ? "" : obj.toString());
    }
}
