package com.tencent.mm.q;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

class b$b extends a {
    final /* synthetic */ b gJn;
    public boolean gJt;
    private HashSet<Long> gJu;
    private long gJv;
    private int gJw;
    private HashMap<int[], b$e> gJx;

    private b$b(b bVar) {
        this.gJn = bVar;
        this.gJt = false;
        this.gJu = null;
        this.gJv = Long.MIN_VALUE;
        this.gJw = -1;
        this.gJx = new HashMap();
    }

    public final boolean execute() {
        x.i("MicroMsg.FTS.FTS5SearchFriendLogic", "Start building friend index.");
        this.gJt = b.Ba();
        if (this.gJw < 0) {
            this.gJw = 0;
        }
        x.d("MicroMsg.FTS.FTS5SearchFriendLogic", "[BuildFriendIndexTask mBuildMobileIndex : %s, mCurrentTask : %d]", new Object[]{Boolean.valueOf(this.gJt), Integer.valueOf(this.gJw)});
        if (this.gJw == 0) {
            if (this.gJt) {
                if (!this.gJx.containsKey(c.mKk)) {
                    this.gJx.put(c.mKk, new b$e());
                }
                if (this.gJu == null) {
                    this.gJu = new HashSet();
                    Cursor a = this.gJn.gJl.a(c.mKk, false, true, false, false, false);
                    while (a.moveToNext()) {
                        this.gJu.add(Long.valueOf(a.getLong(0)));
                    }
                    a.close();
                }
                if (Thread.interrupted()) {
                    throw new InterruptedException();
                }
                int i;
                b$e com_tencent_mm_q_b_e;
                Cursor h = ((m) g.k(m.class)).getFTSMainDB().h("SELECT id, realname, realnamequanpin, realnamepyinitial, nickname, nicknamequanpin, nicknamepyinitial, username, status, moblie FROM addr_upload2 WHERE id > ? AND type=0 ORDER BY id;", new String[]{Long.toString(this.gJv)});
                int i2 = 50;
                while (h.moveToNext()) {
                    if (Thread.interrupted()) {
                        h.close();
                        this.gJn.gJl.commit();
                        throw new InterruptedException();
                    }
                    long j = h.getLong(0);
                    this.gJv = j;
                    b$a com_tencent_mm_q_b_a = new b$a();
                    com_tencent_mm_q_b_a.id = j;
                    com_tencent_mm_q_b_a.gJo = h.getString(1);
                    com_tencent_mm_q_b_a.gJp = h.getString(2);
                    com_tencent_mm_q_b_a.gJq = h.getString(3);
                    com_tencent_mm_q_b_a.bgo = h.getString(4);
                    com_tencent_mm_q_b_a.gJr = h.getString(5);
                    com_tencent_mm_q_b_a.gJs = h.getString(6);
                    com_tencent_mm_q_b_a.userName = h.getString(7);
                    com_tencent_mm_q_b_a.status = h.getInt(8);
                    com_tencent_mm_q_b_a.fAf = h.getString(9);
                    com_tencent_mm_q_b_a.type = 0;
                    if (com_tencent_mm_q_b_a.status == 65536) {
                        com_tencent_mm_q_b_a.status = 0;
                    }
                    if (b.a(com_tencent_mm_q_b_a) && !this.gJu.remove(Long.valueOf(com_tencent_mm_q_b_a.id))) {
                        if (i2 >= 50) {
                            this.gJn.gJl.commit();
                            this.gJn.gJl.beginTransaction();
                            i = 0;
                        } else {
                            i = i2;
                        }
                        try {
                            i += b.a(this.gJn, com_tencent_mm_q_b_a);
                            com_tencent_mm_q_b_e = (b$e) this.gJx.get(c.mKk);
                            com_tencent_mm_q_b_e.gJA++;
                            i2 = i;
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.FTS.FTS5SearchFriendLogic", e, "Build mobile friend index failed with exception.", new Object[0]);
                            com_tencent_mm_q_b_e = (b$e) this.gJx.get(c.mKk);
                            com_tencent_mm_q_b_e.mFailedCount++;
                            i2 = i;
                        }
                    }
                }
                h.close();
                this.gJn.gJl.commit();
                Iterator it = this.gJu.iterator();
                i2 = 50;
                while (it.hasNext()) {
                    if (i2 >= 50) {
                        this.gJn.gJl.commit();
                        this.gJn.gJl.beginTransaction();
                        i = 0;
                    } else {
                        i = i2;
                    }
                    this.gJn.gJl.b(c.mKk, ((Long) it.next()).longValue());
                    i++;
                    com_tencent_mm_q_b_e = (b$e) this.gJx.get(c.mKk);
                    com_tencent_mm_q_b_e.gJB++;
                    it.remove();
                    i2 = i;
                }
                this.gJn.gJl.commit();
                this.gJu = null;
                this.gJv = Long.MIN_VALUE;
            }
            this.gJw = -1;
        }
        return true;
    }

    public final String toString() {
        return this.gJx.containsKey(c.mKk) ? "BuildFriendIndex IDXTYPE_SET_CONTACT_FRIEND [new: " + ((b$e) this.gJx.get(c.mKk)).gJA + ", removed: " + ((b$e) this.gJx.get(c.mKk)).gJB + ", failed: " + ((b$e) this.gJx.get(c.mKk)).mFailedCount + "]" : "";
    }

    public final int getId() {
        return 2;
    }

    public final String getName() {
        return "BuildFriendIndexTask";
    }
}
