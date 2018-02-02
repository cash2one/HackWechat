package com.tencent.mm.plugin.fav.b.a;

import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.sdk.platformtools.x;

class b$b extends a {
    final /* synthetic */ b mop;
    private long mou;

    public b$b(b bVar, long j) {
        this.mop = bVar;
        this.mou = j;
    }

    public final boolean execute() {
        x.d("MicroMsg.FTS.FTS5SearchFavoriteLogic", "start to delete favorite item");
        this.mop.mom.b(c.mKb, this.mou);
        return true;
    }

    public final String ado() {
        return String.format("{favItemId: %d}", new Object[]{Long.valueOf(this.mou)});
    }

    public final String getName() {
        return "DeleteFavItemTask";
    }
}
