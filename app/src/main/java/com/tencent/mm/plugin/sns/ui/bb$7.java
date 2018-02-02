package com.tencent.mm.plugin.sns.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.ca.d;
import com.tencent.mm.g.a.rt;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;

class bb$7 implements OnScrollListener {
    final /* synthetic */ bb rLm;

    bb$7(bb bbVar) {
        this.rLm = bbVar;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        bb.c(this.rLm).xM(i);
        if (i == 0) {
            b rtVar = new rt();
            rtVar.fJy.type = 5;
            rtVar.fJy.fJz = this.rLm.nKG.getFirstVisiblePosition();
            rtVar.fJy.fJA = this.rLm.nKG.getLastVisiblePosition();
            rtVar.fJy.fJB = this.rLm.nKG.getHeaderViewsCount();
            a.xef.m(rtVar);
            if ((bb.a(this.rLm) instanceof SnsTimeLineUI) && ((SnsTimeLineUI) bb.a(this.rLm)).rzU != null) {
                ((SnsTimeLineUI) bb.a(this.rLm)).rzU.btY();
            }
        }
        if (i == 2) {
            d.clq().de(bb.class.getName() + bb.c(this.rLm).getType() + ".Listview", 4);
            this.rLm.iL(true);
            return;
        }
        this.rLm.iL(false);
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.rLm.rLi = (i + i2) - 1;
        if (this.rLm.nKG.getLastVisiblePosition() == this.rLm.nKG.getCount() - 1 && this.rLm.nKG.getCount() != bb.f(this.rLm)) {
            x.d("MicroMsg.SnsActivity", "now refresh count: %s", new Object[]{Integer.valueOf(this.rLm.nKG.getCount())});
            bb.a(this.rLm, this.rLm.nKG.getCount());
            bb.g(this.rLm);
        }
    }
}
