package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import com.tencent.mm.plugin.sns.ui.j.1;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

class j$1$1 implements Runnable {
    int count = 20;
    final /* synthetic */ int kI;
    final /* synthetic */ int rrL;
    final /* synthetic */ int rrM;
    final /* synthetic */ 1 rrN;
    final /* synthetic */ View zS;

    j$1$1(1 1, int i, int i2, int i3, View view) {
        this.rrN = 1;
        this.kI = i;
        this.rrL = i2;
        this.rrM = i3;
        this.zS = view;
    }

    public final void run() {
        this.rrN.rrK.nKG.setSelectionFromTop(this.kI + this.rrN.rrK.nKG.getHeaderViewsCount(), this.rrL + this.rrM);
        this.count--;
        x.d("MicroMsg.TimelineClickListener", "count: %s, delt: %s", new Object[]{Integer.valueOf(this.count), Integer.valueOf(Math.abs(this.zS.getTop() - (this.rrL + this.rrM)))});
        if (this.count <= 0 || Math.abs(this.zS.getTop() - (this.rrL + this.rrM)) < 5) {
            x.d("MicroMsg.TimelineClickListener", "count: %s", new Object[]{Integer.valueOf(this.count)});
            this.rrN.rrK.qZU.notifyDataSetChanged();
            return;
        }
        new af().postDelayed(this, 5);
    }
}
