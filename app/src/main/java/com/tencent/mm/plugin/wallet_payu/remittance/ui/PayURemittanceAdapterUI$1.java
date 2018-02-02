package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.content.Intent;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.n;
import com.tencent.mm.plugin.wallet_payu.remittance.a.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ak.b.a;

class PayURemittanceAdapterUI$1 implements a {
    final /* synthetic */ long lkU;
    final /* synthetic */ Intent pLO;
    final /* synthetic */ e tdv;
    final /* synthetic */ PayURemittanceAdapterUI tdw;

    PayURemittanceAdapterUI$1(PayURemittanceAdapterUI payURemittanceAdapterUI, long j, e eVar, Intent intent) {
        this.tdw = payURemittanceAdapterUI;
        this.lkU = j;
        this.tdv = eVar;
        this.pLO = intent;
    }

    public final void v(String str, boolean z) {
        if (z) {
            x.v("MicroMsg.PayURemittanceAdapterUI", "getContact suc; cost=" + (bh.Wp() - this.lkU) + " ms");
            b.I(str, 3);
            n.JS().iY(str);
        } else {
            x.w("MicroMsg.PayURemittanceAdapterUI", "getContact failed");
        }
        this.tdw.c(PayURemittanceAdapterUI.a(this.tdw), this.tdv.scene, this.pLO);
    }
}
