package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.support.v7.widget.LinearLayoutManager;
import java.util.List;

class ConsolePanel$9 implements Runnable {
    final /* synthetic */ ConsolePanel khD;
    final /* synthetic */ List khE;

    ConsolePanel$9(ConsolePanel consolePanel, List list) {
        this.khD = consolePanel;
        this.khE = list;
    }

    public final void run() {
        int itemCount = this.khD.khA.getItemCount();
        this.khD.khA.khq.addAll(this.khE);
        this.khD.khA.W(itemCount, this.khE.size());
        if (((LinearLayoutManager) this.khD.jLT.TV).fa() == itemCount - 1) {
            this.khD.jLT.smoothScrollToPosition(this.khD.khA.getItemCount() - 1);
        }
    }
}
