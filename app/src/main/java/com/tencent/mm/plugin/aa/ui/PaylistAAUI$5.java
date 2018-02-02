package com.tencent.mm.plugin.aa.ui;

import android.widget.Toast;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.d.a;

class PaylistAAUI$5 implements a {
    final /* synthetic */ PaylistAAUI ikp;

    PaylistAAUI$5(PaylistAAUI paylistAAUI) {
        this.ikp = paylistAAUI;
    }

    public final void aW(Object obj) {
        if (PaylistAAUI.d(this.ikp) != null) {
            PaylistAAUI.d(this.ikp).dismiss();
        }
        if (!(obj instanceof String) || obj.toString().equalsIgnoreCase("ok")) {
            Toast.makeText(this.ikp, i.uOz, 1).show();
        } else {
            Toast.makeText(this.ikp, obj.toString(), 1).show();
        }
        x.e("MicroMsg.PaylistAAUI", "urgeAAPay fail");
    }
}
