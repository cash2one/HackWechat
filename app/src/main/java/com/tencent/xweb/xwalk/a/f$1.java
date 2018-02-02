package com.tencent.xweb.xwalk.a;

import java.util.TimerTask;
import org.xwalk.core.XWalkInitializer;

class f$1 extends TimerTask {
    final /* synthetic */ f AtU;

    f$1(f fVar) {
        this.AtU = fVar;
    }

    public final void run() {
        XWalkInitializer.addXWalkInitializeLog("task retry execute ! mRetrytimes = " + f.a(this.AtU));
        f.a(f.b(this.AtU), f.c(this.AtU), f.a(this.AtU));
        f.d(this.AtU);
    }
}
