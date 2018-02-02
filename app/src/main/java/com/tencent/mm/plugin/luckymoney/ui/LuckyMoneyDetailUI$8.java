package com.tencent.mm.plugin.luckymoney.ui;

import android.support.v7.app.ActionBarActivity;
import com.tencent.mm.g.a.hf;
import com.tencent.mm.plugin.luckymoney.b.e;
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.sdk.platformtools.x;

class LuckyMoneyDetailUI$8 implements Runnable {
    final /* synthetic */ hf ogS;
    final /* synthetic */ e ogT;
    final /* synthetic */ LuckyMoneyDetailUI ohM;

    LuckyMoneyDetailUI$8(LuckyMoneyDetailUI luckyMoneyDetailUI, hf hfVar, e eVar) {
        this.ohM = luckyMoneyDetailUI;
        this.ogS = hfVar;
        this.ogT = eVar;
    }

    public final void run() {
        if (this.ogS.fxu.fxw) {
            x.i("MicroMsg.LuckyMoneyDetailUI", "Get res Ok, path=" + this.ogS.fxu.fxx);
            ActionBarActivity actionBarActivity = this.ohM.mController.xIM;
            n.e(LuckyMoneyDetailUI.v(this.ohM), this.ogS.fxu.fxx, a.e.ucM);
            return;
        }
        x.i("MicroMsg.LuckyMoneyDetailUI", "Get res fail & load from url.");
        n.a(LuckyMoneyDetailUI.v(this.ohM), this.ogT.obP, this.ogT.ocj);
    }
}
