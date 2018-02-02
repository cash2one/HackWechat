package com.tencent.mapsdk.rastercore.tile;

import java.util.Comparator;

final class a$a implements Comparator<a> {
    private a$a() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        a aVar = (a) obj;
        a aVar2 = (a) obj2;
        return aVar == null ? -1 : aVar2 == null ? 1 : Float.compare(aVar.j(), aVar2.j());
    }
}
