package com.tencent.mm.plugin.sns.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.plugin.sns.model.ae;

class SnsMsgUI$2 implements OnScrollListener {
    final /* synthetic */ SnsMsgUI rDE;

    SnsMsgUI$2(SnsMsgUI snsMsgUI) {
        this.rDE = snsMsgUI;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (SnsMsgUI.f(this.rDE) && absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
            if (ae.bvA().Tq() > 0) {
                ae.bvA().auv();
            } else {
                SnsMsgUI.d(this.rDE).awf();
            }
            SnsMsgUI.d(this.rDE).a(null, null);
        }
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
