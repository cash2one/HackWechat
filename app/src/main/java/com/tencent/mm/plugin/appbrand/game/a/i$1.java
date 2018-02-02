package com.tencent.mm.plugin.appbrand.game.a;

import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

class i$1 implements a {
    i$1() {
    }

    public final void a(String str, l lVar) {
        if (f.Zm() == null) {
            x.w("MicroMsg.SearchMiniGameQueryLogic", "onNotifyChange by SysConfigStorage, but sLayoutStorage is null.");
            return;
        }
        List linkedList;
        switch (lVar.iYZ) {
            case 2:
            case 3:
                linkedList = new LinkedList();
                if (!"batch".equals(str)) {
                    linkedList.addAll(f.Zm().qd(lVar.obj.toString()));
                } else if (lVar.obj != null && (lVar.obj instanceof List)) {
                    for (String qd : (List) lVar.obj) {
                        linkedList.addAll(f.Zm().qd(qd));
                    }
                } else {
                    return;
                }
                if (!linkedList.isEmpty()) {
                    f.Zm().b("batch", 3, linkedList);
                    return;
                }
                return;
            case 5:
                linkedList = new LinkedList();
                if (!"batch".equals(str)) {
                    linkedList.addAll(f.Zm().qd(lVar.obj.toString()));
                } else if (lVar.obj != null && (lVar.obj instanceof List)) {
                    for (String qd2 : (List) lVar.obj) {
                        linkedList.addAll(f.Zm().qd(qd2));
                    }
                } else {
                    return;
                }
                if (!linkedList.isEmpty()) {
                    f.Zm().b("batch", 5, linkedList);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
