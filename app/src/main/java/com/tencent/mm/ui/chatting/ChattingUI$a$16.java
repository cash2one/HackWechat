package com.tencent.mm.ui.chatting;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.tools.o;

class ChattingUI$a$16 implements Runnable {
    final /* synthetic */ a ywR;
    final /* synthetic */ int ywV;

    ChattingUI$a$16(a aVar, int i) {
        this.ywR = aVar;
        this.ywV = i;
    }

    public final void run() {
        x.i("MicroMsg.ChattingUI", "summerbadcr dz: scroll to fSelect:%d", new Object[]{Integer.valueOf(this.ywV)});
        o oVar = new o(a.c(this.ywR));
        int headerViewsCount = a.c(this.ywR).getHeaderViewsCount() + this.ywV;
        oVar.pch.removeCallbacks(oVar);
        oVar.zmg = System.currentTimeMillis();
        oVar.zml = 0;
        int firstVisiblePosition = oVar.pch.getFirstVisiblePosition();
        int childCount = (oVar.pch.getChildCount() + firstVisiblePosition) - 1;
        if (headerViewsCount <= firstVisiblePosition) {
            firstVisiblePosition = (firstVisiblePosition - headerViewsCount) + 1;
            oVar.mMode = 2;
        } else if (headerViewsCount >= childCount) {
            firstVisiblePosition = (headerViewsCount - childCount) + 1;
            oVar.mMode = 1;
        } else {
            return;
        }
        if (firstVisiblePosition > 0) {
            oVar.zmj = 1000 / firstVisiblePosition;
        } else {
            oVar.zmj = 1000;
        }
        oVar.zmh = headerViewsCount;
        oVar.zmi = -1;
        oVar.pch.post(oVar);
    }
}
