package com.tencent.mm.plugin.appbrand.f;

import com.tencent.mm.plugin.appbrand.f.b.b;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class b$1 implements a {
    final /* synthetic */ b iVS;

    b$1(b bVar) {
        this.iVS = bVar;
    }

    public final void a(String str, l lVar) {
        x.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "WeApp storage change: event=%s | eventData=%s", new Object[]{str, lVar});
        switch (lVar.iYZ) {
            case 2:
            case 3:
                if (!"batch".equals(str)) {
                    this.iVS.gJk.a(65616, new b(this.iVS, lVar.obj.toString()));
                    return;
                } else if (lVar.obj != null && (lVar.obj instanceof List)) {
                    for (String bVar : (List) lVar.obj) {
                        this.iVS.gJk.a(65616, new b(this.iVS, bVar));
                    }
                    return;
                } else {
                    return;
                }
            case 5:
                if (!"batch".equals(str)) {
                    this.iVS.gJk.a(65616, new b.a(this.iVS, lVar.obj.toString()));
                    return;
                } else if (lVar.obj != null && (lVar.obj instanceof List)) {
                    for (String bVar2 : (List) lVar.obj) {
                        this.iVS.gJk.a(65616, new b.a(this.iVS, bVar2));
                    }
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }
}
