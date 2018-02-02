package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.view.View;
import android.view.View.OnClickListener;

class ConsolePanel$1 implements OnClickListener {
    final /* synthetic */ ConsolePanel khD;

    ConsolePanel$1(ConsolePanel consolePanel) {
        this.khD = consolePanel;
    }

    public final void onClick(View view) {
        this.khD.khq.clear();
        this.khD.khA.khq.clear();
        this.khD.khA.UR.notifyChanged();
    }
}
