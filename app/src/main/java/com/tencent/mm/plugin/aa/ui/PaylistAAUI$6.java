package com.tencent.mm.plugin.aa.ui;

import android.widget.Toast;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;

class PaylistAAUI$6 implements a<Void, Boolean> {
    final /* synthetic */ PaylistAAUI ikp;

    PaylistAAUI$6(PaylistAAUI paylistAAUI) {
        this.ikp = paylistAAUI;
    }

    public final /* synthetic */ Object call(Object obj) {
        Boolean bool = (Boolean) obj;
        if (PaylistAAUI.d(this.ikp) != null) {
            PaylistAAUI.d(this.ikp).dismiss();
        }
        if (bool.booleanValue()) {
            x.i("MicroMsg.PaylistAAUI", "urgeAAPay success");
            Toast.makeText(this.ikp, i.uOA, 1).show();
        } else {
            x.i("MicroMsg.PaylistAAUI", "urgeAAPay fail");
            Toast.makeText(this.ikp, i.uOz, 1).show();
        }
        return zBS;
    }
}
