package com.tencent.mm.plugin.gwallet;

import android.content.Intent;
import com.tencent.mm.plugin.gwallet.GWalletUI.3;
import com.tencent.mm.plugin.gwallet.a.b.b;
import com.tencent.mm.plugin.gwallet.a.c;
import com.tencent.mm.sdk.platformtools.x;

class GWalletUI$3$1 implements b {
    final /* synthetic */ boolean nzL;
    final /* synthetic */ 3 nzM;

    GWalletUI$3$1(3 3, boolean z) {
        this.nzM = 3;
        this.nzL = z;
    }

    public final void b(c cVar, Intent intent) {
        x.d("MicroMsg.GWalletUI", "Purchase finished: " + cVar + ", purchase: " + intent);
        Intent intent2 = new Intent("com.tencent.mm.gwallet.ACTION_CONSUME_RESPONSE");
        if (this.nzL) {
            intent2.putExtra("RESPONSE_CODE", 100000001);
        } else {
            intent2.putExtra("RESPONSE_CODE", 0);
        }
        GWalletUI.a(this.nzM.nzK, -1, intent2);
    }
}
