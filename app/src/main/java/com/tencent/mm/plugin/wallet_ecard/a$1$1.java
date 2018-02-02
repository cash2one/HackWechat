package com.tencent.mm.plugin.wallet_ecard;

import android.app.Activity;
import android.content.Context;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.cl$a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.c.a;
import com.tencent.mm.plugin.wallet_ecard.a.1;
import com.tencent.mm.plugin.wallet_ecard.a.b;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class a$1$1 implements e {
    final /* synthetic */ cl$a sYO;
    final /* synthetic */ cl sYP;
    final /* synthetic */ String sYQ;
    final /* synthetic */ 1 sYR;

    a$1$1(1 1, cl$a com_tencent_mm_g_a_cl_a, cl clVar, String str) {
        this.sYR = 1;
        this.sYO = com_tencent_mm_g_a_cl_a;
        this.sYP = clVar;
        this.sYQ = str;
    }

    public final void a(int i, int i2, String str, k kVar) {
        g.Dk();
        g.Di().gPJ.b(580, this);
        if (i == 0 && i2 == 0) {
            x.i("MicroMsg.SubCoreECard", "jsapi check success");
            f.Ta(((a) kVar).bKH());
            Context context = (Context) this.sYO.fqH.get();
            if (context == null || !(context instanceof Activity)) {
                this.sYP.fqC.retCode = -1;
                this.sYP.fqB.fqI.run();
                return;
            }
            b.a(bh.getInt(this.sYP.fqB.fqG, 0), this.sYP.fqB.token, this.sYP.fqB.fqF, this.sYQ, context, new 1(this));
            return;
        }
        x.e("MicroMsg.SubCoreECard", "jsapi check fail");
        this.sYP.fqC.retCode = -1;
        this.sYP.fqB.fqI.run();
    }
}
