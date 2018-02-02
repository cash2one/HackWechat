package com.tencent.mm.z;

import com.tencent.mm.platformtools.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.x;

class ar$4 implements a {
    final /* synthetic */ ar hgf;

    ar$4(ar arVar) {
        this.hgf = arVar;
    }

    public final void a(ar arVar, x xVar) {
        String str = xVar.field_username;
        if (x.gy(xVar.field_username)) {
            xVar.setUsername(x.WD(xVar.field_username));
        }
        if (bh.ov(xVar.vQ())) {
            xVar.dd(c.om(xVar.field_nickname));
        }
        if (bh.ov(xVar.vR())) {
            xVar.de(c.ol(xVar.field_nickname));
        }
        if (bh.ov(xVar.field_conRemarkPYShort)) {
            xVar.dh(c.om(xVar.field_conRemark));
        }
        if (bh.ov(xVar.field_conRemarkPYFull)) {
            xVar.dg(c.ol(xVar.field_conRemark));
        }
        if (s.d(xVar)) {
            xVar.ex(43);
            xVar.dd(c.om(xVar.AP()));
            xVar.de(c.ol(xVar.AP()));
            xVar.dg(c.ol(xVar.AQ()));
            xVar.dh(xVar.AQ());
            return;
        }
        if (s.hn(str)) {
            x xVar2;
            xVar.Ag();
            xVar.eC(4);
            xVar.ex(33);
            if (xVar == null) {
                xVar2 = new x();
            } else {
                xVar2 = xVar;
            }
            xVar2.setUsername(str);
            xVar2.Ag();
            z.x(xVar2);
            xVar2.Ap();
        }
        if (xVar.AH()) {
            xVar.ex(xVar.Ad());
        }
        if (s.hd(str)) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.MMCore", "update official account helper showhead %d", new Object[]{Integer.valueOf(31)});
            xVar.ex(31);
        }
        if (xVar.AF()) {
            ar.Hg();
            c.Fd().d(new String[]{str}, "@blacklist");
        }
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.MMCore", "onPreInsertContact2: %s, %s", new Object[]{xVar.field_username, xVar.vQ()});
    }
}
