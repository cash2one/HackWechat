package com.tencent.mm.pluginsdk.i.a.b;

import com.tencent.mm.ae.d;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.bs.a;
import java.util.Map;

class b$a$2 implements a {
    final /* synthetic */ b.a vgJ;

    b$a$2(b.a aVar) {
        this.vgJ = aVar;
    }

    public final void a(d.a aVar) {
        String a = n.a(aVar.hmq.vGZ);
        if (bh.ov(a)) {
            x.w("MicroMsg.ResDownloader.CheckResUpdateHelper", "msg content is null");
            return;
        }
        x.d("MicroMsg.CheckResUpdateNewXmlParser", "receive msg: \n" + a);
        if (!bh.ov(a)) {
            Map y = bi.y(a, "sysmsg");
            j.I(0, 0);
            String str = "MicroMsg.CheckResUpdateNewXmlParser";
            String str2 = "parsed values.size = %s";
            Object[] objArr = new Object[1];
            objArr[0] = y == null ? "null" : String.valueOf(y.size());
            x.i(str, str2, objArr);
            if (y == null) {
                j.I(0, 30);
            } else {
                j.I(0, 31);
            }
            if (y != null && y.size() > 0 && bh.ou((String) y.get(".sysmsg.$type")).equalsIgnoreCase("resourcemgr")) {
                e.f(".sysmsg", "delete", y);
                e.f(".sysmsg", "cache", y);
                e.f(".sysmsg", "decrypt", y);
            }
        }
    }
}
