package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.mm.plugin.qqmail.ui.ReadMailUI.10;

class ReadMailUI$10$1 implements Runnable {
    final /* synthetic */ 10 puL;

    ReadMailUI$10$1(10 10) {
        this.puL = 10;
    }

    public final void run() {
        ReadMailUI.g(this.puL.puG).getSettings().setLoadsImagesAutomatically(true);
        ReadMailUI.g(this.puL.puG).getSettings().setSupportZoom(true);
        ReadMailUI.g(this.puL.puG).getSettings().setBuiltInZoomControls(true);
        ReadMailUI.g(this.puL.puG).ble();
        ReadMailUI.g(this.puL.puG).blf();
    }
}
