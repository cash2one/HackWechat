package com.tencent.mm.plugin.appbrand.wxawidget.console;

import com.tencent.mm.plugin.appbrand.wxawidget.console.SettingsPanel.3;
import com.tencent.mm.ui.widget.picker.a.a;

class SettingsPanel$3$1 implements a {
    final /* synthetic */ com.tencent.mm.ui.widget.picker.a khY;
    final /* synthetic */ 3 khZ;

    SettingsPanel$3$1(3 3, com.tencent.mm.ui.widget.picker.a aVar) {
        this.khZ = 3;
        this.khY = aVar;
    }

    public final void f(boolean z, Object obj) {
        this.khY.hide();
        if (z) {
            this.khZ.khW.khS.setText((CharSequence) obj);
        }
        this.khZ.khW.mw(this.khY.czu());
    }
}
