package com.tencent.mm.plugin.fav.b.a;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Iterator;

class b$a extends a {
    private int mFailedCount;
    final /* synthetic */ b mop;
    private HashSet<Long> moq;
    private int mor;
    private int mos;
    private int mot;

    private b$a(b bVar) {
        this.mop = bVar;
        this.moq = null;
        this.mor = 0;
        this.mos = 0;
        this.mot = 0;
        this.mFailedCount = 0;
    }

    public final boolean execute() {
        Exception e;
        Throwable th;
        if (this.mop.mon == null) {
            x.w("MicroMsg.FTS.FTS5SearchFavoriteLogic", "favorite db is null, you need to wait the favorite db event!");
        } else {
            x.i("MicroMsg.FTS.FTS5SearchFavoriteLogic", "start to build favorite index!");
            if (this.moq == null) {
                this.moq = new HashSet();
                Cursor a;
                try {
                    a = this.mop.mom.a(c.mKb, false, true, false, false, false);
                    while (a.moveToNext()) {
                        try {
                            this.moq.add(Long.valueOf(a.getLong(0)));
                        } catch (Exception e2) {
                            e = e2;
                        }
                    }
                    if (a != null) {
                        a.close();
                    }
                    this.mor = this.moq.size();
                } catch (Exception e3) {
                    e = e3;
                    a = null;
                    try {
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    a = null;
                    if (a != null) {
                        a.close();
                    }
                    throw th;
                }
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            int i;
            Cursor rawQuery = this.mop.mon.rawQuery("SELECT localId, type, updateTime, fromUser, favProto, tagProto FROM FavItemInfo WHERE flag <> -1;", null);
            int i2 = 50;
            while (rawQuery.moveToNext()) {
                if (Thread.interrupted()) {
                    this.mop.mom.commit();
                    throw new InterruptedException();
                }
                b.c cVar = new b.c(this.mop, (byte) 0);
                cVar.b(rawQuery);
                if (!this.moq.remove(Long.valueOf(cVar.hzP))) {
                    if (i2 >= 50) {
                        this.mop.mom.commit();
                        this.mop.mom.beginTransaction();
                        i = 0;
                    } else {
                        i = i2;
                    }
                    try {
                        i += b.a(this.mop, cVar);
                        this.mos++;
                        i2 = i;
                    } catch (Throwable th4) {
                        try {
                            x.printErrStackTrace("MicroMsg.FTS.FTS5SearchFavoriteLogic", th4, "Build favorite index failed with exception.\n", new Object[0]);
                            this.mFailedCount++;
                            i2 = i;
                        } catch (Exception e4) {
                            throw e4;
                        } catch (Throwable th5) {
                            if (rawQuery != null) {
                                rawQuery.close();
                            }
                        }
                    }
                }
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            this.mop.mom.commit();
            Iterator it = this.moq.iterator();
            while (it.hasNext()) {
                if (Thread.interrupted()) {
                    this.mop.mom.commit();
                    throw new InterruptedException();
                }
                if (i2 >= 50) {
                    this.mop.mom.commit();
                    this.mop.mom.beginTransaction();
                    i = 0;
                } else {
                    i = i2;
                }
                this.mop.mom.b(c.mKb, ((Long) it.next()).longValue());
                i2 = i + 1;
                this.mot++;
                it.remove();
            }
            this.mop.mom.commit();
        }
        return true;
    }

    public final String ado() {
        return String.format("{new: %d exist: %d removed: %d failed: %d}", new Object[]{Integer.valueOf(this.mos), Integer.valueOf(this.mor), Integer.valueOf(this.mot), Integer.valueOf(this.mFailedCount)});
    }

    public final String getName() {
        return "BuildFavoriteIndexTask";
    }

    public final int getId() {
        return 6;
    }
}
