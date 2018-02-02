package com.tencent.mm.plugin.search.ui;

import com.tencent.mm.g.a.ag;

class FTSAddFriendUI$6 implements Runnable {
    final /* synthetic */ FTSAddFriendUI qbQ;
    final /* synthetic */ ag qbS;

    FTSAddFriendUI$6(FTSAddFriendUI fTSAddFriendUI, ag agVar) {
        this.qbQ = fTSAddFriendUI;
        this.qbS = agVar;
    }

    public final void run() {
        FTSAddFriendUI.i(this.qbQ);
        if (this.qbS.foc.foh) {
            FTSAddFriendUI.b(this.qbQ, 1);
        } else {
            FTSAddFriendUI.b(this.qbQ, -1);
        }
        FTSAddFriendUI.g(this.qbQ);
    }
}
