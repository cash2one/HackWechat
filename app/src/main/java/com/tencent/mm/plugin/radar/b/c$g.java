package com.tencent.mm.plugin.radar.b;

import b.c.b.e;
import com.tencent.mm.ae.d;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.radar.b.c.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.x;
import com.tencent.mm.z.bs.a;
import java.util.Map;

public final class c$g implements a {
    final /* synthetic */ c pwG;
    private final String pwO = ".sysmsg.addcontact.type";
    private final String pwP = ".sysmsg.addcontact.username";
    private final String pwQ = ".sysmsg.addcontact.encryptusername";

    c$g(c cVar) {
        this.pwG = cVar;
    }

    public final void a(d.a aVar) {
        e.i(aVar, "addMsgInfo");
        Map y = bi.y(n.a(aVar.hmq.vGZ), "sysmsg");
        if (y != null && e.h((String) y.get(this.pwO), (Object) "1")) {
            int i;
            b bVar;
            String str = (String) y.get(this.pwP);
            String str2 = (String) y.get(this.pwQ);
            CharSequence charSequence = str;
            if (charSequence == null || b.f.a.X(charSequence)) {
                i = 1;
            } else {
                i = 0;
            }
            if (i == 0) {
                charSequence = str2;
                i = (charSequence == null || b.f.a.X(charSequence)) ? 1 : 0;
                if (i == 0) {
                    x xVar = new x();
                    xVar.setUsername(str);
                    xVar.di(str2);
                    c.c(this.pwG, xVar);
                    bVar = c.pwC;
                    com.tencent.mm.sdk.platformtools.x.d(c.access$getTAG$cp(), "receive contact added system message useranme %s, encypt %s", new Object[]{xVar.getUsername(), xVar.vS()});
                    return;
                }
            }
            bVar = c.pwC;
            com.tencent.mm.sdk.platformtools.x.e(c.access$getTAG$cp(), "error! server return incorrect content! : %s", new Object[]{r5});
        }
    }
}
