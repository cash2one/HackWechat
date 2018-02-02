package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.view.View;
import android.view.View.OnClickListener;

class ConsolePanel$8 implements OnClickListener {
    final /* synthetic */ ConsolePanel khD;

    ConsolePanel$8(ConsolePanel consolePanel) {
        this.khD = consolePanel;
    }

    public final void onClick(View view) {
        int i = 0;
        while (i < this.khD.khx.length) {
            boolean z;
            View view2 = this.khD.khx[i];
            if (view2 == view) {
                z = true;
            } else {
                z = false;
            }
            view2.setSelected(z);
            if (z && this.khD.khB != i) {
                this.khD.khB = i;
                ConsolePanel.a(this.khD);
            }
            i++;
        }
    }
}
