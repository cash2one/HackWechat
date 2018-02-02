package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.modelmulti.b.a;
import com.tencent.mm.modelmulti.q;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.sdk.platformtools.x;

class w$2 implements Runnable {
    final /* synthetic */ String hEz;
    final /* synthetic */ w yBn;
    final /* synthetic */ int yBp;
    final /* synthetic */ long yBr;
    final /* synthetic */ long yBs;

    public w$2(w wVar, String str, long j, long j2, int i) {
        this.yBn = wVar;
        this.hEz = str;
        this.yBr = j;
        this.yBs = j2;
        this.yBp = i;
    }

    public final void run() {
        w.a(this.yBn).csz().mn(false);
        w.a(this.yBn).csz().mo(true);
        w.a(this.yBn).csz().mr(true);
        x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr forceBottomLoadData true needCheckHistoryTips true");
        this.yBn.yBi = false;
        this.yBn.yBj = true;
        d.pPH.a(403, 5, 1, false);
        q.Qd().a(new a(this.hEz, (int) this.yBr, (int) this.yBs, this.yBp, 1), this.yBn);
    }
}
