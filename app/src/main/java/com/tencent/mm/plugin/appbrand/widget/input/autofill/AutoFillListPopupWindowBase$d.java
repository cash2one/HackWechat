package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class AutoFillListPopupWindowBase$d implements OnScrollListener {
    final /* synthetic */ AutoFillListPopupWindowBase kaA;

    private AutoFillListPopupWindowBase$d(AutoFillListPopupWindowBase autoFillListPopupWindowBase) {
        this.kaA = autoFillListPopupWindowBase;
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (AutoFillListPopupWindowBase.a(this.kaA) != null && AutoFillListPopupWindowBase.e(this.kaA) != null && AutoFillListPopupWindowBase.f(this.kaA) != null && AutoFillListPopupWindowBase.a(this.kaA) != null) {
            if (AutoFillListPopupWindowBase.a(this.kaA).getLastVisiblePosition() != AutoFillListPopupWindowBase.f(this.kaA).getCount() - 1 || AutoFillListPopupWindowBase.a(this.kaA).getChildAt(AutoFillListPopupWindowBase.a(this.kaA).getChildCount() - 1) == null || AutoFillListPopupWindowBase.a(this.kaA).getChildAt(AutoFillListPopupWindowBase.a(this.kaA).getChildCount() - 1).getBottom() > AutoFillListPopupWindowBase.a(this.kaA).getHeight()) {
                AutoFillListPopupWindowBase.e(this.kaA).setVisibility(0);
            } else {
                AutoFillListPopupWindowBase.e(this.kaA).setVisibility(8);
            }
        }
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1 && !this.kaA.isInputMethodNotNeeded() && AutoFillListPopupWindowBase.b(this.kaA).getContentView() != null) {
            AutoFillListPopupWindowBase.d(this.kaA).removeCallbacks(AutoFillListPopupWindowBase.c(this.kaA));
            AutoFillListPopupWindowBase.c(this.kaA).run();
        }
    }
}
