package com.tencent.mm.plugin.record.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.g.a.rt;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;

class RecordMsgBaseUI$1 implements OnScrollListener {
    final /* synthetic */ RecordMsgBaseUI pGf;

    RecordMsgBaseUI$1(RecordMsgBaseUI recordMsgBaseUI) {
        this.pGf = recordMsgBaseUI;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            b rtVar = new rt();
            rtVar.fJy.type = 5;
            rtVar.fJy.fJz = this.pGf.kGl.getFirstVisiblePosition();
            rtVar.fJy.fJA = this.pGf.kGl.getLastVisiblePosition();
            rtVar.fJy.fJB = this.pGf.kGl.getHeaderViewsCount();
            a.xef.m(rtVar);
        }
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
