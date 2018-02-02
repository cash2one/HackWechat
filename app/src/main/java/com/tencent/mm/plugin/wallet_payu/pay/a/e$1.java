package com.tencent.mm.plugin.wallet_payu.pay.a;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet_core.c.b.a;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;

class e$1 extends e {
    final /* synthetic */ e tcT;

    e$1(e eVar, MMActivity mMActivity, g gVar) {
        this.tcT = eVar;
        super(mMActivity, gVar);
    }

    public final boolean p(Object... objArr) {
        PayInfo payInfo = (PayInfo) this.zHU.getIntent().getParcelableExtra("key_pay_info");
        if (payInfo == null || bh.ov(payInfo.fuH)) {
            return false;
        }
        this.zHV.a(new c(payInfo.fuH), payInfo.vzv, 1);
        this.zHV.a(new a(), payInfo.vzv, 1);
        return true;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    public final boolean k(Object... objArr) {
        return false;
    }
}
