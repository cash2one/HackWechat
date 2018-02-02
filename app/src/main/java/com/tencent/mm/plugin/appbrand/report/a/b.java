package com.tencent.mm.plugin.appbrand.report.a;

import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.report.f;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.LinkedList;

public final class b {
    private final LinkedList<Runnable> jHA = new LinkedList();
    final f jHw;
    volatile String jHx;
    volatile long jHy = 0;
    volatile long jHz = 0;
    volatile String mAppId;

    public b(int i) {
        this.jHw = new f("MicroMsg.AppBrandPageViewStatistics[" + i + "]");
    }

    public final boolean ic() {
        return this.jHy > 0 && this.jHz <= 0;
    }

    public final void f(e eVar) {
        this.mAppId = eVar.mAppId;
    }

    public final void ua(String str) {
        this.jHy = bh.Wp();
        this.jHw.ajO();
        this.jHx = str;
    }

    public final void ajQ() {
        this.jHz = bh.Wp() - this.jHy;
    }

    public final void afA() {
        this.jHw.ajP();
        if (this.jHw.ajN()) {
            ajR();
        } else {
            ag.y(new 1(this));
        }
    }

    public final void aga() {
        if (this.jHy > 0) {
            this.jHw.ajO();
            this.jHA.clear();
        }
    }

    public final void onDestroy() {
        this.jHw.ajP();
        f fVar = this.jHw;
        fVar.quit();
        fVar.mStopped = true;
    }

    public final void r(Runnable runnable) {
        if (this.jHw.ajN()) {
            runnable.run();
        } else {
            this.jHA.addLast(runnable);
        }
    }

    final void ajR() {
        while (!this.jHA.isEmpty()) {
            ((Runnable) this.jHA.pollFirst()).run();
        }
    }
}
