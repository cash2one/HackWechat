package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.g.b.af;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.b;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.i;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.s;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import junit.framework.AssertionFailedError;
import org.xwalk.core.R$styleable;

public final class a extends b {
    private static Set<String> mMR = new HashSet();
    private l gJk;
    private com.tencent.mm.plugin.fts.c.a mMD;
    private HashSet<String> mME;
    private HashMap<String, List<Long>> mMF;
    private HashMap<String, String[]> mMG;
    private HashMap<String, List<Long>> mMH;
    private Method mMI;
    private com.tencent.mm.sdk.e.m.b mMJ = new 1(this);
    private com.tencent.mm.sdk.e.m.b mMK = new 2(this);
    private com.tencent.mm.sdk.e.j.a mML = new 3(this);
    private com.tencent.mm.sdk.e.j.a mMM = new 4(this);
    private c mMN = new 5(this);
    private c mMO = new 6(this);
    private ak mMP = new ak(g.Dm().oAt.getLooper(), new 7(this), true);
    private ak mMQ = new ak(g.Dm().oAt.getLooper(), new 8(this), false);
    private i mol;

    private class m extends f {
        final /* synthetic */ a mMS;

        public m(a aVar, com.tencent.mm.plugin.fts.a.a.g gVar) {
            this.mMS = aVar;
            super(gVar);
        }

        protected final void a(com.tencent.mm.plugin.fts.a.a.h hVar) {
            super.a(hVar);
            com.tencent.mm.plugin.fts.a.a a = this.mMS.mMD;
            String str = this.mLN.mLS;
            String u = d.u(hVar.mMb.mLC);
            Cursor rawQuery = a.mJR.rawQuery(String.format("SELECT aux_index FROM %s NOT INDEXED JOIN (SELECT docid, aux_index, timestamp FROM %s NOT INDEXED JOIN FTS5ChatRoomMembers ON (aux_index = chatroom) WHERE member=?) as temp ON (%s.rowid = temp.docid) WHERE %s MATCH '%s' ORDER BY -timestamp;", new Object[]{a.aMS(), a.aMR(), a.aMS(), a.aMS(), u}), new String[]{str, u});
            HashSet hashSet = new HashSet();
            hVar.mMc = new ArrayList();
            while (rawQuery.moveToNext()) {
                j jVar = new j();
                jVar.mLs = rawQuery.getString(0);
                if (hashSet.add(jVar.mLs)) {
                    hVar.mMc.add(jVar);
                }
            }
            rawQuery.close();
            hVar.bjW = 0;
        }

        public final String getName() {
            return "SearchChatroomInMemberTask";
        }
    }

    private class n extends f {
        final /* synthetic */ a mMS;

        public n(a aVar, com.tencent.mm.plugin.fts.a.a.g gVar) {
            this.mMS = aVar;
            super(gVar);
        }

        protected final void a(com.tencent.mm.plugin.fts.a.a.h hVar) {
            j jVar;
            hVar.mMb = e.an(this.mLN.fDj, true);
            Cursor a = this.mMS.mMD.a(hVar.mMb, new int[]{131075}, null, true, true);
            HashMap hashMap = new HashMap();
            while (a.moveToNext()) {
                k h = new k().h(a);
                if (!this.mLN.mLX.contains(h.mLs)) {
                    jVar = (j) hashMap.get(h.mLs);
                    if (jVar == null || d.c(com.tencent.mm.plugin.fts.a.c.mKt, h.mLr, jVar.mLr) < 0) {
                        hashMap.put(h.mLs, h);
                    }
                    if (Thread.interrupted()) {
                        a.close();
                        throw new InterruptedException();
                    }
                }
            }
            a.close();
            ArrayList arrayList = new ArrayList(hashMap.size());
            for (k kVar : hashMap.values()) {
                kVar.aMY();
                kVar.a(hVar.mMb);
                arrayList.add(kVar);
                if (Thread.interrupted()) {
                    throw new InterruptedException();
                }
            }
            if (this.mLN.mLY != null) {
                Collections.sort(arrayList, this.mLN.mLY);
            }
            hVar.mMc = new ArrayList(hashMap.size());
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < arrayList.size(); i++) {
                jVar = (j) arrayList.get(i);
                stringBuffer.append(jVar.mLx);
                stringBuffer.append("|");
                stringBuffer.append(jVar.timestamp);
                stringBuffer.append(" ");
                hVar.mMc.add(jVar);
                if (i >= this.mLN.mLW) {
                    break;
                }
            }
            if (hVar.mMb.mLE.size() > 1 && this.mMS.mMD.b(hVar.mMb)) {
                jVar = new j();
                jVar.mLs = "create_chatroom​";
                hVar.mMc.add(0, jVar);
                stringBuffer.append(" needCreateChatroom");
            }
            x.i("MicroMsg.FTS.FTS5SearchContactLogic", "rank score: %s", new Object[]{stringBuffer.toString()});
        }

