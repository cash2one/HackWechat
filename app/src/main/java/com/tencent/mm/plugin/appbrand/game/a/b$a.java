package com.tencent.mm.plugin.appbrand.game.a;

import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class b$a extends a {
    final /* synthetic */ b iXQ;
    private int iXR;
    private List<String> idList;

    public b$a(b bVar, List list) {
        this.iXQ = bVar;
        this.idList = list;
    }

    public final boolean execute() {
        if (bh.cA(this.idList)) {
            return false;
        }
        this.iXR = this.idList.size();
        x.v("MicroMsg.FTS.FTS5SearchMiniGameLogic", "delete MiniGame info id listSize:%d", new Object[]{Integer.valueOf(this.iXR)});
        for (String a : this.idList) {
            this.iXQ.iXO.a(c.mKf, a);
        }
        return true;
    }

    public final String getName() {
        return "DeleteMiniGameTask";
    }

    public final String ado() {
        return String.format("{deleteSize: %d}", new Object[]{Integer.valueOf(this.iXR)});
    }
}
