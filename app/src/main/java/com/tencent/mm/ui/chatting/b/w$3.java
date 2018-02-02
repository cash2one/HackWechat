package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.sdk.platformtools.x;

class w$3 implements Runnable {
    final /* synthetic */ w yBn;

    w$3(w wVar) {
        this.yBn = wVar;
    }

    public final void run() {
        w.a(this.yBn).csz().mq(false);
        if (this.yBn.yBj) {
            this.yBn.yBj = false;
            w.a(this.yBn).csz().mn(w.a(this.yBn).csy().crN());
            w.a(this.yBn).csz().mo(w.a(this.yBn).csD());
            w.a(this.yBn).csz().mr(false);
            x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr onGetFinish set needCheckHistoryTips[%b]", new Object[]{Boolean.valueOf(this.yBn.yBj)});
        }
    }
}
