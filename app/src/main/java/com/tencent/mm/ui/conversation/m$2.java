package com.tencent.mm.ui.conversation;

class m$2 implements Runnable {
    final /* synthetic */ m zab;

    m$2(m mVar) {
        this.zab = mVar;
    }

    public final void run() {
        if (!this.zab.fAF.isFinishing()) {
            this.zab.yZE.setSelection(0);
        }
    }
}
