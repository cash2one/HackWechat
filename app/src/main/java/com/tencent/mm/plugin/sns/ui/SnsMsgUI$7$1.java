package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.ui.SnsMsgUI.7;
import com.tencent.mm.sdk.platformtools.x;

class SnsMsgUI$7$1 implements Runnable {
    final /* synthetic */ 7 rDG;

    SnsMsgUI$7$1(7 7) {
        this.rDG = 7;
    }

    public final void run() {
        synchronized (SnsMsgUI.d(this.rDG.rDE)) {
            x.v("MicroMsg.SnsMsgUI", "comment notify");
            SnsMsgUI.m(this.rDG.rDE);
            SnsMsgUI.d(this.rDG.rDE).a(null, null);
        }
    }
}
