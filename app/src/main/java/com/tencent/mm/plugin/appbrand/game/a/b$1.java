package com.tencent.mm.plugin.appbrand.game.a;

import com.tencent.mm.plugin.appbrand.game.a.b.b;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

class b$1 implements a {
    final /* synthetic */ b iXQ;

    b$1(b bVar) {
        this.iXQ = bVar;
    }

    public final void a(String str, l lVar) {
        x.i("MicroMsg.FTS.FTS5SearchMiniGameLogic", "MiniGame storage change: event=%s | eventData=%s", new Object[]{str, lVar});
        List arrayList;
        switch (lVar.iYZ) {
            case 2:
            case 3:
                if (!"batch".equals(str)) {
                    arrayList = new ArrayList();
                    arrayList.add(lVar.obj.toString());
                    this.iXQ.gJk.a(65601, new b(this.iXQ, arrayList));
                    return;
                } else if (lVar.obj != null && (lVar.obj instanceof List)) {
                    this.iXQ.gJk.a(65601, new b(this.iXQ, (List) lVar.obj));
                    return;
                } else {
                    return;
                }
            case 5:
                if (!"batch".equals(str)) {
                    arrayList = new ArrayList();
                    arrayList.add(lVar.obj.toString());
                    this.iXQ.gJk.a(65601, new b$a(this.iXQ, arrayList));
                    return;
                } else if (lVar.obj != null && (lVar.obj instanceof List)) {
                    this.iXQ.gJk.a(65601, new b$a(this.iXQ, (List) lVar.obj));
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }
}
