package com.tencent.mm.plugin.aa.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class AAQueryListUI$2 implements OnScrollListener {
    final /* synthetic */ AAQueryListUI iih;

    AAQueryListUI$2(AAQueryListUI aAQueryListUI) {
        this.iih = aAQueryListUI;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (AAQueryListUI.a(this.iih).getLastVisiblePosition() == AAQueryListUI.a(this.iih).getCount() - 1 && AAQueryListUI.a(this.iih).getCount() > 0 && !AAQueryListUI.b(this.iih) && !AAQueryListUI.c(this.iih)) {
            AAQueryListUI.a(this.iih).addFooterView(AAQueryListUI.d(this.iih));
            AAQueryListUI.a(this.iih, false, AAQueryListUI.e(this.iih));
        }
    }
}
