package com.tencent.mm.ui.chatting;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMPullDownView$e;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.b.t;

class ChattingUI$a$3 implements MMPullDownView$e {
    final /* synthetic */ a ywR;

    ChattingUI$a$3(a aVar) {
        this.ywR = aVar;
    }

    public final boolean azk() {
        x.i("MicroMsg.ChattingUI", "summerbadcr onBottomLoadData isChatroomChat[%b], needCheckHistoryTips[%b]", new Object[]{Boolean.valueOf(this.ywR.ysk), Boolean.valueOf(this.ywR.yvO.yBj)});
        if (this.ywR.yvY.ysa || this.ywR.yvY.yAM) {
            this.ywR.ysf.ytk = true;
        }
        if (this.ywR.ysk && this.ywR.yvO.yBj) {
            return false;
        }
        if (this.ywR.ysf.crN()) {
            x.i("MicroMsg.ChattingUI", "pullDownView showButtomAll on set position %d", new Object[]{Integer.valueOf(this.ywR.ysf.getCount() - 1)});
            a.c(this.ywR).setSelection(this.ywR.ysf.getCount() - 1);
            a.g(this.ywR).mn(true);
            return true;
        }
        int count = this.ywR.ysf.getCount();
        this.ywR.ysf.a(null);
        if (this.ywR.ysf.getCount() > count) {
            x.i("MicroMsg.ChattingUI", "pullDownView height: " + a.g(this.ywR).getHeight() + ", chatHistoryList height: " + a.c(this.ywR).getHeight() + " header height: " + this.ywR.ywh.ctA() + " topHeight: " + a.g(this.ywR).ycr);
            t.a(a.c(this.ywR), count + 1, (a.c(this.ywR).getHeight() - this.ywR.ywh.ctA()) - a.g(this.ywR).ycr, false);
        }
        return true;
    }
}
