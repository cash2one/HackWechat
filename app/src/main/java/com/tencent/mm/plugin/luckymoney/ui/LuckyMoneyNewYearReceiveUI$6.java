package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.mm.plugin.luckymoney.b.af;
import com.tencent.mm.plugin.wallet_core.id_verify.util.a.a;
import com.tencent.mm.sdk.platformtools.x;

class LuckyMoneyNewYearReceiveUI$6 implements a {
    final /* synthetic */ LuckyMoneyNewYearReceiveUI oiL;
    final /* synthetic */ af oiP;

    LuckyMoneyNewYearReceiveUI$6(LuckyMoneyNewYearReceiveUI luckyMoneyNewYearReceiveUI, af afVar) {
        this.oiL = luckyMoneyNewYearReceiveUI;
        this.oiP = afVar;
    }

    public final boolean b(int i, int i2, String str, boolean z) {
        x.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "showDisclaimerDialog resultCode=" + i + ";errCode=" + i2 + ";errMsg=" + str + ";hadAgree = " + z);
        if (i == 1) {
            this.oiL.finish();
        } else if (i == 2) {
            LuckyMoneyNewYearReceiveUI.a(this.oiL, this.oiP.msgType, this.oiP.fdS, this.oiP.nZa, this.oiP.fLC, this.oiP.odE);
        } else if (i == 0 && z) {
            LuckyMoneyNewYearReceiveUI.a(this.oiL, this.oiP.msgType, this.oiP.fdS, this.oiP.nZa, this.oiP.fLC, this.oiP.odE);
        }
        return true;
    }
}
