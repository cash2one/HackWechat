package com.tencent.mm.plugin.sns.ui;

import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class bi {
    ListView nKG;
    int position = -1;
    int rBa = -1;
    int rMN = -1;
    int rMO = -1;
    public int rMP = 0;
    boolean rMQ = false;
    int rMR;
    protected long rMS;
    Runnable rMT = new Runnable(this) {
        final /* synthetic */ bi rMW;

        {
            this.rMW = r1;
        }

        public final void run() {
            if (this.rMW.nKG != null && this.rMW.nKG.getCount() > this.rMW.position) {
                int i;
                int top = this.rMW.rrw.getTop();
                x.d("MicroMsg.TimeLineScrollAnimation", "limitCount: " + this.rMW.rMR + " footerHeight:" + this.rMW.rrw.getHeight() + " listOriginalBottom: " + this.rMW.rzE);
                if (this.rMW.rMR = this.rMW.rMR - 1 > 0 && (this.rMW.rBa != top || top > this.rMW.rzE - 200 || this.rMW.nKG.getBottom() > (this.rMW.rzE - this.rMW.rrw.getHeight()) - 150)) {
                    i = 10;
                    if (this.rMW.rMR == 0) {
                        i = 200;
                    }
                    new af().postDelayed(this, (long) i);
                }
                this.rMW.rBa = top;
                i = (this.rMW.rBa - this.rMW.rMP) - this.rMW.rMN;
                x.d("MicroMsg.TimeLineScrollAnimation", "itemH:" + this.rMW.rMN + " footerTop" + this.rMW.rBa + " list.bottom:" + this.rMW.nKG.getBottom() + " position: " + this.rMW.position + " topselection: " + i);
                x.d("MicroMsg.TimeLineScrollAnimation", "list.getTop(): " + this.rMW.nKG.getTop() + " marginTop: " + this.rMW.rMP + " footerTop " + this.rMW.rBa);
                this.rMW.nKG.setSelectionFromTop(this.rMW.position + this.rMW.nKG.getHeaderViewsCount(), i);
            }
        }
    };
    Runnable rMU = new 2(this);
    Runnable rMV = new 3(this);
    SnsCommentFooter rrw;
    public int rzE = -1;

    public bi(ListView listView, SnsCommentFooter snsCommentFooter) {
        this.nKG = listView;
        this.rrw = snsCommentFooter;
    }

    public final void bCk() {
        this.rMQ = true;
        new af().postDelayed(this.rMT, 30);
        this.rMR = 10;
        x.e("MicroMsg.TimeLineScrollAnimation", "footerTop when up :" + this.rrw.getTop());
        this.rMS = bh.Wq();
    }

    public final void bCl() {
        this.rMQ = true;
        this.rMR = 20;
        new af().postDelayed(this.rMU, 100);
    }

    public final void bCm() {
        if (this.rMQ) {
            this.rMQ = false;
            new af().postDelayed(this.rMV, 30);
            this.rMR = 10;
        }
    }
}
