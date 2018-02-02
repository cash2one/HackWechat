package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import android.util.Pair;
import com.tencent.mm.g.a.oa;
import com.tencent.mm.g.a.pe;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.b;
import com.tencent.mm.plugin.fts.a.i;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.jni.FTSJNIUtils;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public final class c extends b implements com.tencent.mm.plugin.messenger.foundation.a.a.c.a, com.tencent.mm.sdk.e.j.a {
    l gJk;
    private com.tencent.mm.sdk.b.c mNA = new com.tencent.mm.sdk.b.c<oa>(this) {
        final /* synthetic */ c mNG;

        {
            this.mNG = r2;
            this.xen = oa.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            oa oaVar = (oa) bVar;
            if (oaVar instanceof oa) {
                this.mNG.gJk.a(65576, new c(this.mNG, oaVar.fFW.fqm));
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c mNB = new 2(this);
    private com.tencent.mm.sdk.b.c mNC = new com.tencent.mm.sdk.b.c<pe>(this) {
        final /* synthetic */ c mNG;

        {
            this.mNG = r2;
            this.xen = pe.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            this.mNG.gJk.a(65574, new 1(this));
            return false;
        }
    };
    com.tencent.mm.sdk.b.c mND = new 4(this);
    ak mNE = new ak(g.Dm().oAt.getLooper(), new 5(this), false);
    com.tencent.mm.plugin.fts.a.a.e.a mNF = new 6(this);
    com.tencent.mm.plugin.fts.c.c mNy;
    boolean mNz = false;
    i mol;

    private class a extends com.tencent.mm.plugin.fts.a.a.a {
        private long iQc;
        private int mFailedCount;
        final /* synthetic */ c mNG;
        private HashSet<Pair<Long, Long>> mNI;
        private ArrayList<Long> mNJ;
        private int mNK;
        private int mos;
        private int mot;

        private a(c cVar) {
            this.mNG = cVar;
            this.mNI = null;
            this.mNJ = null;
            this.iQc = Long.MAX_VALUE;
            this.mNK = 0;
            this.mos = 0;
            this.mot = 0;
            this.mFailedCount = 0;
        }

        public final boolean execute() {
            long j;
            this.iQc = this.mNG.mNy.mJR.s(-200, Long.MAX_VALUE);
            x.i("MicroMsg.FTS.FTS5SearchMessageLogic", "Start building message index, last createTime: " + this.iQc);
            if (this.mNI == null) {
                this.mNI = new HashSet();
                this.mNJ = new ArrayList();
                Cursor a = this.mNG.mNy.a(com.tencent.mm.plugin.fts.a.c.mKa, true, true, false, true, true);
                while (a.moveToNext()) {
                    j = a.getLong(0);
                    long j2 = a.getLong(1);
                    long j3 = a.getLong(2);
                    if (a.getInt(3) == -1) {
                        this.mNJ.add(Long.valueOf(j));
                    } else if (j3 <= this.iQc) {
                        this.mNI.add(new Pair(Long.valueOf(j2), Long.valueOf(j3)));
                    }
                }
                a.close();
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            int i = Integer.MAX_VALUE;
            String[] strArr = new String[2];
            List<f> arrayList = new ArrayList();
            while (i >= 50) {
                strArr[0] = Long.toString(this.iQc);
                strArr[1] = Integer.toString(this.mNK);
                Cursor rawQuery = this.mNG.mol.rawQuery("SELECT msgId, talker, createTime, content, type, isSend FROM message WHERE createTime<=? AND createTime!=0 AND type in (1, 49) ORDER BY createTime DESC, msgId DESC LIMIT 50 OFFSET ?;", strArr);
                i = 0;
                while (rawQuery.moveToNext()) {
                    f fVar = new f(this.mNG, (byte) 0);
                    fVar.fqm = rawQuery.getLong(0);
                    fVar.talker = rawQuery.getString(1);
                    fVar.hVE = rawQuery.getLong(2);
                    fVar.content = rawQuery.getString(3);
                    fVar.msgType = rawQuery.getInt(4);
                    fVar.mNO = rawQuery.getInt(5);
                    fVar.mNN = 41;
                    if (c.a(fVar)) {
                        fVar.aNf();
                        if (fVar.isAvailable()) {
                            arrayList.add(fVar);
                        }
                    }
                    i++;
                }
                rawQuery.close();
                if (Thread.interrupted()) {
                    throw new InterruptedException();
                }
                int size = arrayList.size();
                if (size == 0) {
                    x.i("MicroMsg.FTS.FTS5SearchMessageLogic", "build msgRecList size %d", new Object[]{Integer.valueOf(size)});
                } else {
                    x.i("MicroMsg.FTS.FTS5SearchMessageLogic", "build msgRecList size %d FROM %d to %d", new Object[]{Integer.valueOf(size), Long.valueOf(((f) arrayList.get(0)).fqm), Long.valueOf(((f) arrayList.get(size - 1)).fqm)});
                }
                if (size > 0) {
                    this.mNG.mNy.beginTransaction();
                    for (f fVar2 : arrayList) {
                        j = fVar2.fqm;
                        long j4 = fVar2.hVE;
                        if (j4 == this.iQc) {
                            this.mNK++;
                        } else {
                            this.iQc = j4;
                            this.mNK = 0;
                        }
                        if (!this.mNI.remove(new Pair(Long.valueOf(j), Long.valueOf(j4)))) {
                            try {
                                this.mNG.mNy.a(fVar2.mNN, j, fVar2.talker, j4, fVar2.mNP, fVar2.mNQ);
                                this.mos++;
                            } catch (Throwable e) {
                                x.printErrStackTrace("MicroMsg.FTS.FTS5SearchMessageLogic", e, "Build message index failed with exception. \n%s", new Object[]{fVar2.mNP});
                                this.mFailedCount++;
                            }
                        }
                    }
                    this.mNG.mNy.commit();
                    this.mNG.mNy.t(-200, this.iQc);
                }
                arrayList.clear();
                if (Thread.interrupted()) {
                    throw new InterruptedException();
                }
            }
            int i2 = 50;
            Iterator it = this.mNI.iterator();
            while (it.hasNext()) {
                if (Thread.interrupted()) {
                    this.mNG.mNy.commit();
                    throw new InterruptedException();
                }
                int i3;
                if (i2 >= 50) {
                    this.mNG.mNy.commit();
                    this.mNG.mNy.beginTransaction();
                    i3 = 0;
                } else {
                    i3 = i2;
                }
                Pair pair = (Pair) it.next();
                this.mNG.mNy.a(com.tencent.mm.plugin.fts.a.c.mKa, ((Long) pair.first).longValue(), ((Long) pair.second).longValue());
                i2 = i3 + 1;
                this.mot++;
                it.remove();
            }
            this.mNG.mNy.commit();
            i2 = 50;
            ListIterator listIterator = this.mNJ.listIterator(this.mNJ.size());
            while (listIterator.hasPrevious()) {
                if (Thread.interrupted()) {
                    this.mNG.mNy.commit();
                    throw new InterruptedException();
                }
                if (i2 >= 50) {
                    this.mNG.mNy.commit();
                    this.mNG.mNy.beginTransaction();
                    size = 0;
                } else {
                    size = i2;
                }
                this.mNG.mNy.g(Long.valueOf(((Long) listIterator.previous()).longValue()));
                i2 = size + 1;
                this.mot++;
                listIterator.remove();
            }
            this.mNG.mNy.t(-200, this.iQc - 1);
            this.mNG.mNy.commit();
            this.mNG.mNz = false;
            return true;
        }

        public final String ado() {
            return String.format("{new: %d removed: %d failed: %d}", new Object[]{Integer.valueOf(this.mos), Integer.valueOf(this.mot), Integer.valueOf(this.mFailedCount)});
        }

        public final int getId() {
            return 4;
        }

        public final String getName() {
            return "BuildMessageIndexTask";
        }
    }

    private class c extends com.tencent.mm.plugin.fts.a.a.a {
        private long gAc;
        final /* synthetic */ c mNG;

        public c(c cVar, long j) {
            this.mNG = cVar;
            this.gAc = j;
        }

        public final boolean execute() {
            this.mNG.mNy.b(com.tencent.mm.plugin.fts.a.c.mKa, this.gAc);
            return true;
        }

        public final String ado() {
            return String.format("{MsgId: %d}", new Object[]{Long.valueOf(this.gAc)});
        }

        public final String getName() {
            return "DeleteMessageTask";
        }
    }

    static /* synthetic */ boolean a(f fVar) {
        if (bh.ov(fVar.talker) || bh.ov(fVar.content) || fVar.talker.endsWith("@app")) {
            return false;
        }
        return fVar.aNd() || fVar.aNc() || fVar.aNe();
    }

    public final com.tencent.mm.plugin.fts.a.a.a a(com.tencent.mm.plugin.fts.a.a.g gVar) {
        com.tencent.mm.plugin.fts.a.a.a iVar;
        switch (gVar.mLR) {
            case 1:
                iVar = new i(this, gVar);
                break;
            case 3:
                iVar = new h(this, gVar);
                break;
            case 10:
                iVar = new j(this, gVar);
                break;
            case 11:
                iVar = new g(this, gVar);
                break;
            default:
                iVar = new k(this, gVar);
                break;
        }
        return this.gJk.a(-65536, iVar);
    }

    protected final boolean onCreate() {
        if (((m) g.k(m.class)).isFTSContextReady()) {
            x.i("MicroMsg.FTS.FTS5SearchMessageLogic", "Create Success!");
            this.mNy = (com.tencent.mm.plugin.fts.c.c) ((m) g.k(m.class)).getFTSIndexStorage(4);
            this.gJk = ((m) g.k(m.class)).getFTSTaskDaemon();
            this.mol = ((m) g.k(m.class)).getFTSMainDB();
            this.mND.ceO();
            this.mNC.ceO();
            this.mNB.ceO();
            this.mNA.ceO();
            ((h) g.h(h.class)).aZi().c(this);
            ((h) g.h(h.class)).aZi().a(this, null);
            return true;
        }
        x.i("MicroMsg.FTS.FTS5SearchMessageLogic", "Create Fail!");
        return false;
    }

    protected final boolean AZ() {
        ((h) g.h(h.class)).aZi().j(this);
        ((h) g.h(h.class)).aZi().a(this);
        this.mND.dead();
        this.mNC.dead();
        this.mNB.dead();
        this.mNA.dead();
        this.mNy = null;
        this.gJk = null;
        return true;
    }

    public final String getName() {
        return "FTS5SearchMessageLogic";
    }

    public final void a(com.tencent.mm.plugin.messenger.foundation.a.a.c cVar, com.tencent.mm.plugin.messenger.foundation.a.a.c.c cVar2) {
        if (cVar2.ooU.equals("insert")) {
            List arrayList = new ArrayList();
            for (int i = 0; i < cVar2.ooV.size(); i++) {
                Object obj;
                au auVar = (au) cVar2.ooV.get(i);
                if (auVar == null || bh.ov(auVar.field_talker) || bh.ov(auVar.field_content)) {
                    obj = null;
                } else if (auVar.field_talker.endsWith("@app")) {
                    obj = null;
                } else if (auVar.getType() == 1 || auVar.aNc() || auVar.aNe()) {
                    int i2 = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    arrayList.add(auVar);
                }
            }
            if (arrayList.size() > 0) {
                this.gJk.a(65576, new e(this, arrayList));
            }
        }
    }

    public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
        String[] split = str.split(" ");
        if (split != null && split.length != 0) {
            if (split[0].equals("delete_id")) {
                this.gJk.a(65576, new c(this, bh.getLong(split[1], 0)));
            } else if (split[0].equals("delete_talker")) {
                this.gJk.a(65576, new d(this, split[1]));
            } else if (split[0].equals("delete_all") && split[1].equals("message")) {
                this.gJk.a(65576, new b(this, (byte) 0));
            }
        }
    }

    public static List<String> Bl(String str) {
        if (str.length() > 16) {
            str = str.substring(0, 16);
        }
        List<String> arrayList = new ArrayList();
        String[] split = FTSJNIUtils.icuTokenizer(str).split(" ");
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (i < split.length) {
            try {
                int intValue = Integer.valueOf(split[i]).intValue();
                int intValue2 = Integer.valueOf(split[i + 1]).intValue();
                int i2 = intValue2 - intValue;
                int intValue3 = Integer.valueOf(split[i + 2]).intValue();
                String substring = str.substring(intValue, intValue2);
                if (intValue3 < 400 || intValue3 >= 500) {
                    if (stringBuffer.length() > 0) {
                        arrayList.add(stringBuffer.toString());
                        stringBuffer = new StringBuffer();
                    }
                    if (!(substring.equals("*") || substring.equals(" "))) {
                        arrayList.add(substring);
                    }
                    i += 3;
                } else {
                    if (i2 == 1) {
                        stringBuffer.append(substring);
                    } else {
                        if (stringBuffer.length() > 0) {
                            arrayList.add(stringBuffer.toString());
                            stringBuffer = new StringBuffer();
                        }
                        arrayList.add(substring);
                    }
                    i += 3;
                }
            } catch (Exception e) {
            }
        }
        if (stringBuffer.length() > 0) {
            arrayList.add(stringBuffer.toString());
        }
        x.i("MicroMsg.FTS.FTS5SearchMessageLogic", "mmICUTokenize Query-tokenList: %s indexes: %s", new Object[]{arrayList, r5});
        return arrayList;
    }
}
