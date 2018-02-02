package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bz.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.e;

class WxaWidgetDebugUI$3 implements OnClickListener {
    final /* synthetic */ WxaWidgetDebugUI iVc;

    WxaWidgetDebugUI$3(WxaWidgetDebugUI wxaWidgetDebugUI) {
        this.iVc = wxaWidgetDebugUI;
    }

    public final void onClick(View view) {
        ((e) g.h(e.class)).IW().restart();
        a.i(new 1(this), 1000);
    }
}
