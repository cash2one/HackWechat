package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.collect.b.m;
import com.tencent.mm.plugin.collect.b.s;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.z.q;

class CollectCreateQRCodeUI$3 implements OnClickListener {
    final /* synthetic */ CollectCreateQRCodeUI lma;

    CollectCreateQRCodeUI$3(CollectCreateQRCodeUI collectCreateQRCodeUI) {
        this.lma = collectCreateQRCodeUI;
    }

    public final void onClick(View view) {
        double d = bh.getDouble(CollectCreateQRCodeUI.a(this.lma).getText(), 0.0d);
        g.Dk();
        x.i("MicroMsg.CollectCreateQRCodeUI", "wallet region: %s", new Object[]{Integer.valueOf(((Integer) g.Dj().CU().get(a.xrD, Integer.valueOf(0))).intValue())});
        if (!CollectCreateQRCodeUI.a(this.lma).XO()) {
            u.makeText(this.lma.mController.xIM, i.uPA, 0).show();
        } else if (d < 0.01d) {
            u.makeText(this.lma.mController.xIM, i.uMS, 0).show();
        } else if (r0 == 8) {
            this.lma.r(new m(Math.round(d * 100.0d), CollectCreateQRCodeUI.b(this.lma), q.FZ()));
        } else {
            this.lma.l(new s(d, "1", CollectCreateQRCodeUI.b(this.lma)));
        }
    }
}
