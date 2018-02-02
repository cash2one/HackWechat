package com.tencent.mm.plugin.appbrand.game.a;

import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appusage.i;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

class i$2 implements a {
    i$2() {
    }

    public final void a(String str, l lVar) {
        x.i("MicroMsg.SearchMiniGameQueryLogic", "AppBrandUsage storage change: event=%s | eventData=%s", new Object[]{str, lVar});
        i rJ;
        List<String> list;
        List arrayList;
        switch (lVar.iYZ) {
            case 2:
            case 3:
                if (!"batch".equals(str)) {
                    rJ = i.rJ(lVar.obj.toString());
                    if (rJ != null) {
                        f.Zv().a(i.b(rJ), false, true);
                        return;
                    }
                    return;
                } else if (lVar.obj != null && (lVar.obj instanceof List)) {
                    list = (List) lVar.obj;
                    arrayList = new ArrayList();
                    for (String rJ2 : list) {
                        rJ = i.rJ(rJ2);
                        if (rJ != null) {
                            arrayList.add(i.b(rJ));
                        }
                    }
                    f.Zv().d(arrayList, true);
                    return;
                } else {
                    return;
                }
            case 5:
                if (!"batch".equals(str)) {
                    f.Zv().S(lVar.obj.toString(), true);
                    return;
                } else if (lVar.obj != null && (lVar.obj instanceof List)) {
                    list = (List) lVar.obj;
                    arrayList = new ArrayList();
                    for (String rJ22 : list) {
                        rJ = i.rJ(rJ22);
                        if (rJ != null) {
                            com.tencent.mm.plugin.appbrand.game.a.a.a b = i.b(rJ);
                            if (b != null) {
                                arrayList.add(b.gHg);
                            }
                        }
                    }
                    f.Zv().ab(arrayList);
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }
}
