package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

class h$b extends TextView {
    final /* synthetic */ h jNe;
    private String mTitle;
    private String mValue;

    static /* synthetic */ void a(h$b com_tencent_mm_plugin_appbrand_ui_h_b, String str) {
        com_tencent_mm_plugin_appbrand_ui_h_b.mValue = str;
        com_tencent_mm_plugin_appbrand_ui_h_b.update();
    }

    static /* synthetic */ void b(h$b com_tencent_mm_plugin_appbrand_ui_h_b, String str) {
        com_tencent_mm_plugin_appbrand_ui_h_b.mTitle = str;
        com_tencent_mm_plugin_appbrand_ui_h_b.update();
    }

    public h$b(h hVar, Context context) {
        this.jNe = hVar;
        super(context);
        setLayoutParams(new LayoutParams(-1, -2));
        setTextSize(1, 12.0f);
        setTextColor(-419430401);
    }

    private void update() {
        setText(String.format("%s: %s", new Object[]{this.mTitle, this.mValue}));
    }
}
