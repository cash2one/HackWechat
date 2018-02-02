package com.tencent.mm.plugin.remittance.ui;

import android.graphics.Bitmap;
import com.tencent.mm.ad.b;
import com.tencent.mm.plugin.wxpay.a.e;

class RemittanceBaseUI$18 implements Runnable {
    final /* synthetic */ RemittanceBaseUI pMw;

    RemittanceBaseUI$18(RemittanceBaseUI remittanceBaseUI) {
        this.pMw = remittanceBaseUI;
    }

    public final void run() {
        Bitmap a = b.a(this.pMw.gAb, false, -1);
        if (a == null) {
            this.pMw.pLV.setImageResource(e.bBB);
        } else {
            this.pMw.pLV.setImageBitmap(a);
        }
    }
}
