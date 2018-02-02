package com.tencent.mm.plugin.appbrand.game.a;

import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.game.a.a.b;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

enum i {
    ;
    
    private static a iYa;
    private static a iYb;

    static {
        iYa = new 1();
        iYb = new 2();
    }

    public static void onCreate() {
        q.abY().a(iYa, c.Dm().oAt.getLooper());
        if (f.Zm() != null) {
            f.Zm().c(iYb);
        }
    }

    public static void onDestroy() {
        q.abY().j(iYa);
        if (f.Zm() != null) {
            f.Zm().j(iYb);
        }
    }

    public static void d(a aVar) {
        if (f.Zv() != null) {
            f.Zv().c(aVar);
        }
    }

    public static void e(a aVar) {
        if (f.Zv() != null) {
            f.Zv().j(aVar);
        }
    }

    public static List<b> aea() {
        if (f.Zv() == null) {
            return null;
        }
        List<com.tencent.mm.plugin.appbrand.appusage.i> linkedList = new LinkedList();
        if (f.Zm() != null) {
            Collection abb = f.Zm().abb();
            if (!bh.cA(abb)) {
                linkedList.addAll(abb);
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            if (!((com.tencent.mm.plugin.appbrand.appusage.i) it.next()).Yz()) {
                it.remove();
            }
        }
        if (!bh.cA(linkedList)) {
            List arrayList = new ArrayList();
            for (com.tencent.mm.plugin.appbrand.appusage.i a : linkedList) {
                arrayList.add(a(a));
            }
            f.Zv().d(arrayList, false);
            x.i("MicroMsg.SearchMiniGameQueryLogic", "AppBrandRecentTaskInfo convert to MiniGameStorage, size:%d", new Object[]{Integer.valueOf(arrayList.size())});
        }
        x.i("MicroMsg.SearchMiniGameQueryLogic", "updateMiniGameList");
        return f.Zv().aeb();
    }

    public static b rH(String str) {
        if (f.Zv() != null) {
            return f.Zv().rH(str);
        }
        return null;
    }

    public static com.tencent.mm.plugin.appbrand.appusage.i rI(String str) {
        return f.Zm() == null ? null : f.Zm().qc(str);
    }

    private static com.tencent.mm.plugin.appbrand.game.a.a.a a(com.tencent.mm.plugin.appbrand.appusage.i iVar) {
        if (iVar == null) {
            return null;
        }
        com.tencent.mm.plugin.appbrand.game.a.a.a aVar = new com.tencent.mm.plugin.appbrand.game.a.a.a();
        aVar.gHg = iVar.gHg;
        aVar.ngo = iVar.appId;
        aVar.niZ = iVar.appName;
        aVar.nfT = iVar.iJJ;
        aVar.ksU = iVar.fnl;
        aVar.iGA = iVar.iGA;
        return aVar;
    }
}
