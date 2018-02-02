package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements a {
    final /* synthetic */ b oCg;

    b$1(b bVar) {
        this.oCg = bVar;
    }

    public final boolean uF() {
        b.a(this.oCg);
        if (!this.oCg.fAs) {
            x.i("MicroMsg.ProgressHandlerAnimator", "isStart is false now");
            return false;
        } else if (this.oCg.oCd < this.oCg.oCb) {
            return true;
        } else {
            this.oCg.fAs = false;
            x.i("MicroMsg.ProgressHandlerAnimator", "reach end, currentValue: %s, end: %s, callback: %s", Float.valueOf(this.oCg.oCd), Float.valueOf(this.oCg.oCb), this.oCg.oCe);
            if (this.oCg.oCe != null) {
                this.oCg.oCe.onAnimationEnd();
            }
            return false;
        }
    }
}
