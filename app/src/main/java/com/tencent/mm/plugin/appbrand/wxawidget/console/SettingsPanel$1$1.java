package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.wxawidget.b$e;
import com.tencent.mm.plugin.appbrand.wxawidget.console.SettingsPanel.1;

class SettingsPanel$1$1 implements Runnable {
    final /* synthetic */ 1 khX;

    SettingsPanel$1$1(1 1) {
        this.khX = 1;
    }

    public final void run() {
        Toast.makeText(this.khX.khW.getContext(), b$e.khn, 1).show();
        if (SettingsPanel.a(this.khX.khW) != null) {
            SettingsPanel.a(this.khX.khW).run();
        }
    }
}
