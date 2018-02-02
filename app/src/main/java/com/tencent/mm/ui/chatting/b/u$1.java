package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.sdk.platformtools.x;

class u$1 implements Runnable {
    final /* synthetic */ u yAV;

    public u$1(u uVar) {
        this.yAV = uVar;
    }

    public final void run() {
        if (!this.yAV.yAU) {
            this.yAV.yAU = true;
            this.yAV.yAK = -1;
            this.yAV.fhr.cpl();
            x.i("MicroMsg.ChattingUI.SearchImp", "dismiss fts highlight");
        }
    }
}
