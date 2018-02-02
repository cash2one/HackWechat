package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bz.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.e;

class SettingsPanel$1 implements OnClickListener {
    final /* synthetic */ SettingsPanel khW;

    SettingsPanel$1(SettingsPanel settingsPanel) {
        this.khW = settingsPanel;
    }

    public final void onClick(View view) {
        ((e) g.h(e.class)).IW().restart();
        a.i(new 1(this), 2000);
    }
}
