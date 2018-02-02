package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.remittance.ui.RemittanceUI;
import com.tencent.mm.plugin.wallet_payu.remittance.a.d;
import com.tencent.mm.plugin.wallet_payu.remittance.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.u;

public class PayURemittanceUI extends RemittanceUI {
    private final String tdF = "ZAR";

    public final void bnI() {
        l(new g(this.gAb, this.pLU));
    }

    public final void dQ(String str, String str2) {
        l(new d(this.pLR, "ZAR", this.gAb, this.irz));
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i != 0 || i2 != 0) {
            return false;
        }
        if (!(kVar instanceof d)) {
            return true;
        }
        d dVar = (d) kVar;
        if (bh.ov(dVar.fzP)) {
            u.makeText(this.mController.xIM, i.uYk, 0).show();
            return true;
        }
        String str2 = dVar.fzP;
        String str3 = this.gAb;
        PayInfo payInfo = new PayInfo();
        payInfo.fuH = str2;
        payInfo.fCV = this.pLT;
        Bundle bundle = new Bundle();
        bundle.putString("extinfo_key_1", str3);
        bundle.putString("extinfo_key_2", getIntent().getStringExtra("receiver_true_name"));
        bundle.putString("extinfo_key_3", getIntent().getStringExtra("desc"));
        bundle.putString("extinfo_key_4", getIntent().getStringExtra("scan_remittance_id"));
        bundle.putString("fee_type", "ZAR");
        bundle.putDouble("total_fee", this.pLR);
        payInfo.vzx = bundle;
        h.a((Context) this, payInfo, 1);
        return true;
    }
}
