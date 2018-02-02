package com.tencent.mm.plugin.aa.ui;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;

class PaylistAAUI$4 implements a<Void, Boolean> {
    final /* synthetic */ PaylistAAUI ikp;

    PaylistAAUI$4(PaylistAAUI paylistAAUI) {
        this.ikp = paylistAAUI;
    }

    public final /* synthetic */ Object call(Object obj) {
        x.i("MicroMsg.PaylistAAUI", "close pay list success: %s", new Object[]{(Boolean) obj});
        if (PaylistAAUI.d(this.ikp) != null) {
            PaylistAAUI.d(this.ikp).dismiss();
        }
        PaylistAAUI.b(this.ikp, null);
        PaylistAAUI.j(this.ikp);
        this.ikp.mController.removeAllOptionMenu();
        PaylistAAUI.k(this.ikp);
        return zBS;
    }
}
