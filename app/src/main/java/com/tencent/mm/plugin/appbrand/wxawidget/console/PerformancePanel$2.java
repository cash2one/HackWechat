package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.plugin.appbrand.wxawidget.console.PerformancePanel.a;

class PerformancePanel$2 implements OnClickListener {
    final /* synthetic */ TextView iVi;
    final /* synthetic */ PerformancePanel khR;

    PerformancePanel$2(PerformancePanel performancePanel, TextView textView) {
        this.khR = performancePanel;
        this.iVi = textView;
    }

    public final void onClick(View view) {
        f.a("com.tencent.mm:support", null, a.class, null);
        c.clear();
        com.tencent.mm.plugin.appbrand.collector.f.reset();
        this.iVi.setText(c.qo("jsapi_draw_canvas").toString());
    }
}
