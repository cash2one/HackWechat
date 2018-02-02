package com.tencent.mm.plugin.location.ui;

import com.tencent.mm.sdk.platformtools.x;

class h$2 implements Runnable {
    final /* synthetic */ h nTH;
    final /* synthetic */ int nTI;

    h$2(h hVar, int i) {
        this.nTH = hVar;
        this.nTI = i;
    }

    public final void run() {
        x.d("MicroMsg.ShareHeaderAvatarViewMgr", "scrollToTalker pos=%d", new Object[]{Integer.valueOf(this.nTI)});
        this.nTH.nTD.EN(this.nTI);
    }
}
