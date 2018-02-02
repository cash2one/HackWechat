package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.mars.cdn.CdnLogic;

class m$6 implements Runnable {
    final /* synthetic */ String hMZ;
    final /* synthetic */ m vrP;

    public m$6(m mVar, String str) {
        this.vrP = mVar;
        this.hMZ = str;
    }

    public final void run() {
        if (this.vrP.ch(this.hMZ)) {
            this.vrP.mHandler.sendEmptyMessage(20003);
            return;
        }
        this.vrP.mHandler.removeMessages(20003);
        this.vrP.mHandler.sendEmptyMessage(CdnLogic.kMediaTypeBackupFile);
    }
}
