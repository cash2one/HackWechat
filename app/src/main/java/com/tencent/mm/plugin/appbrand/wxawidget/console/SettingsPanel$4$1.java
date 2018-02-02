package com.tencent.mm.plugin.appbrand.wxawidget.console;

import com.tencent.mm.plugin.appbrand.wxawidget.console.SettingsPanel.4;
import com.tencent.mm.ui.widget.picker.a.a;

class SettingsPanel$4$1 implements a {
    final /* synthetic */ com.tencent.mm.ui.widget.picker.a khY;
    final /* synthetic */ 4 kia;

    SettingsPanel$4$1(4 4, com.tencent.mm.ui.widget.picker.a aVar) {
        this.kia = 4;
        this.khY = aVar;
    }

    public final void f(boolean z, Object obj) {
        this.khY.hide();
        if (z) {
            SettingsPanel.c(this.kia.khW).setText((CharSequence) obj);
        }
        SettingsPanel.b(this.kia.khW, this.khY.czu());
    }
}
