package com.tencent.mm.plugin.location.model;

import com.tencent.mm.g.a.ep;
import com.tencent.mm.g.a.ri;
import com.tencent.mm.pluginsdk.q.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;

class l$2 extends c<ep> {
    final /* synthetic */ l nRF;

    l$2(l lVar) {
        this.nRF = lVar;
        this.xen = ep.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ep epVar = (ep) bVar;
        x.i("MicroMsg.SubCoreLocation", "exit track trackMgr:%s event:%s", new Object[]{a.vcv.aVB(), epVar.ftg.username});
        l.aVu().stop();
        if (!bh.ov(a.vcw.aVL())) {
            l.aVu().rM(1);
            b riVar = new ri();
            riVar.fJc.fJf = true;
            com.tencent.mm.sdk.b.a.xef.m(riVar);
        }
        if (!bh.ov(epVar.ftg.username)) {
            com.tencent.mm.plugin.location.a.a DB = l.aVv().DB(epVar.ftg.username);
            if (DB != null) {
                DB.fAX.remove(q.FS());
                l.aVv().a(epVar.ftg.username, DB.fAX, DB.latitude, DB.longitude, DB.nQt, null, null);
                if (a.vcp != null) {
                    a.vcp.a(epVar.ftg.username, null, null, null, 1);
                }
            }
        }
        return false;
    }
}
