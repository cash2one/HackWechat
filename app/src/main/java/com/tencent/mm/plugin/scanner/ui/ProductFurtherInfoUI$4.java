package com.tencent.mm.plugin.scanner.ui;

import android.support.v4.view.ViewPager.e;

class ProductFurtherInfoUI$4 implements e {
    final /* synthetic */ ProductFurtherInfoUI pVB;

    ProductFurtherInfoUI$4(ProductFurtherInfoUI productFurtherInfoUI) {
        this.pVB = productFurtherInfoUI;
    }

    public final void a(int i, float f, int i2) {
    }

    public final void ae(int i) {
        if (ProductFurtherInfoUI.b(this.pVB).getParent() != null) {
            ProductFurtherInfoUI.b(this.pVB).getParent().requestDisallowInterceptTouchEvent(true);
        }
        ProductFurtherInfoUI.c(this.pVB).xa(i);
    }

    public final void af(int i) {
    }
}
