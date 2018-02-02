package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetPerformanceUI.a;

class WxaWidgetPerformanceUI$3 implements OnClickListener {
    final /* synthetic */ WxaWidgetPerformanceUI iVh;
    final /* synthetic */ TextView iVi;

    WxaWidgetPerformanceUI$3(WxaWidgetPerformanceUI wxaWidgetPerformanceUI, TextView textView) {
        this.iVh = wxaWidgetPerformanceUI;
        this.iVi = textView;
    }

    public final void onClick(View view) {
        f.a("com.tencent.mm:support", null, a.class, null);
        c.clear();
        com.tencent.mm.plugin.appbrand.collector.f.reset();
        this.iVi.setText(c.qo("jsapi_draw_canvas").toString());
    }
}
