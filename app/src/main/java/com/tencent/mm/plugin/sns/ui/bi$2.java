package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

class bi$2 implements Runnable {
    int offset = 0;
    final /* synthetic */ bi rMW;

    bi$2(bi biVar) {
        this.rMW = biVar;
    }

    public final void run() {
        if (this.rMW.nKG != null && this.rMW.nKG.getCount() > this.rMW.position) {
            this.rMW.rBa = this.rMW.rrw.getTop();
            int i = (this.rMW.rBa - this.rMW.rMP) - this.rMW.rMN;
            x.d("MicroMsg.TimeLineScrollAnimation", "itemH:" + this.rMW.rMN + " footerTop" + this.rMW.rBa + " list.bottom:" + this.rMW.nKG.getBottom() + " position: " + this.rMW.position + " topselection: " + i);
            x.d("MicroMsg.TimeLineScrollAnimation", "list.getTop(): " + this.rMW.nKG.getTop() + " marginTop: " + this.rMW.rMP + " footerTop " + this.rMW.rBa);
            if (i == this.offset) {
                this.rMW.nKG.setSelectionFromTop(this.rMW.position + this.rMW.nKG.getHeaderViewsCount(), i);
                this.offset = 0;
                this.rMW.rMR = 0;
            } else if (bi.a(this.rMW) > 0) {
                new af().postDelayed(this, 100);
                this.offset = i;
            } else {
                this.offset = 0;
                this.rMW.rMR = 0;
            }
        }
    }
}
