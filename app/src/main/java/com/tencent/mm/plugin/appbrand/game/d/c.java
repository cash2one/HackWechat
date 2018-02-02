package com.tencent.mm.plugin.appbrand.game.d;

import com.tencent.mm.plugin.appbrand.game.d.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.ah;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.jsapi.l.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.a;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.HashSet;
import java.util.Map;

public final class c {
    private static final String[] iZA = new String[]{b.NAME};

    public static Map<String, e> ael() {
        Map<String, e> aft = g.aft();
        aft.putAll(g.afu());
        Object<e> hashSet = new HashSet();
        hashSet.add(new com.tencent.mm.plugin.appbrand.game.d.a.e());
        hashSet.add(new d());
        hashSet.add(new ah());
        hashSet.add(new b());
        hashSet.add(new com.tencent.mm.plugin.appbrand.jsapi.j.c());
        hashSet.add(new com.tencent.mm.plugin.appbrand.jsapi.j.b());
        hashSet.add(new com.tencent.mm.plugin.appbrand.jsapi.j.d());
        hashSet.add(new a());
        hashSet.add(new com.tencent.mm.plugin.appbrand.jsapi.video.d());
        hashSet.add(new com.tencent.mm.plugin.appbrand.jsapi.video.c());
        hashSet.add(new com.tencent.mm.plugin.appbrand.jsapi.video.b());
        hashSet.add(new a());
        for (e eVar : hashSet) {
            if (!(eVar == null || bh.ov(eVar.getName()))) {
                aft.put(eVar.getName(), eVar);
            }
        }
        for (Object remove : iZA) {
            aft.remove(remove);
        }
        return aft;
    }
}
