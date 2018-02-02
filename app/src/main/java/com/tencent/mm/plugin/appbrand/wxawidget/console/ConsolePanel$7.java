package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class ConsolePanel$7 implements OnTouchListener {
    final /* synthetic */ ConsolePanel khD;

    ConsolePanel$7(ConsolePanel consolePanel) {
        this.khD = consolePanel;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        f.ch(view);
        return false;
    }
}
