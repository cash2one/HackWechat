package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetPerformanceUI.e;

class WxaWidgetPerformanceUI$2 implements OnClickListener {
    final /* synthetic */ WxaWidgetPerformanceUI iVh;
    final /* synthetic */ TextView iVi;

    WxaWidgetPerformanceUI$2(WxaWidgetPerformanceUI wxaWidgetPerformanceUI, TextView textView) {
        this.iVh = wxaWidgetPerformanceUI;
        this.iVi = textView;
    }

    public final void onClick(View view) {
        String stringBuilder = c.qo("jsapi_draw_canvas").toString();
        StringBuilder stringBuilder2 = new StringBuilder();
        if (stringBuilder != null && stringBuilder.length() > 0) {
            stringBuilder2.append("data size :").append(c.aT("jsapi_draw_canvas", "__invoke_jsapi_data_size")).append("\n").append(stringBuilder);
        }
        IPCString iPCString = (IPCString) f.a("com.tencent.mm:support", new IPCString("widget_launch"), e.class);
        if (iPCString != null) {
            stringBuilder2.append("\n\n").append(iPCString);
        }
        if (com.tencent.mm.plugin.appbrand.collector.f.abr()) {
            stringBuilder2.append("\n\n").append(com.tencent.mm.plugin.appbrand.collector.f.abs());
        }
        this.iVi.setText(stringBuilder2.toString());
    }
}
