package com.tencent.mm.plugin.appbrand.game.a;

import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class b extends com.tencent.mm.plugin.fts.a.b {
    l gJk;
    a iXO;
    private a iXP = new 1(this);

    class b extends com.tencent.mm.plugin.fts.a.a.a {
        final /* synthetic */ b iXQ;
        private int iXS;
        private List<String> idList;

        public b(b bVar, List list) {
            this.iXQ = bVar;
            this.idList = list;
        }

        public final boolean execute() {
            if (bh.cA(this.idList)) {
                return false;
            }
            this.iXS = this.idList.size();
            x.i("MicroMsg.FTS.FTS5SearchMiniGameLogic", "inserted MiniGame info id listSize:%d", new Object[]{Integer.valueOf(this.iXS)});
            this.iXQ.iXO.beginTransaction();
            for (String str : this.idList) {
                this.iXQ.iXO.a(c.mKf, str);
                com.tencent.mm.plugin.appbrand.game.a.a.b rH = i.rH(str);
                if (rH == null || bh.ov(rH.field_AppName)) {
                    x.i("MicroMsg.FTS.FTS5SearchMiniGameLogic", "inserted miniGame info is null. id:%s", new Object[]{str});
                } else {
                    long currentTimeMillis = System.currentTimeMillis();
                    String ou = bh.ou(rH.field_RecordId);
                    int hashCode = ou.hashCode();
                    this.iXQ.iXO.a(458752, 1, (long) hashCode, ou, currentTimeMillis, rH.field_AppName);
                    this.iXQ.iXO.a(458752, 2, (long) hashCode, ou, currentTimeMillis, d.am(rH.field_AppName, false));
                    this.iXQ.iXO.a(458752, 3, (long) hashCode, ou, currentTimeMillis, d.am(rH.field_AppName, true));
                    x.v("MicroMsg.FTS.FTS5SearchMiniGameLogic", "inserted MiniGame info id = %s, name = %s", new Object[]{ou, rH.field_AppName});
                }
            }
            this.iXQ.iXO.commit();
            return true;
        }

        public final String getName() {
            return "InsertMiniGameTask";
        }

        public final String ado() {
            return String.format("{insertSize: %d}", new Object[]{Integer.valueOf(this.iXS)});
        }
    }

    public final com.tencent.mm.plugin.fts.a.a.a a(g gVar) {
        return this.gJk.a(-65536, new c(this, gVar));
    }

    protected final boolean onCreate() {
        if (((m) com.tencent.mm.kernel.g.k(m.class)).isFTSContextReady()) {
            x.i("MicroMsg.FTS.FTS5SearchMiniGameLogic", "Create Success!");
            this.iXO = (a) ((m) com.tencent.mm.kernel.g.k(m.class)).getFTSIndexStorage(8);
            this.gJk = ((m) com.tencent.mm.kernel.g.k(m.class)).getFTSTaskDaemon();
            this.gJk.a(65601, new d(this));
            i.onCreate();
            i.d(this.iXP);
            return true;
        }
        x.i("MicroMsg.FTS.FTS5SearchMiniGameLogic", "Create Fail!");
        return false;
    }

    protected final boolean AZ() {
        i.onDestroy();
        i.e(this.iXP);
        this.iXO = null;
        this.gJk = null;
        return true;
    }

    public final String getName() {
        return "FTS5SearchMiniGameLogic";
    }
}
