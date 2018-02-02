package com.tencent.mm.ui.conversation;

class j$8 implements Runnable {
    final /* synthetic */ j yZL;

    j$8(j jVar) {
        this.yZL = jVar;
    }

    public final void run() {
        if (this.yZL.thisActivity() != null) {
            this.yZL.thisActivity().supportInvalidateOptionsMenu();
        }
    }
}
