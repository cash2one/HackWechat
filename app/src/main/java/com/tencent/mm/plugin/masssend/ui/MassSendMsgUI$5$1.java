package com.tencent.mm.plugin.masssend.ui;

import com.tencent.mm.plugin.masssend.ui.MassSendMsgUI.5;
import com.tencent.mm.sdk.platformtools.ag;

class MassSendMsgUI$5$1 implements Runnable {
    final /* synthetic */ int jqi;
    final /* synthetic */ String mjV;
    final /* synthetic */ String onT;
    final /* synthetic */ 5 onU;

    MassSendMsgUI$5$1(5 5, String str, String str2, int i) {
        this.onU = 5;
        this.mjV = str;
        this.onT = str2;
        this.jqi = i;
    }

    public final void run() {
        if (MassSendMsgUI.a(this.onU.onR, this.mjV, this.onT)) {
            ag.y(new 1(this));
        } else {
            ag.y(new 2(this));
        }
    }
}
