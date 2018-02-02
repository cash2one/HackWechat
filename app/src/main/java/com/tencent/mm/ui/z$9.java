package com.tencent.mm.ui;

import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class z$9 implements Runnable {
    final /* synthetic */ z xLL;

    z$9(z zVar) {
        this.xLL = zVar;
    }

    public final void run() {
        long currentTimeMillis = System.currentTimeMillis();
        ar.Dm().cfE();
        ag.Df(0);
        this.xLL.qwI.onSwipe(1.0f);
        if (this.xLL.xLA != null) {
            this.xLL.xLA.cyc();
        }
        if (this.xLL.xLx != null) {
            this.xLL.xLx.nWQ = true;
            this.xLL.xLx.csJ();
            this.xLL.xLx.mL(false);
        }
        this.xLL.tryResetChattingSwipeStatus();
        x.i("MicroMsg.LauncherUI.NewChattingTabUI", "doJobOnChattingAnimEnd cost:%s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    public final String toString() {
        return super.toString() + "|chattingView_onAnimationEnd";
    }
}
