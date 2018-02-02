package com.tencent.mapsdk.rastercore.tile.b;

import com.tencent.mapsdk.raster.model.TileProvider;
import com.tencent.mapsdk.rastercore.d.e;
import com.tencent.mapsdk.rastercore.tile.MapTile.MapSource;
import java.util.Map;
import java.util.WeakHashMap;

public final class c {
    private static Map<MapSource, TileProvider> a = new WeakHashMap();

    public static TileProvider a(e eVar, MapSource mapSource) {
        int i = eVar.f().a() > 1 ? 2 : 1;
        TileProvider tileProvider = (TileProvider) a.get(mapSource);
        if (tileProvider != null) {
            return tileProvider;
        }
        switch (1.a[mapSource.ordinal()]) {
            case 1:
                tileProvider = new e(i);
                break;
            case 2:
                tileProvider = new b(i);
                break;
            case 3:
                tileProvider = new d(i);
                break;
            case 4:
                tileProvider = new f(i);
                break;
            default:
                return null;
        }
        a.put(mapSource, tileProvider);
        return tileProvider;
    }
}
