package com.tencent.mapsdk.rastercore.tile;

import com.tencent.mapsdk.rastercore.d.e;
import com.tencent.mapsdk.rastercore.tile.a.a;
import com.tencent.mapsdk.rastercore.tile.a.c;
import com.tencent.tencentmap.mapsdk.map.g;
import java.util.ArrayList;

class b$2 implements Runnable {
    private /* synthetic */ ArrayList a;
    private /* synthetic */ b b;

    b$2(b bVar, ArrayList arrayList) {
        this.b = bVar;
        this.a = arrayList;
    }

    public final void run() {
        b.a(this.b).clear();
        synchronized (b.b(this.b)) {
            b.b(this.b).clear();
            b.b(this.b).putAll(b.c(this.b));
        }
        for (int i = 0; i < this.a.size(); i++) {
            for (a aVar : ((MapTile) this.a.get(i)).b()) {
                c a;
                try {
                    a = a.a().a(aVar);
                } catch (Throwable th) {
                    if (g.Aed != null) {
                        g.Aed.collectErrorInfo("TileEngineManager getTiles Runnable call CacheManager Get occured Exception,tileInfo:x=" + aVar.b() + ",y=" + aVar.c() + ",z=" + aVar.d() + "Exception Info:" + th.toString());
                    }
                    a = null;
                }
                if (a.b() != null && a.d() == aVar.l()) {
                    aVar.a(a.b());
                    if (aVar.m() == MapTile$MapSource.TENCENT) {
                        e.a++;
                    }
                    if (aVar.m() == MapTile$MapSource.BING) {
                        e.b++;
                    }
                } else if (a.b() != null && a.d() != aVar.l() && aVar.m() == MapTile$MapSource.TENCENT) {
                    new StringBuilder("Have got cache,but version is not ok,tileBitmap.getVersion：").append(a.d()).append(",tileData.getVersion:").append(aVar.l());
                    b.a(this.b, aVar, true, a);
                } else if (a.b() == null) {
                    b.a(this.b, aVar, false, null);
                    if (aVar.m() == MapTile$MapSource.TENCENT) {
                        b.d(this.b);
                        e.c++;
                    }
                    if (aVar.m() == MapTile$MapSource.BING) {
                        b.d(this.b);
                        e.d++;
                    }
                }
            }
            b.d(this.b).c().postInvalidate();
        }
    }
}
