package com.tencent.mm.plugin.remittance.ui;

import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.st;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.remittance.model.e;
import com.tencent.mm.plugin.remittance.model.t;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.wallet_core.c.g$a;

public class RemittanceUI extends RemittanceBaseUI {
    public final void bnH() {
        if (bnQ()) {
            g.Dk();
            this.pMk = (String) g.Dj().CU().get(a.xtn, "");
            g.Dk();
            this.pMl = (String) g.Dj().CU().get(a.xtr, "");
            g.Dk();
            this.pMm = ((Integer) g.Dj().CU().get(a.xts, Integer.valueOf(0))).intValue();
            if (bh.ov(this.pMk) || bh.ov(this.pMl)) {
                ad.a(true, null);
            } else {
                ad.a(false, null);
            }
            x.d("MicroMsg.RemittanceUI", "do before transfer");
            b(new e(this.gAb), false);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ji(2783);
    }

    public void dQ(String str, String str2) {
        if (this.pLQ != null) {
            this.pLQ.i(3, new Object[]{Integer.valueOf(this.pLT), Double.valueOf(this.pLR)});
        }
        x.i("MicroMsg.RemittanceUI", "doSceneGenRemittance, channel: %s", new Object[]{Integer.valueOf(getIntent().getIntExtra("pay_channel", -1))});
        k tVar = new t(this.pLR, "1", this.gAb, this.pMj, this.pLT, this.irz, str, str2, this.pLU, r12, this.pMo);
        tVar.gOs = "RemittanceProcess";
        l(tVar);
    }

    public boolean d(int i, int i2, String str, k kVar) {
        if (!(kVar instanceof e)) {
            return super.d(i, i2, str, kVar);
        }
        e eVar = (e) kVar;
        eVar.a(new 3(this, eVar)).b(new g$a(this) {
            final /* synthetic */ RemittanceUI pPD;

            {
                this.pPD = r1;
            }

            public final void f(int i, int i2, String str, k kVar) {
                x.d("MicroMsg.RemittanceUI", "before transfer: %s, %s, %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            }
        }).c(new 1(this, eVar));
        return true;
    }

    public final void bnK() {
        u.makeText(this.mController.xIM, i.uMS, 0).show();
    }

    public void onDestroy() {
        super.onDestroy();
        jj(2783);
    }

    public final void bnN() {
        final b stVar = new st();
        stVar.fKA.fKC = "7";
        stVar.fqI = new Runnable(this) {
            final /* synthetic */ RemittanceUI pPD;

            public final void run() {
                if (bh.ov(stVar.fKB.fKD)) {
                    x.i("MicroMsg.RemittanceUI", "no bulletin data");
                } else {
                    com.tencent.mm.wallet_core.ui.e.a((TextView) this.pPD.findViewById(f.ufy), stVar.fKB.fKD, stVar.fKB.content, stVar.fKB.url);
                }
            }
        };
        com.tencent.mm.sdk.b.a.xef.m(stVar);
    }
}
