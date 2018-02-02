package com.tencent.mm.plugin.appbrand.f;

import com.tencent.mm.plugin.appbrand.appusage.i;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class b$b extends a {
    final /* synthetic */ b iVS;
    private String id;
    private String name;

    public b$b(b bVar, String str) {
        this.iVS = bVar;
        this.id = str;
    }

    public final boolean execute() {
        this.iVS.iVQ.beginTransaction();
        this.iVS.iVQ.a(c.mKe, this.id);
        i rD = i.rD(this.id);
        if (rD != null) {
            long currentTimeMillis = System.currentTimeMillis();
            String ou = bh.ou(rD.gHg);
            int hashCode = ou.hashCode();
            this.iVS.iVQ.a(393216, 1, (long) hashCode, ou, currentTimeMillis, rD.appName);
            this.iVS.iVQ.a(393216, 2, (long) hashCode, ou, currentTimeMillis, d.am(rD.appName, false));
            this.iVS.iVQ.a(393216, 3, (long) hashCode, ou, currentTimeMillis, d.am(rD.appName, true));
            this.name = rD.appName;
            x.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "inserted we app info id = %s", ou);
        }
        this.iVS.iVQ.commit();
        return true;
    }

    public final String getName() {
        return "InsertWeAppTask";
    }

    public final String ado() {
        return String.format("{name: %s id: %s}", new Object[]{this.name, this.id});
    }
}
