package com.tencent.mm.plugin.ipcall.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class IPCallMsgUI$5 implements OnScrollListener {
    final /* synthetic */ IPCallMsgUI nKK;

    IPCallMsgUI$5(IPCallMsgUI iPCallMsgUI) {
        this.nKK = iPCallMsgUI;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
            IPCallMsgUI$a b = IPCallMsgUI.b(this.nKK);
            if (!b.awe()) {
                b.kUH += 10;
                if (b.kUH > b.hKb) {
                    b.kUH = b.hKb;
                }
            } else if (IPCallMsgUI.d(b.nKK).getParent() != null) {
                IPCallMsgUI.a(b.nKK).removeFooterView(IPCallMsgUI.d(b.nKK));
            }
            IPCallMsgUI.b(this.nKK).a(null, null);
        }
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
