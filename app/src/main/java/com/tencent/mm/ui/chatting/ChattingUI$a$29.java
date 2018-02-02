package com.tencent.mm.ui.chatting;

import android.view.ViewGroup;
import com.tencent.mm.ag.f;
import com.tencent.mm.ag.y;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.chatting.b.w;
import com.tencent.mm.ui.chatting.b.w.9;
import com.tencent.mm.ui.o.a;
import com.tencent.mm.z.ar;

class ChattingUI$a$29 implements a {
    private int count = 0;
    final /* synthetic */ ChattingUI.a ywR;

    ChattingUI$a$29(ChattingUI.a aVar) {
        this.ywR = aVar;
    }

    public final void Xv() {
        if (this.ywR.csP()) {
            x.i("MicroMsg.ChattingUI", "onPostRset fragment not foreground, return");
            return;
        }
        x.i("MicroMsg.ChattingUI", "summerbadcr onPostReset needCheckHistoryTips[%b], BADCR_SCROLL_DELAY[%d]", new Object[]{Boolean.valueOf(this.ywR.yvO.yBj), Integer.valueOf(w.yBh)});
        if (this.ywR.ywm && com.tencent.mm.l.a.fZ(this.ywR.fAh.field_type) && this.ywR.fAh.cia()) {
            this.ywR.ywm = false;
            if (!f.eE(this.ywR.crz())) {
                y.Mo().b(this.ywR.crz(), this.ywR.ysf.getCount() > 0 ? (au) this.ywR.ysf.getItem(this.ywR.ysf.getCount() - 1) : null);
            }
        }
        this.ywR.yvN.ctR();
        ChattingUI.a.c(this.ywR).post(new Runnable(this) {
            final /* synthetic */ ChattingUI$a$29 ywY;

            {
                this.ywY = r1;
            }

            public final void run() {
                com.tencent.mm.plugin.report.service.f.vA(13);
            }
        });
        ChattingUI.a.g(this.ywR).mm(this.ywR.ysf.crM());
        ChattingUI.a.g(this.ywR).mn(this.ywR.ysf.crN());
        MMPullDownView g = ChattingUI.a.g(this.ywR);
        MMPullDownView.e((ViewGroup) g.ycD, 4);
        MMPullDownView.e((ViewGroup) g.xFj, 4);
        if (this.ywR.ysf.hKb - this.count > 0 && !this.ywR.yvY.ysa) {
            boolean z;
            x.i("MicroMsg.ChattingUI", "ncnt > 0 && (!isShowSearchChatResult) scroll to last");
            w wVar = this.ywR.yvO;
            if (!wVar.yBj || w.yBh <= 0) {
                z = false;
            } else {
                wVar.fhr.csx().getViewTreeObserver().addOnGlobalLayoutListener(new 9(wVar, System.currentTimeMillis()));
                z = true;
            }
            if (!z) {
                this.ywR.a(false, false, null);
            }
        }
        if (!this.ywR.yvY.yAJ && this.ywR.yvY.yAM && !ChattingUI.a.h(this.ywR).ytm && this.ywR.ysf.crJ()) {
            x.v("MicroMsg.ChattingUI", "useEditSearchMode && !chattingMoreHelper.inShowMode() && adapter.triggerMoveToLast()");
            this.ywR.a(false, false, null);
        }
        if (this.ywR.keyboardState() == 1) {
            x.v("MicroMsg.ChattingUI", "kbshown scroll to last");
            this.ywR.a(true, false, null);
        }
        ChattingUI.a aVar = this.ywR;
        if (aVar.csP() ? false : aVar.ywC) {
            ar.Dm().F(new 2(this));
        }
    }

    public final void Xw() {
        if (this.ywR.csP()) {
            x.i("MicroMsg.ChattingUI", "onPreReset fragment not foreground, return");
            return;
        }
        com.tencent.mm.plugin.report.service.f.vz(13);
        this.count = this.ywR.ysf.hKb;
    }
}
