package com.tencent.mm.plugin.product.ui;

import android.widget.ScrollView;
import com.tencent.mm.plugin.product.ui.MallProductUI.1;
import com.tencent.mm.plugin.wxpay.a.f;

class MallProductUI$1$1 implements Runnable {
    final /* synthetic */ 1 phc;

    MallProductUI$1$1(1 1) {
        this.phc = 1;
    }

    public final void run() {
        ScrollView scrollView = (ScrollView) this.phc.phb.findViewById(f.urq);
        if (scrollView != null) {
            scrollView.pageScroll(33);
        }
    }
}
