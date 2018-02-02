package com.tencent.mm.ui;

import android.view.View;
import com.tencent.mm.ui.base.preference.a;

class SingleChatInfoUI$2 implements Runnable {
    final /* synthetic */ int laD;
    final /* synthetic */ SingleChatInfoUI xMD;

    SingleChatInfoUI$2(SingleChatInfoUI singleChatInfoUI, int i) {
        this.xMD = singleChatInfoUI;
        this.laD = i;
    }

    public final void run() {
        View a = ((a) SingleChatInfoUI.a(this.xMD)).a(this.laD, this.xMD.nKG);
        if (a != null) {
            com.tencent.mm.ui.g.a.b(this.xMD.mController.xIM, a);
        }
    }
}
