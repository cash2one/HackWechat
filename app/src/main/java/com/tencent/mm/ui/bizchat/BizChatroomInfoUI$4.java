package com.tencent.mm.ui.bizchat;

import android.view.View;
import com.tencent.mm.ui.base.preference.a;

class BizChatroomInfoUI$4 implements Runnable {
    final /* synthetic */ int laD;
    final /* synthetic */ BizChatroomInfoUI yoK;

    BizChatroomInfoUI$4(BizChatroomInfoUI bizChatroomInfoUI, int i) {
        this.yoK = bizChatroomInfoUI;
        this.laD = i;
    }

    public final void run() {
        View a = ((a) BizChatroomInfoUI.a(this.yoK)).a(this.laD, this.yoK.nKG);
        if (a != null) {
            com.tencent.mm.ui.g.a.b(this.yoK.mController.xIM, a);
        }
    }
}
