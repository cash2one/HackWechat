package com.tencent.mm.plugin.qqmail.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class MailAddrListUI$4 implements OnScrollListener {
    final /* synthetic */ MailAddrListUI psL;

    MailAddrListUI$4(MailAddrListUI mailAddrListUI) {
        this.psL = mailAddrListUI;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (1 == i) {
            this.psL.aWs();
        }
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
