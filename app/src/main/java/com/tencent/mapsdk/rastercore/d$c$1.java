package com.tencent.mapsdk.rastercore;

import com.tencent.mapsdk.rastercore.d.c;
import com.tencent.mapsdk.rastercore.tile.MapTile.MapSource;
import com.tencent.mapsdk.rastercore.tile.a.a;

class d$c$1 extends Thread {
    private /* synthetic */ boolean a;
    private /* synthetic */ boolean b;
    private /* synthetic */ boolean c;

    d$c$1(c cVar, boolean z, boolean z2, boolean z3) {
        this.a = z;
        this.b = z2;
        this.c = z3;
    }

    public final void run() {
        if (this.a) {
            a.a().a(MapSource.TENCENT);
        }
        if (this.b) {
            a.a().a(MapSource.BING);
        }
        if (this.c) {
            a.a().a(MapSource.SATELLITE);
        }
    }
}
