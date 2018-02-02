package com.tencent.mm.plugin.aa.ui;

import android.widget.Toast;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.d.a;

class PaylistAAUI$3 implements a {
    final /* synthetic */ PaylistAAUI ikp;

    PaylistAAUI$3(PaylistAAUI paylistAAUI) {
        this.ikp = paylistAAUI;
    }

    public final void aW(Object obj) {
        x.i("MicroMsg.PaylistAAUI", "close pay list failed: %s", obj);
        if (PaylistAAUI.d(this.ikp) != null) {
            PaylistAAUI.d(this.ikp).dismiss();
        }
        if (obj instanceof String) {
            Toast.makeText(this.ikp, obj.toString(), 1).show();
        } else {
            Toast.makeText(this.ikp, i.uIh, 1).show();
        }
    }
}
