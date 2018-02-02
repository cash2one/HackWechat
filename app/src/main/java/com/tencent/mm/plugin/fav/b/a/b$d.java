package com.tencent.mm.plugin.fav.b.a;

import android.database.Cursor;
import com.tencent.mm.plugin.fav.b.a.b.c;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.sdk.platformtools.x;

class b$d extends a {
    final /* synthetic */ b mop;
    private long mou;
    private int mow;

    private b$d(b bVar, long j) {
        this.mop = bVar;
        this.mou = j;
    }

    public final boolean execute() {
        if (this.mop.mon == null) {
            x.e("MicroMsg.FTS.FTS5SearchFavoriteLogic", "InsertFavItemTask: fav db is null");
        } else {
            x.d("MicroMsg.FTS.FTS5SearchFavoriteLogic", "start to insert favorite item");
            Cursor a = this.mop.mon.a("SELECT localId, type, updateTime, fromUser, favProto, tagProto FROM FavItemInfo WHERE localId = ? AND flag <> -1;", new String[]{String.valueOf(this.mou)}, 2);
            try {
                if (a.moveToFirst()) {
                    c cVar = new c(this.mop, (byte) 0);
                    cVar.b(a);
                    a.close();
                    a = null;
                    this.mop.mom.beginTransaction();
                    this.mop.mom.b(com.tencent.mm.plugin.fts.a.c.mKb, this.mou);
                    this.mow = b.a(this.mop, cVar);
                    this.mop.mom.commit();
                }
                if (a != null) {
                    a.close();
                }
            } catch (Exception e) {
                throw e;
            } catch (Throwable th) {
                if (a != null) {
                    a.close();
                }
            }
        }
        return true;
    }

    public final String ado() {
        return String.format("{favItemId: %d transactionCount: %d}", new Object[]{Long.valueOf(this.mou), Integer.valueOf(this.mow)});
    }

    public final String getName() {
        return "InsertFavItemTask";
    }
}
