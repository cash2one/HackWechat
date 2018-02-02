package com.tencent.mm.plugin.appbrand.menu;

import com.tencent.mm.plugin.appbrand.menu.a.a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class n {
    public Map<Integer, a> jAV;

    private n() {
        this.jAV = new HashMap();
        a(new b());
        a(new a());
        a(new d());
        a(new g());
        a(new MenuDelegate_SendToDesktop());
        a(new h());
        a(new j());
        a(new k());
        a(new MenuDelegate_EnableDebug());
        a(new i());
        a(new f());
        a(new e());
        a(new c());
    }

    public static l d(List<l> list, int i) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        for (l lVar : list) {
            if (lVar != null && lVar.id == i) {
                return lVar;
            }
        }
        return null;
    }

    public static void a(List<l> list, int i, boolean z) {
        l lVar = new l(i);
        lVar.jAF = z;
        list.add(lVar);
    }

    private void a(a aVar) {
        this.jAV.put(Integer.valueOf(aVar.jAX), aVar);
    }
}
