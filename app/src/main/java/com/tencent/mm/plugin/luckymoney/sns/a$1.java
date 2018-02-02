package com.tencent.mm.plugin.luckymoney.sns;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.luckymoney.sns.a.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;

class a$1 extends e {
    final /* synthetic */ a ofm;

    a$1(a aVar, MMActivity mMActivity, g gVar) {
        this.ofm = aVar;
        super(mMActivity, gVar);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (!(kVar instanceof a)) {
            return false;
        }
        x.i("MicroMsg.ProcessManager", "OpenSnsPayProcess onSceneEnd, errType:" + i + " errCode:" + i2 + " errMsg:" + str);
        if (i == 0 && i2 == 0) {
            h.bu(this.zHU, this.zHU.getString(i.uKB));
            a.sa(121);
            a.a(this.ofm).putBoolean("is_open_sns_pay", true);
            this.ofm.a(this.zHU, 0, a.b(this.ofm));
            return true;
        }
        h.bu(this.zHU, this.zHU.getString(i.uKA));
        a.sa(122);
        this.ofm.d(this.zHU, 0);
        return true;
    }

    public final boolean k(Object... objArr) {
        this.zHV.a(new a(1, (String) objArr[0], ""), true, 1);
        return true;
    }
}
