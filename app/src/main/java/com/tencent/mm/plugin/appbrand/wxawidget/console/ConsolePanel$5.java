package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.view.View;
import android.view.View.OnFocusChangeListener;

class ConsolePanel$5 implements OnFocusChangeListener {
    final /* synthetic */ ConsolePanel khD;

    ConsolePanel$5(ConsolePanel consolePanel) {
        this.khD = consolePanel;
    }

    public final void onFocusChange(View view, boolean z) {
        if (!z) {
            f.ch(view);
        }
    }
}
