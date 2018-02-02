package com.tencent.mm.ui.bizchat;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.aq.o;

class BizChatAtSomeoneUI$4 implements OnScrollListener {
    final /* synthetic */ BizChatAtSomeoneUI yne;

    BizChatAtSomeoneUI$4(BizChatAtSomeoneUI bizChatAtSomeoneUI) {
        this.yne = bizChatAtSomeoneUI;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        o.PA().bp(i);
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