        public final String getName() {
            return "SearchChatroomTask";
        }

        public final int getId() {
            return 19;
        }
    }

    public class o extends f {
        final /* synthetic */ a mMS;

        public o(a aVar, com.tencent.mm.plugin.fts.a.a.g gVar) {
            this.mMS = aVar;
            super(gVar);
        }

        protected final void a(com.tencent.mm.plugin.fts.a.a.h hVar) {
            List F = bh.F(this.mLN.fDj.split(","));
            com.tencent.mm.plugin.fts.a.a a = this.mMS.mMD;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("member IN (");
            for (int i = 0; i < F.size(); i++) {
                stringBuffer.append("'");
                stringBuffer.append((String) F.get(i));
                stringBuffer.append("'");
                if (i != F.size() - 1) {
                    stringBuffer.append(",");
                }
            }
            stringBuffer.append(")");
            Cursor rawQuery = a.mJR.rawQuery(String.format("SELECT member, chatroom, entity_id FROM FTS5ChatRoomMembers, %s WHERE %s AND chatroom = aux_index", new Object[]{a.aMR(), stringBuffer.toString()}), null);
            HashMap hashMap = new HashMap();
            while (rawQuery.moveToNext()) {
                List list;
                String string = rawQuery.getString(0);
                if (hashMap.containsKey(string)) {
                    list = (List) hashMap.get(string);
                } else {
                    list = new ArrayList();
                }
                j jVar = new j();
                jVar.mLs = rawQuery.getString(1);
                jVar.mMf = rawQuery.getLong(2);
                list.add(jVar);
                hashMap.put(string, list);
            }
            rawQuery.close();
            hVar.mMc = new ArrayList();
            j jVar2 = new j();
            jVar2.userData = hashMap;
            hVar.mMc.add(jVar2);
        }

        public final String getName() {
            return "SearchCommonChatroomTask";
        }
    }

    private class t extends f {
        final /* synthetic */ a mMS;

        public t(a aVar, com.tencent.mm.plugin.fts.a.a.g gVar) {
            this.mMS = aVar;
            super(gVar);
        }

        protected final void a(com.tencent.mm.plugin.fts.a.a.h hVar) {
            int i = 0;
            hVar.mMb = e.an(this.mLN.fDj, true);
            com.tencent.mm.plugin.fts.a.a a = this.mMS.mMD;
            e eVar = hVar.mMb;
            String aMX = eVar.aMX();
            long size = (long) eVar.mLE.size();
            long currentTimeMillis = System.currentTimeMillis() - 1105032704;
            Cursor rawQuery = a.mJR.rawQuery(String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype), CASE WHEN timestamp - %d > 0 THEN 1 ELSE 0 END AS time_range FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type = 131072 ORDER BY time_range desc, subtype ;", new Object[]{a.aMR(), a.aMS(), Long.valueOf(size), Long.valueOf(currentTimeMillis), a.aMR(), a.aMS(), a.aMR(), a.aMS(), a.aMS(), aMX}), null);
            List<k> arrayList = new ArrayList();
            HashSet hashSet = new HashSet();
            hashSet.addAll(this.mLN.mLX);
            while (rawQuery.moveToNext()) {
                k h = new k().h(rawQuery);
                if (hashSet.add(h.mLs)) {
                    if (i < h.mLr) {
                        if (arrayList.size() > this.mLN.mLW) {
                            break;
                        }
                        i = h.mLr;
                        arrayList.add(h);
                    } else {
                        arrayList.add(h);
                    }
                    if (Thread.interrupted()) {
                        rawQuery.close();
                        throw new InterruptedException("Task is Cancel: " + this.mLN.fDj);
                    }
                }
            }
            rawQuery.close();
            hVar.mMc = new ArrayList();
            for (k kVar : arrayList) {
                kVar.aMY();
                kVar.a(hVar.mMb);
                hVar.mMc.add(kVar);
            }
            if (this.mLN.mLY != null) {
                Collections.sort(hVar.mMc, this.mLN.mLY);
            }
        }

        public final String getName() {
            return "SearchTopContactTask";
        }

        public final int getId() {
            return 22;
        }
    }

    private class h extends com.tencent.mm.plugin.fts.a.a.a {
        private String gAb;
        private boolean gJC = false;
        final /* synthetic */ a mMS;
        private boolean mNm = false;

        public h(a aVar, String str) {
            this.mMS = aVar;
            this.gAb = str;
        }

        public final boolean execute() {
            x.i("MicroMsg.FTS.FTS5SearchContactLogic", "Dirty Contact %s", new Object[]{this.gAb});
            if (this.mMS.mMF.containsKey(this.gAb)) {
                this.mNm = true;
            } else {
                this.mMS.mMD.Ba(this.gAb);
                List b = this.mMS.mMD.b(com.tencent.mm.plugin.fts.a.c.mKi, this.gAb);
                this.mMS.mMF.put(this.gAb, b);
                if (b.isEmpty()) {
                    this.gJC = true;
                    this.mMS.gJk.a(65556, new e(this.mMS, this.gAb));
                } else {
                    Cursor Bo = this.mMS.mMD.Bo(this.gAb);
                    HashSet hashSet = new HashSet();
                    while (Bo.moveToNext()) {
                        hashSet.add(Bo.getString(0));
                    }
                    Bo.close();
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        this.mMS.mMD.Ba(str);
                        if (!this.mMS.mMF.containsKey(str)) {
                            this.mMS.mMF.put(str, this.mMS.mMD.b(com.tencent.mm.plugin.fts.a.c.mKi, str));
                        }
                    }
                    this.mMS.mME.remove(this.gAb);
                    ((PluginFTS) g.k(PluginFTS.class)).getTopHitsLogic().Bm(this.gAb);
                }
            }
            return true;
        }

        public final String ado() {
            return String.format("{username: %s cached: %b isSkipped: %b}", new Object[]{this.gAb, Boolean.valueOf(this.mNm), Boolean.valueOf(this.gJC)});
        }

        public final String getName() {
            return "MarkContactDirtyTask";
        }

        public final int getId() {
            return 17;
        }
    }

    private class u extends com.tencent.mm.plugin.fts.a.a.a {
        final /* synthetic */ a mMS;
        private int mNo;
        private int mNp;
        private int mNq;

        private u(a aVar) {
            this.mMS = aVar;
            this.mNo = 0;
            this.mNp = 0;
            this.mNq = 0;
        }

        public final boolean execute() {
            int i;
            Bg("start");
            Iterator it = this.mMS.mMF.entrySet().iterator();
            int i2 = 50;
            while (it.hasNext()) {
                if (Thread.interrupted()) {
                    this.mMS.mMD.commit();
                    throw new InterruptedException();
                }
                int i3;
                if (i2 >= 50) {
                    this.mMS.mMD.commit();
                    this.mMS.mMD.beginTransaction();
                    i3 = 0;
                } else {
                    i3 = i2;
                }
                Entry entry = (Entry) it.next();
                for (Long longValue : (List) entry.getValue()) {
                    this.mMS.mMD.g(Long.valueOf(longValue.longValue()));
                    i3++;
                }
                String str = (String) entry.getKey();
                af AW = this.mMS.mol.AW(str);
                if (AW == null || AW.field_username.length() <= 0 || !this.mMS.D(AW)) {
                    i = i3;
                } else {
                    i = i3 + this.mMS.E(AW);
                }
                it.remove();
                this.mMS.mME.remove(str);
                this.mNo++;
                i2 = i;
            }
            Bg("dirtyContact");
            Iterator it2 = this.mMS.mME.iterator();
            while (it2.hasNext()) {
                if (Thread.interrupted()) {
                    this.mMS.mMD.commit();
                    throw new InterruptedException();
                }
                if (i2 >= 50) {
                    this.mMS.mMD.commit();
                    this.mMS.mMD.beginTransaction();
                    i = 0;
                } else {
                    i = i2;
                }
                str = (String) it2.next();
                long AY = this.mMS.mol.AY(str);
                af AW2 = this.mMS.mol.AW(str);
                if (AW2 == null || AW2.field_username.length() <= 0 || !this.mMS.D(AW2)) {
                    i2 = i;
                } else {
                    this.mMS.mMD.B(str, AY);
                    i2 = i + 1;
                }
                it2.remove();
                this.mNp++;
            }
            this.mMS.mMD.commit();
            Bg("timestampContact");
            e topHitsLogic = ((PluginFTS) g.k(PluginFTS.class)).getTopHitsLogic();
            topHitsLogic.mNY.clear();
            this.mNq = topHitsLogic.mNX.aNl();
            Bg("topHits");
            return true;
        }

        public final String ado() {
            return String.format("{Dirty: %d Timestamp: %d tophitsCount: %d}", new Object[]{Integer.valueOf(this.mNo), Integer.valueOf(this.mNp), Integer.valueOf(this.mNq)});
        }

        public final String getName() {
            return "UpdateDirtyAndTimestampContactTask";
        }

        public final int getId() {
            return 16;
        }
    }

    private class v extends com.tencent.mm.plugin.fts.a.a.a {
        final /* synthetic */ a mMS;
        private long mNr;
        private int mNs = 0;

        public v(a aVar, long j) {
            this.mMS = aVar;
            this.mNr = j;
        }

        public final boolean execute() {
            ArrayList arrayList = new ArrayList(32);
            com.tencent.mm.plugin.fts.a.a a = this.mMS.mMD;
            long j = this.mNr;
            Cursor rawQuery = a.mJR.rawQuery("SELECT user FROM FTS5ContactLabels WHERE label_id=?;", new String[]{Long.toString(j)});
            while (rawQuery.moveToNext()) {
                arrayList.add(rawQuery.getString(0));
            }
            rawQuery.close();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (!this.mMS.mMF.containsKey(str)) {
                    this.mMS.mMF.put(str, this.mMS.mMD.b(com.tencent.mm.plugin.fts.a.c.mKj, str));
                }
            }
            return true;
        }

        public final String ado() {
            return String.format("{mLabelId: %d mContactCount: %d}", new Object[]{Long.valueOf(this.mNr), Integer.valueOf(this.mNs)});
        }

        public final String getName() {
            return "UpdateLabelTask";
        }
    }

    public final com.tencent.mm.plugin.fts.a.a.a a(com.tencent.mm.plugin.fts.a.a.g gVar) {
        com.tencent.mm.plugin.fts.a.a.a lVar;
        switch (gVar.mLR) {
            case 5:
                lVar = new l(this, gVar);
                break;
            case 6:
                lVar = new k(this, gVar);
                break;
            case 7:
                lVar = new m(this, gVar);
                break;
            case 8:
                lVar = new o(this, gVar);
                break;
            case 9:
                lVar = new p(this, gVar);
                break;
            case 16:
                lVar = new q(this, gVar);
                break;
            case 32:
                lVar = new n(this, gVar);
                break;
            case R$styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                lVar = new t(this, gVar);
                break;
            case 64:
                lVar = new s(this, gVar);
                break;
            case 96:
                lVar = new r(this, gVar);
                break;
            default:
                lVar = new j(this, gVar);
                break;
        }
        return this.gJk.a(-65536, lVar);
    }

    protected final boolean onCreate() {
        if (((com.tencent.mm.plugin.fts.a.m) g.k(com.tencent.mm.plugin.fts.a.m.class)).isFTSContextReady()) {
            x.i("MicroMsg.FTS.FTS5SearchContactLogic", "Create Success!");
            this.mMD = (com.tencent.mm.plugin.fts.c.a) ((com.tencent.mm.plugin.fts.a.m) g.k(com.tencent.mm.plugin.fts.a.m.class)).getFTSIndexStorage(3);
            this.gJk = ((com.tencent.mm.plugin.fts.a.m) g.k(com.tencent.mm.plugin.fts.a.m.class)).getFTSTaskDaemon();
            this.mol = ((com.tencent.mm.plugin.fts.a.m) g.k(com.tencent.mm.plugin.fts.a.m.class)).getFTSMainDB();
            this.mME = new HashSet();
            this.mMF = new HashMap();
            this.mMG = new HashMap();
            this.mMH = new HashMap();
            try {
                this.mMI = af.class.getDeclaredMethod("vT", new Class[0]);
                this.mMI.setAccessible(true);
                this.gJk.a(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, new f(this, (byte) 0));
                this.gJk.a(131082, new a(this, (byte) 0));
                this.gJk.a(131092, new b(this, (byte) 0));
                this.gJk.a(Integer.MAX_VALUE, new c(this, (byte) 0));
                ((com.tencent.mm.plugin.chatroom.b.b) g.h(com.tencent.mm.plugin.chatroom.b.b.class)).Fh().c(this.mML);
                ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).EY().a(this.mMK);
                ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Fd().a(this.mMJ);
                com.tencent.mm.sdk.e.j.a aVar = this.mMM;
                if (com.tencent.mm.as.b.hEy != null) {
                    com.tencent.mm.as.b.hEy.a(aVar);
                }
                this.mMP.J(600000, 600000);
                this.mMN.ceO();
                this.mMO.ceO();
                return true;
            } catch (Throwable e) {
                AssertionFailedError assertionFailedError = new AssertionFailedError("Can't find BaseContact.parseBuff method, class prototype has changed.");
                assertionFailedError.initCause(e);
                throw assertionFailedError;
            }
        }
        x.i("MicroMsg.FTS.FTS5SearchContactLogic", "Create Fail!");
        return false;
    }

    protected final boolean AZ() {
        this.mMN.dead();
        this.mMO.dead();
        this.mMQ.TG();
        this.mMP.TG();
        ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).EY().b(this.mMK);
        ((com.tencent.mm.plugin.chatroom.b.b) g.h(com.tencent.mm.plugin.chatroom.b.b.class)).Fh().j(this.mML);
        ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Fd().b(this.mMJ);
        com.tencent.mm.sdk.e.j.a aVar = this.mMM;
        if (com.tencent.mm.as.b.hEy != null) {
            com.tencent.mm.as.b.hEy.b(aVar);
        }
        if (this.mMF != null) {
            this.mMF.clear();
        }
        if (this.mME != null) {
            this.mME.clear();
        }
        this.mMD = null;
        this.gJk = null;
        return true;
    }

    public final String getName() {
        return "FTS5SearchContactLogic";
    }

    final int a(String str, com.tencent.mm.storage.x xVar, String[] strArr, byte[] bArr, HashMap<String, com.tencent.mm.storage.x> hashMap) {
        int i = 0;
        String str2 = xVar.field_nickname;
        String am = d.am(str2, false);
        String am2 = d.am(str2, true);
        long j = 0;
        long AY = this.mol.AY(str);
        StringBuffer stringBuffer = new StringBuffer();
        if (strArr != null) {
            j = (long) strArr.length;
            HashMap hashMap2 = new HashMap();
            com.tencent.mm.i.a.a.a aVar = new com.tencent.mm.i.a.a.a();
            try {
                aVar.aF(bArr);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", e, "parse chatroom data", new Object[0]);
            }
            Iterator it = aVar.gBH.iterator();
            while (it.hasNext()) {
                com.tencent.mm.i.a.a.b bVar = (com.tencent.mm.i.a.a.b) it.next();
                if (!bh.ov(bVar.gBL)) {
                    hashMap2.put(bVar.userName, bVar.gBL);
                }
            }
            for (String str3 : strArr) {
                com.tencent.mm.storage.x xVar2 = (com.tencent.mm.storage.x) hashMap.get(str3);
                if (xVar2 != null) {
                    String str4 = xVar2.field_conRemark;
                    String str5 = xVar2.field_nickname;
                    String am3 = d.am(str4, false);
                    String am4 = d.am(str4, true);
                    stringBuffer.append(bh.az(str4, " ")).append("‌");
                    stringBuffer.append(bh.az(am3, " ")).append("‌");
                    stringBuffer.append(bh.az(am4, " ")).append("‌");
                    str4 = d.am(str5, false);
                    am3 = d.am(str5, true);
                    stringBuffer.append(bh.az(str5, " ")).append("‌");
                    stringBuffer.append(bh.az(str4, " ")).append("‌");
                    stringBuffer.append(bh.az(am3, " ")).append("‌");
                    stringBuffer.append(bh.az((String) hashMap2.get(str3), " ")).append("‌");
                    B(xVar2);
                    stringBuffer.append(bh.az(xVar2.fWy, " ")).append("‌");
                    stringBuffer.append(bh.az(d.cE(str3, xVar2.vN()), " ")).append("‌");
                    stringBuffer.append("​");
                }
            }
        }
        if (!bh.ov(str2)) {
            this.mMD.a(131075, 5, j, str, AY, str2);
            if (bh.ov(am)) {
                i = 1;
            } else {
                this.mMD.a(131075, 6, j, str, AY, am);
                i = 2;
            }
            if (!bh.ov(am2)) {
                this.mMD.a(131075, 7, j, str, AY, am2);
                i++;
            }
        }
        if (stringBuffer.length() <= 0) {
            return i;
        }
        stringBuffer.setLength(stringBuffer.length() - 1);
        this.mMD.a(131075, 38, j, str, AY, stringBuffer.toString());
        return i + 1;
    }

    public final int i(String str, String[] strArr) {
        int i = 0;
        String[] strArr2 = (String[]) this.mMG.get(str);
        this.mMD.beginTransaction();
        if (strArr2 == null) {
            this.mMD.Bp(str);
            i = ((int) this.mMD.mOp.simpleQueryForLong()) + 0;
            if (strArr != null) {
                this.mMD.j(str, strArr);
                this.mMG.put(str, strArr);
                i += strArr.length;
            }
        } else if (strArr == null) {
            this.mMD.Bp(str);
            i = ((int) this.mMD.mOp.simpleQueryForLong()) + 0;
            this.mMG.remove(str);
        } else {
            HashSet hashSet = new HashSet(Arrays.asList(strArr2));
            int length = strArr.length;
            int i2 = 0;
            while (i < length) {
                String str2 = strArr[i];
                if (!hashSet.remove(str2)) {
                    com.tencent.mm.plugin.fts.c.a aVar = this.mMD;
                    aVar.mOj.bindString(1, str);
                    aVar.mOj.bindString(2, str2);
                    aVar.mOj.execute();
                    i2++;
                }
                i++;
            }
            Iterator it = hashSet.iterator();
            i = i2;
            while (it.hasNext()) {
                String str3 = (String) it.next();
                com.tencent.mm.plugin.fts.c.a aVar2 = this.mMD;
                aVar2.mOk.bindString(1, str);
                aVar2.mOk.bindString(2, str3);
                aVar2.mOk.execute();
                i++;
            }
            this.mMG.put(str, strArr);
        }
        this.mMD.commit();
        return i;
    }

    final void B(com.tencent.mm.storage.x xVar) {
        try {
            this.mMI.invoke(xVar, new Object[0]);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", e, "Failed parsing RContact LVBuffer.", new Object[0]);
        }
    }

    static boolean Bk(String str) {
        if (bh.ov(str) || str.endsWith("@stranger") || str.endsWith("@qqim") || str.endsWith("@app") || str.startsWith("fake_")) {
            return false;
        }
        return true;
    }

    static boolean C(com.tencent.mm.storage.x xVar) {
        if ((xVar.isHidden() && !"notifymessage".equals(xVar.field_username)) || xVar.AF() || xVar.field_deleteFlag != 0) {
            return false;
        }
        if (com.tencent.mm.l.a.fZ(xVar.field_type) || (!xVar.AE() && !xVar.cia())) {
            return true;
        }
        return false;
    }

    final boolean D(com.tencent.mm.storage.x xVar) {
        String str = xVar.field_username;
        if (!C(xVar) || !Bk(str)) {
            return false;
        }
        if (com.tencent.mm.l.a.fZ(xVar.field_type)) {
            return true;
        }
        if (xVar.AE() || xVar.cia() || !this.mol.AX(str)) {
            return false;
        }
        return true;
    }

    final int E(com.tencent.mm.storage.x xVar) {
        if (!s.eV(xVar.field_username)) {
            return F(xVar);
        }
        String format = String.format("SELECT memberlist, roomdata FROM %s WHERE chatroomname = ?", new Object[]{"chatroom"});
        Cursor h = this.mol.h(format, new String[]{xVar.field_username});
        try {
            CharSequence string;
            byte[] blob;
            if (h.moveToNext()) {
                string = h.getString(0);
                blob = h.getBlob(1);
            } else {
                blob = null;
                string = null;
            }
            if (h != null) {
                h.close();
            }
            if (bh.ov(string) || blob == null) {
                x.i("MicroMsg.FTS.FTS5SearchContactLogic", "error chatroom data %s", new Object[]{xVar.field_username});
                if (i(xVar.field_username, null) <= 0) {
                    return 0;
                }
                x.i("MicroMsg.FTS.FTS5SearchContactLogic", "updateChatroomMember %s %d", new Object[]{xVar.field_username, Integer.valueOf(i(xVar.field_username, null))});
                return 0;
            }
            String[] split = com.tencent.mm.plugin.fts.a.c.a.mKw.split(string);
            Arrays.sort(split, new 9(this));
            if (i(xVar.field_username, split) > 0) {
                x.i("MicroMsg.FTS.FTS5SearchContactLogic", "updateChatroomMember %s %d", new Object[]{xVar.field_username, Integer.valueOf(i(xVar.field_username, split))});
            }
            HashMap hashMap = new HashMap();
            Cursor h2 = this.mol.h("SELECT rowid, username, alias, conRemark, nickname , lvbuff FROM rcontact WHERE username IN " + d.v(split) + ";", null);
            while (h2.moveToNext()) {
                try {
                    af xVar2 = new com.tencent.mm.storage.x();
                    xVar2.gJd = h2.getLong(0);
                    xVar2.setUsername(h2.getString(1));
                    xVar2.cZ(h2.getString(2));
                    xVar2.da(h2.getString(3));
                    xVar2.dc(h2.getString(4));
                    xVar2.z(h2.getBlob(5));
                    hashMap.put(xVar2.field_username, xVar2);
                } finally {
                    if (h2 != null) {
                        h2.close();
                    }
                }
            }
            return a(xVar.field_username, xVar, split, blob, hashMap);
        } catch (Throwable th) {
            if (h != null) {
                h.close();
            }
        }
    }

    final int F(com.tencent.mm.storage.x xVar) {
        int i;
        String d;
        int i2;
        int i3;
        int i4;
        String str;
        long j = xVar.gJd;
        String str2 = xVar.field_username;
        String vN = xVar.vN();
        String str3 = xVar.field_nickname;
        String am = d.am(str3, false);
        String am2 = d.am(str3, true);
        String str4 = xVar.field_conRemark;
        String am3 = d.am(str4, false);
        String am4 = d.am(str4, true);
        String str5 = xVar.fWy;
        String str6 = xVar.field_contactLabelIds;
        String str7 = xVar.fWE;
        int i5 = xVar.field_verifyFlag;
        String str8 = "";
        long currentTimeMillis = System.currentTimeMillis();
        if ((i5 & com.tencent.mm.storage.x.cic()) != 0) {
            i = 0;
            d = bh.d(((com.tencent.mm.api.h) g.h(com.tencent.mm.api.h.class)).cd(str2), "​");
            i2 = 131076;
        } else {
            currentTimeMillis = this.mol.AY(str2);
            if (str6 == null || str6.length() <= 0) {
                i2 = WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
                d = str8;
                i = 0;
            } else {
                if (str6 != null) {
                    Object substring;
                    if (str6.endsWith("\u0000")) {
                        substring = str6.substring(0, str6.length() - 1);
                    } else {
                        String str9 = str6;
                    }
                    if (substring.length() == 0) {
                        i3 = 0;
                    } else {
                        List arrayList;
                        String[] split = com.tencent.mm.plugin.fts.a.c.a.mKD.split(substring);
                        List list;
                        if (split.length != 0) {
                            arrayList = new ArrayList(split.length);
                            for (String str10 : split) {
                                arrayList.add(Long.valueOf(bh.getLong(str10, 0)));
                            }
                            list = arrayList;
                        } else {
                            list = null;
                        }
                        arrayList = (List) this.mMH.get(str2);
                        if (arrayList == null) {
                            this.mMD.Bn(str2);
                            if (!(r6 == null || r6.isEmpty())) {
                                this.mMD.g(str2, r6);
                                this.mMH.put(str2, r6);
                            }
                        } else if (r6 == null || r6.isEmpty()) {
                            this.mMD.Bn(str2);
                            this.mMH.remove(str2);
                        } else {
                            com.tencent.mm.plugin.fts.c.a aVar;
                            HashSet hashSet = new HashSet(arrayList);
                            for (Long longValue : r6) {
                                long longValue2 = longValue.longValue();
                                if (!hashSet.remove(Long.valueOf(longValue2))) {
                                    aVar = this.mMD;
                                    aVar.mOm.bindString(1, str2);
                                    aVar.mOm.bindLong(2, longValue2);
                                    aVar.mOm.execute();
                                }
                            }
                            Iterator it = hashSet.iterator();
                            while (it.hasNext()) {
                                long longValue3 = ((Long) it.next()).longValue();
                                aVar = this.mMD;
                                aVar.mOn.bindString(1, str2);
                                aVar.mOn.bindLong(2, longValue3);
                                aVar.mOn.execute();
                            }
                            this.mMH.put(str2, r6);
                        }
                        arrayList = this.mol.AZ(substring);
                        if (arrayList.size() == 0) {
                            i3 = 0;
                        } else {
                            this.mMD.a(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 11, j, str2, currentTimeMillis, bh.d(arrayList, "​"));
                            i3 = 1;
                        }
                    }
                } else {
                    i3 = 0;
                }
                i2 = WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
                d = str8;
                i = i3 + 0;
            }
        }
        String cE = d.cE(str2, vN);
        if (cE == null || cE.length() == 0) {
            i4 = i;
        } else {
            this.mMD.a(i2, 15, j, str2, currentTimeMillis, cE);
            i4 = i + 1;
        }
        if (str4 == null || str4.length() == 0) {
            am4 = null;
            cE = str3;
            str3 = null;
            str = am;
            str6 = am2;
            am2 = null;
        } else {
            str6 = am4;
            str = am3;
            cE = str4;
            am4 = am2;
            am2 = am;
        }
        if (!(cE == null || cE.length() == 0)) {
            if (cE.equalsIgnoreCase(str)) {
                am3 = null;
            } else {
                am3 = str;
            }
            if (am3 == null || am3.length() == 0 || am3.equalsIgnoreCase(str6)) {
                str8 = null;
            } else {
                str8 = str6;
            }
            this.mMD.a(i2, 1, j, str2, currentTimeMillis, cE);
            if (!(am3 == null || am3.length() == 0)) {
                this.mMD.a(i2, 2, j, str2, currentTimeMillis, am3);
            }
            if (!(str8 == null || str8.length() == 0)) {
                this.mMD.a(i2, 3, j, str2, currentTimeMillis, str8);
            }
            i4 += 3;
        }
        if (str3 == null || str3.length() == 0) {
            i = i4;
        } else {
            if (str3.equalsIgnoreCase(am2)) {
                am2 = null;
            }
            if (am2 == null || am2.length() == 0 || am2.equalsIgnoreCase(am4)) {
                str8 = null;
            } else {
                str8 = am4;
            }
            this.mMD.a(i2, 5, j, str2, currentTimeMillis, str3);
            if (!(am2 == null || am2.length() == 0)) {
                this.mMD.a(i2, 6, j, str2, currentTimeMillis, am2);
            }
            if (!(str8 == null || str8.length() == 0)) {
                this.mMD.a(i2, 7, j, str2, currentTimeMillis, str8);
            }
            i = i4 + 3;
        }
        if (str5 != null && str5.length() > 0) {
            this.mMD.a(i2, 4, j, str2, currentTimeMillis, str5);
            i++;
        }
        if (i2 == WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
            if (bh.ov(str7)) {
                Cursor h = this.mol.h("SELECT moblie FROM addr_upload2 WHERE username=?;", new String[]{str2});
                if (h.moveToFirst()) {
                    this.mMD.a(i2, 16, j, str2, currentTimeMillis, h.getString(0));
                    i3 = i + 1;
                } else {
                    i3 = i;
                }
                h.close();
                i = i3;
            } else {
                this.mMD.a(i2, 16, j, str2, currentTimeMillis, str7.replace(",", "​"));
                i++;
            }
            cE = xVar.getProvince();
            if (mMR.contains(cE)) {
                cE = "";
            }
            if (!(cE == null || cE.length() == 0)) {
                this.mMD.a(i2, 18, j, str2, currentTimeMillis, cE);
                i++;
            }
            cE = xVar.getCity();
            if (!(cE == null || cE.length() == 0)) {
                this.mMD.a(i2, 17, j, str2, currentTimeMillis, cE);
                i++;
            }
        }
        if (i2 != 131076 || bh.ov(d)) {
            return i;
        }
        this.mMD.a(i2, 19, j, str2, currentTimeMillis, d);
        i++;
        cE = d.am(d, false);
        if (!bh.ov(cE)) {
            this.mMD.a(i2, 20, j, str2, currentTimeMillis, cE);
            i++;
        }
        cE = d.am(d, true);
        if (bh.ov(cE)) {
            return i;
        }
        this.mMD.a(i2, 21, j, str2, currentTimeMillis, cE);
        return i + 1;
    }

    static {
        String[] split = ac.getContext().getString(com.tencent.mm.plugin.fts.g.a.dXJ).split(";");
        if (split != null) {
            for (Object add : split) {
                mMR.add(add);
            }
        }
    }
}
