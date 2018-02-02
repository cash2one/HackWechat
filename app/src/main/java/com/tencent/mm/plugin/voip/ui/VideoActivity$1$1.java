package com.tencent.mm.plugin.voip.ui;

import com.tencent.mm.plugin.voip.ui.VideoActivity.1;
import com.tencent.mm.sdk.platformtools.x;

class VideoActivity$1$1 implements Runnable {
    final /* synthetic */ 1 spZ;

    VideoActivity$1$1(1 1) {
        this.spZ = 1;
    }

    public final void run() {
        if (this.spZ.spY.spN != null && this.spZ.spY.spN.get() != null) {
            boolean bGQ = ((c) this.spZ.spY.spN.get()).bGQ();
            boolean bGP = ((c) this.spZ.spY.spN.get()).bGP();
            boolean bGJ = ((c) this.spZ.spY.spN.get()).bGJ();
            x.i("MicroMsg.Voip.VideoActivity", "summerkick LogoutEvent ret[%b, %b, %b]", new Object[]{Boolean.valueOf(bGQ), Boolean.valueOf(bGP), Boolean.valueOf(bGJ)});
        }
    }
}
