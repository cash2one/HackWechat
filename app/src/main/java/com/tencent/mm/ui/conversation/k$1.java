package com.tencent.mm.ui.conversation;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.ca.d;

class k$1 implements OnScrollListener {
    final /* synthetic */ k yZT;

    k$1(k kVar) {
        this.yZT = kVar;
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 2) {
            d.clq().de(j.class.getName() + ".Listview", 4);
        }
        if (i != 0) {
            this.yZT.cwM();
        } else if (this.yZT.yVR != null) {
            k.a(this.yZT, -1);
        }
    }
}
