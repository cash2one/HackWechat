package com.tencent.mm.plugin.search.ui;

class FTSAddFriendUI$7 implements Runnable {
    final /* synthetic */ FTSAddFriendUI qbQ;

    FTSAddFriendUI$7(FTSAddFriendUI fTSAddFriendUI) {
        this.qbQ = fTSAddFriendUI;
    }

    public final void run() {
        if (FTSAddFriendUI.j(this.qbQ) != null) {
            FTSAddFriendUI.j(this.qbQ).dismiss();
            FTSAddFriendUI.h(this.qbQ);
        }
    }
}
