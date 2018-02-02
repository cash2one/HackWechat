package com.tencent.mm.plugin.appbrand.game.a;

import com.tencent.mm.plugin.appbrand.game.a.a.b;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class b$d extends a {
    private int iVT;
    final /* synthetic */ b iXQ;

    b$d(b bVar) {
        this.iXQ = bVar;
    }

    public final boolean execute() {
        List<b> aea = i.aea();
        if (aea == null || aea.isEmpty()) {
            x.i("MicroMsg.FTS.FTS5SearchMiniGameLogic", "MiniGame search list is nil.");
            return true;
        }
        this.iVT = aea.size();
        this.iXQ.iXO.beginTransaction();
        this.iXQ.iXO.h(c.mKf);
        for (b bVar : aea) {
            if (bVar == null || bh.ov(bVar.field_AppName)) {
                x.i("MicroMsg.FTS.FTS5SearchMiniGameLogic", "UpdateMiniGameIndexTask appname is null");
                this.iVT--;
            } else {
                String ou = bh.ou(bVar.field_RecordId);
                int hashCode = ou.hashCode();
                long currentTimeMillis = System.currentTimeMillis();
                this.iXQ.iXO.a(458752, 1, (long) hashCode, ou, currentTimeMillis, bVar.field_AppName);
                this.iXQ.iXO.a(458752, 2, (long) hashCode, ou, currentTimeMillis, d.am(bVar.field_AppName, false));
                this.iXQ.iXO.a(458752, 3, (long) hashCode, ou, currentTimeMillis, d.am(bVar.field_AppName, true));
            }
        }
        this.iXQ.iXO.commit();
        x.i("MicroMsg.FTS.FTS5SearchMiniGameLogic", "update MiniGame info id listSize:%d", new Object[]{Integer.valueOf(this.iVT)});
        return true;
    }

    public final String ado() {
        return String.format("{updateSize: %d}", new Object[]{Integer.valueOf(this.iVT)});
    }

    public final String getName() {
        return "UpdateMiniGameIndexTask";
    }
}
