package com.tencent.mm.plugin.ipcall.ui;

import android.annotation.TargetApi;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class IPCallContactUI$11 implements OnScrollListener {
    final /* synthetic */ IPCallContactUI nIW;
    private int nIX = 0;

    IPCallContactUI$11(IPCallContactUI iPCallContactUI) {
        this.nIW = iPCallContactUI;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        this.nIX = i;
        this.nIW.aWs();
    }

    @TargetApi(11)
    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (IPCallContactUI.i(this.nIW) == -1) {
            IPCallContactUI.a(this.nIW, i);
        } else if (IPCallContactUI.j(this.nIW) == -1) {
            IPCallContactUI.b(this.nIW, i);
        }
    }
}
