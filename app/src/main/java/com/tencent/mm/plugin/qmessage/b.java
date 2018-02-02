package com.tencent.mm.plugin.qmessage;

import com.tencent.mm.g.a.lz;
import com.tencent.mm.g.b.af;
import com.tencent.mm.l.a;
import com.tencent.mm.plugin.qmessage.a.d;
import com.tencent.mm.plugin.qmessage.a.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.x;
import com.tencent.mm.z.ar;

public final class b extends c<lz> {
    public b() {
        this.xen = lz.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
        lz lzVar = (lz) bVar;
        switch (lzVar.fDy.opType) {
            case 0:
                String str = lzVar.fDy.fDA;
                String str2 = lzVar.fDy.fDB;
                ar.Hg();
                a WO = com.tencent.mm.z.c.EY().WO(str);
                if (WO == null || ((int) WO.gJd) == 0) {
                    af xVar = new x(str);
                    xVar.Am();
                    xVar.dc(str2);
                    xVar.eG(4);
                    ar.Hg();
                    com.tencent.mm.z.c.EY().R(xVar);
                    com.tencent.mm.ad.b.iU(xVar.field_username);
                }
                d HD = g.bjY().HD(str);
                if (HD == null || bh.ou(HD.getUsername()).length() <= 0) {
                    HD = new d();
                    HD.fDt = -1;
                    HD.pnt = 1;
                    HD.username = str;
                    HD.pnu = 0;
                    HD.pnv = 0;
                    if (!g.bjY().a(HD)) {
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.QMsgExtension", "processModQContact: insert qcontact failed");
                    }
                }
                lzVar.fDz.fpW = true;
                break;
            case 1:
                d HD2 = g.bjY().HD(lzVar.fDy.fDC);
                if (HD2 != null && bh.ou(HD2.getUsername()).length() > 0) {
                    if (HD2.pnu != ((long) lzVar.fDy.fDD) || HD2.pnv != ((long) lzVar.fDy.fDE)) {
                        HD2.pnt = 1;
                        HD2.username = lzVar.fDy.fDC;
                        HD2.pnu = (long) lzVar.fDy.fDD;
                        HD2.pnv = (long) lzVar.fDy.fDE;
                        HD2.fDt = 56;
                        if (!g.bjY().a(HD2.getUsername(), HD2)) {
                            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.QMsgOperationListener", "processModQContact: update qcontact failed");
                        }
                        lzVar.fDz.fpW = true;
                        break;
                    }
                    lzVar.fDz.fpW = true;
                    break;
                }
                HD2 = new d();
                HD2.fDt = -1;
                HD2.pnt = 1;
                HD2.username = lzVar.fDy.fDC;
                HD2.pnu = (long) lzVar.fDy.fDD;
                HD2.pnv = (long) lzVar.fDy.fDE;
                if (!g.bjY().a(HD2)) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.QMsgOperationListener", "processModQContact: insert qcontact failed");
                }
                lzVar.fDz.fpW = true;
                break;
                break;
            case 2:
                g.bjZ();
                break;
        }
        return false;
    }
}
