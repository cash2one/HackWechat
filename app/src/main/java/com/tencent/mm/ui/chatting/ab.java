package com.tencent.mm.ui.chatting;

import com.tencent.mm.aq.e;
import com.tencent.mm.aq.o;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.g.a;

public final class ab {
    public static String fY(long j) {
        String f = f(o.Pw().bi(j));
        return f != null ? f : null;
    }

    public static String fZ(long j) {
        String f = f(o.Pw().bh(j));
        return f != null ? f : null;
    }

    private static String f(e eVar) {
        if (eVar != null) {
            String str;
            if (eVar.Pe()) {
                str = eVar.hzQ;
                if (str != null && com.tencent.mm.a.e.bO(str)) {
                    return str;
                }
            }
            str = o.Pw().m(eVar.hzQ, null, null);
            if (str != null && com.tencent.mm.a.e.bO(str)) {
                return str;
            }
            str = o.Pw().m(eVar.hzS, null, null);
            if (str != null && com.tencent.mm.a.e.bO(str)) {
                return str;
            }
        }
        return null;
    }

    public static String a(au auVar, a aVar) {
        String str = "";
        if (!(aVar == null || bh.ov(aVar.fny))) {
            b Rz = an.aqd().Rz(aVar.fny);
            if (Rz != null && Rz.aOC() && com.tencent.mm.a.e.bO(Rz.field_fileFullPath)) {
                str = Rz.field_fileFullPath;
            }
        }
        if (bh.ov(str)) {
            if (auVar != null) {
                str = o.Pw().B(auVar.field_imgPath, true);
            }
            x.d("MicroMsg.HistoryExportUtil", "try get thumb appmsg image path finish, %s", new Object[]{str});
        } else {
            x.d("MicroMsg.HistoryExportUtil", "get hd appmsg image path ok, %s", new Object[]{str});
        }
        return str;
    }
}
