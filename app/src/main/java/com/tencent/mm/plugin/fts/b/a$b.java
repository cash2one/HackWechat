package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.g.b.af;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.jni.FTSJNIUtils;
import com.tencent.mm.storage.x;
import com.tencent.mm.z.s;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

class a$b extends a {
    final /* synthetic */ a mMS;
    private HashSet<String> mMU;
    private HashMap<String, x> mMV;
    private long mMW;
    private long mMX;
    private int mMY;
    private int mMZ;
    private int mNa;
    private int mNb;
    private int mNc;
    private int mNd;
    private int mNe;

    private a$b(a aVar) {
        this.mMS = aVar;
        this.mMV = new HashMap();
        this.mMW = -1;
        this.mMX = -1;
        this.mMY = 0;
        this.mMZ = 0;
        this.mNa = 0;
        this.mNb = 0;
    }

    public final boolean execute() {
        int i;
        long j;
        List list;
        int i2;
        Throwable e;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.FTS.FTS5SearchContactLogic", "Start building contact index.");
        Bg("start");
        if (this.mMU == null) {
            this.mMU = new HashSet();
            Cursor a = a.a(this.mMS).a(c.mKi, true, false, true, false, true);
            while (a.moveToNext()) {
                String string = a.getString(1);
                i = a.getInt(2);
                j = a.getLong(0);
                if (i == 1) {
                    list = (List) a.b(this.mMS).get(string);
                    if (list == null) {
                        list = new ArrayList(16);
                        a.b(this.mMS).put(string, list);
                    }
                    list.add(Long.valueOf(j));
                } else {
                    this.mMU.add(string);
                    if (i == 2) {
                        a.c(this.mMS).add(string);
                    }
                }
            }
            a.close();
            this.mNc = a.b(this.mMS).size();
            this.mNd = a.c(this.mMS).size();
            this.mNe = this.mMU.size();
            if (this.mNe < 5) {
                this.mLl |= 1;
            }
        }
        Bg("getBuildContact");
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        if (a.b(this.mMS).size() > 0) {
            List arrayList = new ArrayList();
            for (List list2 : a.b(this.mMS).values()) {
                arrayList.addAll(list2);
            }
            a.b(this.mMS).clear();
            a.a(this.mMS).aR(arrayList);
        }
        Bg("deleteDirtyContact");
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        if (a.c(this.mMS).size() > 0) {
            Iterator it = a.c(this.mMS).iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                a.a(this.mMS).B(str, a.d(this.mMS).AY(str));
            }
            a.c(this.mMS).clear();
        }
        Bg("updateTimestampContact");
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Cursor h = a.d(this.mMS).h("SELECT ROWID, username, alias, conRemark, nickname, verifyFlag, type, lvbuff, contactLabelIds FROM rcontact WHERE ROWID > ? AND deleteFlag=0 ORDER BY ROWID;", new String[]{Long.toString(this.mMW)});
        i = 50;
        while (h.moveToNext()) {
            if (Thread.interrupted()) {
                h.close();
                a.a(this.mMS).commit();
                throw new InterruptedException();
            }
            j = h.getLong(0);
            this.mMW = j;
            af xVar = new x();
            xVar.gJd = j;
            xVar.setUsername(h.getString(1));
            xVar.cZ(h.getString(2));
            xVar.da(h.getString(3));
            xVar.dc(h.getString(4));
            xVar.ez(h.getInt(5));
            xVar.setType(h.getInt(6));
            xVar.z(h.getBlob(7));
            xVar.dj(h.getString(8));
            xVar.eB(0);
            this.mMV.put(xVar.field_username, xVar);
            if (!(s.eV(xVar.field_username) || !this.mMS.D(xVar) || this.mMU.remove(xVar.field_username))) {
                if (i >= 50) {
                    a.a(this.mMS).commit();
                    a.a(this.mMS).beginTransaction();
                    i2 = 0;
                } else {
                    i2 = i;
                }
                try {
                    if (!xVar.field_username.endsWith("@chatroom") && (xVar.field_verifyFlag & x.cic()) == 0) {
                        this.mMS.B(xVar);
                        xVar.cif();
                    }
                    i = this.mMS.F(xVar) + i2;
                    try {
                        this.mMZ++;
                    } catch (Exception e2) {
                        e = e2;
                        com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", e, "Build contact index failed with exception.\n", new Object[0]);
                        this.mNb++;
                    }
                } catch (Throwable e3) {
                    Throwable e32;
                    Throwable th = e32;
                    i = i2;
                    e = th;
                    com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", e, "Build contact index failed with exception.\n", new Object[0]);
                    this.mNb++;
                }
            }
        }
        h.close();
        a.a(this.mMS).commit();
        Bg("buildWXContact");
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Cursor h2 = a.d(this.mMS).h("SELECT rowid, chatroomname, memberlist, roomdata FROM chatroom WHERE ROWID > ? ORDER BY ROWID;", new String[]{Long.toString(this.mMX)});
        i = 50;
        while (h2.moveToNext()) {
            if (Thread.interrupted()) {
                h2.close();
                a.a(this.mMS).commit();
                throw new InterruptedException();
            }
            this.mMX = h2.getLong(0);
            String string2 = h2.getString(1);
            if (!this.mMU.remove(string2)) {
                CharSequence string3 = h2.getString(2);
                byte[] blob = h2.getBlob(3);
                try {
                    String[] split = c.a.mKw.split(string3);
                    Arrays.sort(split, new Comparator<String>(this) {
                        final /* synthetic */ a$b mNf;

                        {
                            this.mNf = r1;
                        }

                        public final /* synthetic */ int compare(Object obj, Object obj2) {
                            return FTSJNIUtils.stringCompareUtfBinary((String) obj, (String) obj2);
                        }
                    });
                    i2 = this.mMS.i(string2, split) + i;
                    try {
                        i2 += this.mMS.a(string2, (x) this.mMV.get(string2), split, blob, this.mMV);
                        this.mMY++;
                        i = i2;
                    } catch (Exception e4) {
                        e32 = e4;
                        com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", e32, "Build contact index failed with exception.\n", new Object[0]);
                        this.mNb++;
                        i = i2;
                        if (i < 50) {
                            a.a(this.mMS).commit();
                            a.a(this.mMS).beginTransaction();
                            i = 0;
                        }
                    }
                } catch (Throwable e5) {
                    th = e5;
                    i2 = i;
                    e32 = th;
                    com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", e32, "Build contact index failed with exception.\n", new Object[0]);
                    this.mNb++;
                    i = i2;
                    if (i < 50) {
                        a.a(this.mMS).commit();
                        a.a(this.mMS).beginTransaction();
                        i = 0;
                    }
                }
                if (i < 50) {
                    a.a(this.mMS).commit();
                    a.a(this.mMS).beginTransaction();
                    i = 0;
                }
            }
        }
        h2.close();
        a.a(this.mMS).commit();
        Bg("buildChatroomContact");
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        this.mNa = this.mMU.size();
        Iterator it2 = this.mMU.iterator();
        while (it2.hasNext()) {
            str = (String) it2.next();
            a.a(this.mMS).a(c.mKi, str);
            ((PluginFTS) g.k(PluginFTS.class)).getTopHitsLogic().c(c.mKi, str);
        }
        this.mMU.clear();
        this.mMV.clear();
        Bg("deleteUnusedContact");
        ((PluginFTS) g.k(PluginFTS.class)).setFTSIndexReady(true);
        return true;
    }

    public final String ado() {
        return String.format("{build: %d newContact: %d, newChatroom: %d, remove: %d, dirty: %d, timestamp: %d, fail: %d}", new Object[]{Integer.valueOf(this.mNe), Integer.valueOf(this.mMZ), Integer.valueOf(this.mMY), Integer.valueOf(this.mNa), Integer.valueOf(this.mNc), Integer.valueOf(this.mNd), Integer.valueOf(this.mNb)});
    }

    public final String getName() {
        return "BuildContactIndexTask";
    }

    public final int getId() {
        return 1;
    }
}
