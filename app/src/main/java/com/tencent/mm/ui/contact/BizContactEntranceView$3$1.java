package com.tencent.mm.ui.contact;

import android.widget.TextView;
import com.tencent.mm.ui.contact.BizContactEntranceView.3;

class BizContactEntranceView$3$1 implements Runnable {
    final /* synthetic */ long yRm;
    final /* synthetic */ long yRn;
    final /* synthetic */ 3 yRo;

    BizContactEntranceView$3$1(3 3, long j, long j2) {
        this.yRo = 3;
        this.yRm = j;
        this.yRn = j2;
    }

    public final void run() {
        TextView c = BizContactEntranceView.c(this.yRo.yRl);
        int i = (!BizContactEntranceView.b(this.yRo.yRl) || this.yRm <= this.yRn) ? 4 : 0;
        c.setVisibility(i);
    }
}
