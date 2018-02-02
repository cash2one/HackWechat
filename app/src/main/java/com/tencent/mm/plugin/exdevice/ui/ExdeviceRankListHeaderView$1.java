package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.view.View.OnClickListener;

class ExdeviceRankListHeaderView$1 implements OnClickListener {
    final /* synthetic */ ExdeviceRankListHeaderView lXs;

    ExdeviceRankListHeaderView$1(ExdeviceRankListHeaderView exdeviceRankListHeaderView) {
        this.lXs = exdeviceRankListHeaderView;
    }

    public final void onClick(View view) {
        if (ExdeviceRankListHeaderView.a(this.lXs)) {
            ExdeviceRankListHeaderView.b(this.lXs);
        }
        if (ExdeviceRankListHeaderView.c(this.lXs) != null) {
            ExdeviceRankListHeaderView.c(this.lXs).onClick(this.lXs);
        }
    }
}
