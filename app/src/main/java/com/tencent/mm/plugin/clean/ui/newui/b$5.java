package com.tencent.mm.plugin.clean.ui.newui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.aq.o;

class b$5 implements OnScrollListener {
    final /* synthetic */ b lhJ;

    b$5(b bVar) {
        this.lhJ = bVar;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        o.PA().bp(i);
        if (i != 2) {
            b.a(this.lhJ, false);
            b.c(this.lhJ).removeCallbacksAndMessages(null);
            b.c(this.lhJ).sendEmptyMessageDelayed(0, 200);
            return;
        }
        b.a(this.lhJ, true);
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
