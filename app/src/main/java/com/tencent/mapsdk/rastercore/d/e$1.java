package com.tencent.mapsdk.rastercore.d;

import com.tencent.mapsdk.rastercore.tile.MapTile.MapSource;
import com.tencent.mapsdk.rastercore.tile.a.a;

class e$1 extends Thread {
    e$1(e eVar) {
    }

    public final void run() {
        a.a().a(MapSource.BING, e.z());
        a.a().a(MapSource.SATELLITE, e.A());
    }
}
