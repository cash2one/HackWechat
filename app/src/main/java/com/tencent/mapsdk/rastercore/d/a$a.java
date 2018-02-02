package com.tencent.mapsdk.rastercore.d;

import com.tencent.mapsdk.rastercore.e.b;
import java.util.Comparator;

class a$a implements Comparator<Object> {
    private a$a(a aVar) {
    }

    public final int compare(Object obj, Object obj2) {
        b bVar = (b) obj;
        b bVar2 = (b) obj2;
        if (!(bVar == null || bVar2 == null)) {
            try {
                if (bVar.getZIndex() > bVar2.getZIndex()) {
                    return 1;
                }
                if (bVar.getZIndex() < bVar2.getZIndex()) {
                    return -1;
                }
            } catch (Exception e) {
            }
        }
        return 0;
    }
}
