package com.tencent.mm.plugin.exdevice.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class ExdeviceRankInfoUI$5 implements OnScrollListener {
    final /* synthetic */ ExdeviceRankInfoUI lXj;

    ExdeviceRankInfoUI$5(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        this.lXj = exdeviceRankInfoUI;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        ExdeviceRankInfoUI.r(this.lXj);
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        ExdeviceRankInfoUI.r(this.lXj);
    }
}
