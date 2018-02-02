package com.tencent.mm.ui;

import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;

class z$17 implements IdleHandler {
    final /* synthetic */ z xLL;

    z$17(z zVar) {
        this.xLL = zVar;
    }

    public final boolean queueIdle() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.xLL.xLA == null) {
            if (this.xLL.xLC == null) {
                this.xLL.xLC = v.fv(this.xLL.qwI).inflate(R.i.dcT, null);
            }
            if (this.xLL.xLD == null) {
                this.xLL.xLD = v.fv(this.xLL.qwI).inflate(R.i.cZW, null);
            }
        }
        x.i("MicroMsg.LauncherUI.NewChattingTabUI", "prepare chattingUI view use %dms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return false;
    }
}
