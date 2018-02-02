package com.tencent.mm.plugin.topstory;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.a.b;
import com.tencent.mm.sdk.platformtools.ac;

public final class a implements com.tencent.mm.plugin.topstory.a.a {
    private com.tencent.mm.network.n.a lrp = new 1(this);
    private boolean seb;
    private boolean sec;
    private int sed = 0;
    private b see;
    private boolean sef;
    private int seg;

    public final void bFm() {
        this.seb = false;
        this.seg = bFs();
        g.Di().a(this.lrp);
    }

    public final void ahl() {
        g.Di().b(this.lrp);
        this.see = null;
        this.seg = 0;
        this.seb = false;
        this.sec = false;
        this.sed = 0;
    }

    public final boolean aCc() {
        return this.seg == 1;
    }

    public final boolean bFn() {
        return this.seg == 2;
    }

    public final boolean isConnected() {
        return this.seg != 0;
    }

    public final boolean bFo() {
        return this.seb;
    }

    public final void bFp() {
        this.seb = true;
    }

    public final void iX(boolean z) {
        this.sec = z;
    }

    public final boolean bFq() {
        return this.sec;
    }

    public final void yp(int i) {
        this.sed = i;
    }

    public final int bFr() {
        return this.sed;
    }

    public final void a(b bVar) {
        this.see = bVar;
    }

    public final void iY(boolean z) {
        this.sef = z;
        this.seg = bFs();
    }

    private int bFs() {
        if (!com.tinkerboots.sdk.b.a.isConnected(ac.getContext())) {
            return 0;
        }
        if (!com.tinkerboots.sdk.b.a.isWifi(ac.getContext()) || this.sef) {
            return 2;
        }
        return 1;
    }
}
