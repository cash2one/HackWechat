package com.tencent.mm.plugin.appbrand.game.c;

import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Random;

public enum i {
    ;
    
    public ag iZo;
    public final f iZp;
    public final g iZq;
    public final h iZr;
    public e iZs;
    public Boolean iZt;
    public boolean iZu;
    public volatile boolean iZv;
    public long iZw;
    public String mAppId;

    private i(String str) {
        this.iZo = null;
        this.iZp = new f();
        this.iZq = new g();
        this.iZr = new h();
        this.iZt = null;
        this.iZu = false;
        this.iZv = false;
    }

    public static boolean a(int i, double d) {
        boolean z;
        x.i("MicroMsg.WAGamePerfManager", "WAGamePerfManager.shouldEnableReport gamePercentage = [%f]", Double.valueOf(d));
        if (new Random(((long) i) ^ System.nanoTime()).nextDouble() <= d) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.WAGamePerfManager", "shouldEnableReport() returned: [%b], localRandom = [%f] serverPercent = [%f]", Boolean.valueOf(z), Double.valueOf(r4), Double.valueOf(d));
        return z;
    }

    public final h aeh() {
        h hVar;
        synchronized (iZn) {
            if (this.iZv) {
                hVar = this.iZr;
            } else {
                hVar = null;
            }
        }
        return hVar;
    }

    public final f aei() {
        f fVar;
        synchronized (iZn) {
            if (this.iZv && this.iZu) {
                fVar = this.iZp;
            } else {
                fVar = null;
            }
        }
        return fVar;
    }

    public final g aej() {
        g gVar;
        synchronized (iZn) {
            if (this.iZv) {
                gVar = this.iZq;
            } else {
                gVar = null;
            }
        }
        return gVar;
    }

    public final ag aek() {
        if (this.iZo == null) {
            this.iZo = new ag("WAGamePerfManager_thread");
        }
        return this.iZo;
    }
}
