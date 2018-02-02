package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.n;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ak.b.a;

class RemittanceOSRedirect$1 implements a {
    final /* synthetic */ long lkU;
    final /* synthetic */ RemittanceOSRedirect pPb;
    final /* synthetic */ Intent val$intent;

    RemittanceOSRedirect$1(RemittanceOSRedirect remittanceOSRedirect, long j, Intent intent) {
        this.pPb = remittanceOSRedirect;
        this.lkU = j;
        this.val$intent = intent;
    }

    public final void v(String str, boolean z) {
        if (z) {
            x.v("MicroMsg.RemittanceOSRedirect", "getContact suc; cost=" + (bh.Wp() - this.lkU) + " ms");
            b.I(str, 3);
            n.JS().iY(str);
        } else {
            x.w("MicroMsg.RemittanceOSRedirect", "getContact failed");
        }
        this.pPb.startActivity(this.val$intent);
        this.pPb.finish();
    }
}
