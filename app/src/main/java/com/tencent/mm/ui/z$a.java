package com.tencent.mm.ui;

import android.content.Intent;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class z$a implements Runnable {
    int bjW;
    int fyV;
    Intent fyW;
    final /* synthetic */ z xLL;
    int xLT;

    private z$a(z zVar) {
        this.xLL = zVar;
        this.xLT = 0;
    }

    public final void run() {
        if (ar.Hj() && this.xLL.qwI != null) {
            x.i("MicroMsg.LauncherUI.NewChattingTabUI", "on post select image job, acc has ready, retry count %d", new Object[]{Integer.valueOf(this.xLT)});
            this.xLL.startChatting(this.xLL.xLG, null, false);
            ag.y(new 1(this));
        } else if (this.xLT >= 3) {
            x.w("MicroMsg.LauncherUI.NewChattingTabUI", "on post select image job, match max retry count");
        } else {
            boolean z;
            String str = "MicroMsg.LauncherUI.NewChattingTabUI";
            String str2 = "on post select image job, acc not ready or view init(%B), cur retry count %d";
            Object[] objArr = new Object[2];
            if (this.xLL.qwI != null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = Integer.valueOf(this.xLT);
            x.w(str, str2, objArr);
            this.xLT++;
            ag.h(this, 300);
        }
    }

    public final String toString() {
        return super.toString() + "|PostSelectImageJob";
    }
}
