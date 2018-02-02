package com.tencent.mm.plugin.appbrand.f;

import com.tencent.mm.plugin.appbrand.appusage.i;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class b$d extends a {
    final /* synthetic */ b iVS;
    private int iVT;

    b$d(b bVar) {
        this.iVS = bVar;
    }

    public final boolean execute() {
        List<i> adt = i.adt();
        if (adt.isEmpty()) {
            x.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "WeApp recent usage list is nil.");
            return true;
        }
        this.iVT = adt.size();
        this.iVS.iVQ.beginTransaction();
        this.iVS.iVQ.h(c.mKe);
        for (i iVar : adt) {
            String ou = bh.ou(iVar.gHg);
            int hashCode = ou.hashCode();
            long currentTimeMillis = System.currentTimeMillis();
            this.iVS.iVQ.a(393216, 1, (long) hashCode, ou, currentTimeMillis, iVar.appName);
            this.iVS.iVQ.a(393216, 2, (long) hashCode, ou, currentTimeMillis, d.am(iVar.appName, false));
            this.iVS.iVQ.a(393216, 3, (long) hashCode, ou, currentTimeMillis, d.am(iVar.appName, true));
        }
        this.iVS.iVQ.commit();
        return true;
    }

    public final String ado() {
        return String.format("{updateSize: %d}", new Object[]{Integer.valueOf(this.iVT)});
    }

    public final String getName() {
        return "UpdateWeAppIndexTask";
    }
}
