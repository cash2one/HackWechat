package com.tencent.mm.ui.conversation;

import com.tencent.mm.ui.LauncherUI;

class m$10 implements Runnable {
    final /* synthetic */ m zab;

    m$10(m mVar) {
        this.zab = mVar;
    }

    public final void run() {
        m mVar = this.zab;
        LauncherUI launcherUI = (LauncherUI) mVar.fAF;
        if (launcherUI == null || launcherUI.xGS.xGh.mnk == 0) {
            mVar.yZE.clz();
        }
    }
}
