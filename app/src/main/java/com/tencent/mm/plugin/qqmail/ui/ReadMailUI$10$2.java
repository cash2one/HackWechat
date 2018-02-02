package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.mm.plugin.qqmail.ui.ReadMailUI.10;
import com.tencent.mm.sdk.platformtools.x;

class ReadMailUI$10$2 implements Runnable {
    final /* synthetic */ 10 puL;

    ReadMailUI$10$2(10 10) {
        this.puL = 10;
    }

    public final void run() {
        int contentHeight = (int) (((float) ReadMailUI.g(this.puL.puG).getContentHeight()) * ReadMailUI.g(this.puL.puG).getScale());
        x.d("MicroMsg.ReadMailUI", ReadMailUI.g(this.puL.puG).getContentHeight() + "," + ReadMailUI.g(this.puL.puG).getHeight() + "," + ReadMailUI.g(this.puL.puG).getScale());
        if (Math.abs(contentHeight - ReadMailUI.g(this.puL.puG).getHeight()) < 10) {
            ReadMailUI.g(this.puL.puG).hr(true);
        }
    }
}
