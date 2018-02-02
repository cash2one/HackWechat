package com.tencent.mm.plugin.luckymoney.ui;

import android.support.v7.app.ActionBarActivity;
import com.tencent.mm.g.a.hf;
import com.tencent.mm.plugin.luckymoney.b.e;
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class LuckyMoneyBusiDetailUI$3 implements Runnable {
    final /* synthetic */ LuckyMoneyBusiDetailUI ogR;
    final /* synthetic */ hf ogS;
    final /* synthetic */ e ogT;

    LuckyMoneyBusiDetailUI$3(LuckyMoneyBusiDetailUI luckyMoneyBusiDetailUI, hf hfVar, e eVar) {
        this.ogR = luckyMoneyBusiDetailUI;
        this.ogS = hfVar;
        this.ogT = eVar;
    }

    public final void run() {
        if (this.ogS.fxu.fxw) {
            x.i("MicroMsg.LuckyMoneyDetailUI", "Get res Ok, path=" + this.ogS.fxu.fxx);
            ActionBarActivity actionBarActivity = this.ogR.mController.xIM;
            n.e(LuckyMoneyBusiDetailUI.i(this.ogR), this.ogS.fxu.fxx, a.e.ucM);
            return;
        }
        x.i("MicroMsg.LuckyMoneyDetailUI", "Get res fail & load from url.");
        if (!bh.ov(this.ogT.obP)) {
            n.a(LuckyMoneyBusiDetailUI.i(this.ogR), this.ogT.obP, this.ogT.ocj);
        }
    }
}
