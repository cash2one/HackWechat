package com.tencent.mm.plugin.appbrand.game.c;

import android.os.Process;
import com.tencent.mm.plugin.appbrand.performance.c;
import com.tencent.mm.sdk.platformtools.ak;

public final class f {
    public ak iZb;
    c iZc;
    volatile int iZd;
    public int iZe;

    public f() {
        this.iZd = 0;
        this.iZe = 1000;
        this.iZd = 0;
        this.iZc = new c(Process.myPid());
    }
}
