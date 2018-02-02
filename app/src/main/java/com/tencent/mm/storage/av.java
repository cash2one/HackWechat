package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.a.f;
import com.tencent.mm.by.h;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.c.b;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au.a;
import com.tencent.mm.storage.au.d;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.s;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import junit.framework.Assert;

public final class av extends j implements c {
    public static final String[] gJN;
    private final h hhp;
    private ar kpL;
    private as kpN;
    private final long xyx = 86400;
    private List<b> xzA;
    private final f<Integer, au.c> xzB = new f(100);
    private final f<Integer, d> xzC = new f(100);
    private final f<Integer, a> xzD = new f(100);
    private final f<Integer, au.b> xzE = new f(100);
    private final f<Integer, Object> xzF = new f(100);
    private final f<String, Long> xzG = new f(100);
    private ah xzH = new ah();
    private final k<c.a, c.c> xzI = new k<c.a, c.c>(this) {
        final /* synthetic */ av xzN;

        {
            this.xzN = r1;
        }

        protected final /* synthetic */ void p(Object obj, Object obj2) {
            ((c.a) obj).a(this.xzN, (c.c) obj2);
        }

        public final void cB(List<c.c> list) {
            if (!isLocked() && this.xzN.kpN != null) {
                for (c.c cVar : list) {
                    if (cVar != null) {
                        this.xzN.kpN.b(this.xzN, cVar);
                    }
                }
            }
        }
    };
    private Map<String, c.c> xzJ = new HashMap();
    private boolean xzK = false;
    private String xzL = "";
    private long xzM = 0;
    private boolean xzy = false;
    private final List<e> xzz = new CopyOnWriteArrayList();

    public final int EV(java.lang.String r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r8 = this;
        r7 = 2;
        r1 = 0;
        r0 = new java.lang.StringBuilder;
        r2 = " SELECT COUNT(*) FROM ";
        r0.<init>(r2);
        r2 = r8.EQ(r9);
        r0 = r0.append(r2);
        r2 = " WHERE";
        r0 = r0.append(r2);
        r2 = r8.Xv(r9);
        r0 = r0.append(r2);
        r2 = "AND isSend=1";
        r0 = r0.append(r2);
        r2 = r0.toString();
        r0 = r8.hhp;
        r3 = 0;
        r3 = r0.a(r2, r3, r7);
        r0 = r3.moveToFirst();	 Catch:{ Exception -> 0x0059, all -> 0x006b }
        if (r0 == 0) goto L_0x0070;	 Catch:{ Exception -> 0x0059, all -> 0x006b }
    L_0x0039:
        r0 = 0;	 Catch:{ Exception -> 0x0059, all -> 0x006b }
        r0 = r3.getInt(r0);	 Catch:{ Exception -> 0x0059, all -> 0x006b }
    L_0x003e:
        r3.close();
    L_0x0041:
        r3 = "MicroMsg.MsgInfoStorage";
        r4 = "[getMsgCountBySelf] getCursor talk:%s,count:%s,[%s]";
        r5 = 3;
        r5 = new java.lang.Object[r5];
        r5[r1] = r9;
        r1 = 1;
        r6 = java.lang.Integer.valueOf(r0);
        r5[r1] = r6;
        r5[r7] = r2;
        com.tencent.mm.sdk.platformtools.x.d(r3, r4, r5);
        return r0;
    L_0x0059:
        r0 = move-exception;
        r4 = "MicroMsg.MsgInfoStorage";	 Catch:{ Exception -> 0x0059, all -> 0x006b }
        r5 = "";	 Catch:{ Exception -> 0x0059, all -> 0x006b }
        r6 = 0;	 Catch:{ Exception -> 0x0059, all -> 0x006b }
        r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x0059, all -> 0x006b }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r4, r0, r5, r6);	 Catch:{ Exception -> 0x0059, all -> 0x006b }
        r3.close();
        r0 = r1;
        goto L_0x0041;
    L_0x006b:
        r0 = move-exception;
        r3.close();
        throw r0;
    L_0x0070:
        r0 = r1;
        goto L_0x003e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.av.EV(java.lang.String):int");
    }

    public final int dm(java.lang.String r9, java.lang.String r10) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r8 = this;
        r7 = 2;
        r1 = 0;
        r0 = new java.lang.StringBuilder;
        r2 = " SELECT COUNT(*) FROM ";
        r0.<init>(r2);
        r2 = r8.EQ(r9);
        r0 = r0.append(r2);
        r2 = " WHERE";
        r0 = r0.append(r2);
        r2 = r8.Xv(r9);
        r0 = r0.append(r2);
        r2 = "AND content LIKE '";
        r0 = r0.append(r2);
        r0 = r0.append(r10);
        r2 = "%' ";
        r0 = r0.append(r2);
        r2 = r0.toString();
        r0 = r8.hhp;
        r3 = 0;
        r3 = r0.a(r2, r3, r7);
        r0 = r3.moveToFirst();	 Catch:{ Exception -> 0x0067, all -> 0x0079 }
        if (r0 == 0) goto L_0x007e;	 Catch:{ Exception -> 0x0067, all -> 0x0079 }
    L_0x0044:
        r0 = 0;	 Catch:{ Exception -> 0x0067, all -> 0x0079 }
        r0 = r3.getInt(r0);	 Catch:{ Exception -> 0x0067, all -> 0x0079 }
    L_0x0049:
        r3.close();
    L_0x004c:
        r3 = "MicroMsg.MsgInfoStorage";
        r4 = "getMsgCountByMember getCursor talk:%s member:%s,count:%s,[%s]";
        r5 = 4;
        r5 = new java.lang.Object[r5];
        r5[r1] = r9;
        r1 = 1;
        r5[r1] = r10;
        r1 = java.lang.Integer.valueOf(r0);
        r5[r7] = r1;
        r1 = 3;
        r5[r1] = r2;
        com.tencent.mm.sdk.platformtools.x.d(r3, r4, r5);
        return r0;
    L_0x0067:
        r0 = move-exception;
        r4 = "MicroMsg.MsgInfoStorage";	 Catch:{ Exception -> 0x0067, all -> 0x0079 }
        r5 = "";	 Catch:{ Exception -> 0x0067, all -> 0x0079 }
        r6 = 0;	 Catch:{ Exception -> 0x0067, all -> 0x0079 }
        r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x0067, all -> 0x0079 }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r4, r0, r5, r6);	 Catch:{ Exception -> 0x0067, all -> 0x0079 }
        r3.close();
        r0 = r1;
        goto L_0x004c;
    L_0x0079:
        r0 = move-exception;
        r3.close();
        throw r0;
    L_0x007e:
        r0 = r1;
        goto L_0x0049;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.av.dm(java.lang.String, java.lang.String):int");
    }

    public final void a(e eVar) {
        if (!this.xzz.contains(eVar)) {
            x.i("MicroMsg.MsgInfoStorage", "addMessageStorageImpl %s", eVar);
            this.xzz.add(eVar);
        }
    }

    public final h aZl() {
        return this.hhp;
    }

    static {
        String[] strArr = new String[1];
        strArr[0] = "CREATE TABLE IF NOT EXISTS " + "message" + " ( msgId INTEGER PRIMARY KEY, msgSvrId" + " INTEGER , type INT, status" + " INT, isSend INT, isShowTimer" + " INTEGER, createTime INTEGER, talker" + " TEXT, content TEXT, imgPath" + " TEXT, reserved TEXT, lvbuffer" + " BLOB, transContent TEXT,transBrandWording" + " TEXT ,talkerId INTEGER, bizClientMsgId" + " TEXT, bizChatId INTEGER DEFAULT -1, bizChatUserId" + " TEXT, msgSeq INTEGER, flag" + " INT) ";
        gJN = strArr;
    }

    public final void a(c.c cVar) {
        if (this.xzI.ca(cVar)) {
            this.xzI.doNotify();
        }
    }

    public final void a(c.a aVar, Looper looper) {
        this.xzI.a(aVar, looper);
    }

    public final void a(c.a aVar) {
        this.xzI.remove(aVar);
    }

    public final void lock() {
        Assert.assertTrue("lock deprecated, use lockForSync instead.", false);
    }

    public final void unlock() {
        Assert.assertTrue("unlock deprecated, use lockForSync instead.", false);
    }

    public final void Et(String str) {
        x.i("MicroMsg.MsgInfoStorage", "lockForSync tag:%s islock:%b lockCnt[%d,%d] notifyCnt:%d last:[%s,%d]", str, Boolean.valueOf(this.xzK), Integer.valueOf(this.xjE.xjH), Integer.valueOf(this.xzI.xjH), Integer.valueOf(this.xzJ.size()), this.xzL, Long.valueOf(bh.bz(this.xzM)));
        if (bh.ov(str)) {
            Assert.assertTrue("lockForSync, do not call me by null tag.", false);
        }
        if (this.xzK) {
            x.w("MicroMsg.MsgInfoStorage", "lockForSync, has been locked by :%s  time:%d", this.xzL, Long.valueOf(bh.bz(this.xzM)));
            return;
        }
        this.xzL = str;
        this.xzM = bh.Wp();
        this.xzK = true;
        super.lock();
        this.xzI.lock();
    }

    public final void Eu(String str) {
        x.i("MicroMsg.MsgInfoStorage", "unlockForSync tag:%s islock:%b lockCnt[%d,%d] notifyCnt:%d last:[%s,%d]", str, Boolean.valueOf(this.xzK), Integer.valueOf(this.xjE.xjH), Integer.valueOf(this.xzI.xjH), Integer.valueOf(this.xzJ.size()), this.xzL, Long.valueOf(bh.bz(this.xzM)));
        if (bh.ov(str)) {
            Assert.assertTrue("lockForSync, do not call me by null tag.", false);
        }
        if (!this.xzK) {
            x.w("MicroMsg.MsgInfoStorage", "unlockForSync, No one Locking Now , why this fucking tag:%s call it ! [%s]", str, bh.cgy());
        } else if (str.equals(this.xzL)) {
            this.xzK = false;
            this.xzM = 0;
            this.xzL = "";
            for (String str2 : this.xzJ.keySet()) {
                a((c.c) this.xzJ.get(str2));
            }
            this.xzJ.clear();
            super.unlock();
            this.xzI.unlock();
            doNotify();
        } else {
            x.w("MicroMsg.MsgInfoStorage", "unlockForSync locking[%s] diff:%d, but unlock[%s] , Ignore this call.", this.xzL, Long.valueOf(bh.bz(this.xzM)), str);
        }
    }

    public final void a(h hVar, String str) {
        Object obj = null;
        Object obj2 = null;
        Object obj3 = null;
        Object obj4 = null;
        Object obj5 = null;
        Object obj6 = null;
        Object obj7 = null;
        Object obj8 = null;
        Object obj9 = null;
        Cursor a = hVar.a("PRAGMA table_info( " + str + " )", null, 2);
        int columnIndex = a.getColumnIndex("name");
        while (a.moveToNext()) {
            if (columnIndex >= 0) {
                String string = a.getString(columnIndex);
                if ("lvbuffer".equalsIgnoreCase(string)) {
                    obj = 1;
                } else if ("transContent".equalsIgnoreCase(string)) {
                    obj2 = 1;
                } else if ("transBrandWording".equalsIgnoreCase(string)) {
                    obj3 = 1;
                } else if ("talkerId".equalsIgnoreCase(string)) {
                    obj4 = 1;
                } else if ("bizClientMsgId".equalsIgnoreCase(string)) {
                    obj5 = 1;
                } else if ("bizChatId".equalsIgnoreCase(string)) {
                    obj6 = 1;
                } else if ("bizChatUserId".equalsIgnoreCase(string)) {
                    obj7 = 1;
                } else if ("msgSeq".equalsIgnoreCase(string)) {
                    obj8 = 1;
                } else if ("flag".equalsIgnoreCase(string)) {
                    obj9 = 1;
                }
            }
        }
        a.close();
        long dz = hVar.dz(Thread.currentThread().getId());
        if (obj == null) {
            hVar.fx(str, "Alter table " + str + " add lvbuffer BLOB ");
        }
        if (obj2 == null) {
            hVar.fx(str, "Alter table " + str + " add transContent TEXT ");
        }
        if (obj3 == null) {
            hVar.fx(str, "Alter table " + str + " add transBrandWording TEXT ");
        }
        if (obj4 == null) {
            hVar.fx(str, "Alter table " + str + " add talkerId INTEGER ");
        }
        if (obj5 == null) {
            hVar.fx(str, "Alter table " + str + " add bizClientMsgId TEXT ");
        }
        if (obj6 == null) {
            hVar.fx(str, "Alter table " + str + " add bizChatId INTEGER DEFAULT -1");
        }
        if (obj7 == null) {
            hVar.fx(str, "Alter table " + str + " add bizChatUserId TEXT ");
        }
        if (obj8 == null) {
            hVar.fx(str, "Alter table " + str + " add msgSeq INTEGER ");
        }
        if (obj9 == null) {
            hVar.fx(str, "Alter table " + str + " add flag INT DEFAULT 0 ");
        }
        hVar.fS(dz);
    }

    public final void E(String str, long j) {
        b XB = XB(str);
        long j2 = XB.hzX;
        Random random = new Random();
        this.hhp.fx("message", "BEGIN;");
        cf auVar = new au(str);
        for (int i = 0; ((long) i) < j; i++) {
            auVar.aq(System.currentTimeMillis());
            auVar.setType(1);
            auVar.setContent("纵观目前国内手游市场，大量同质类手游充斥玩家的视野，而在主机和PC平台上经久不衰的体育类游戏，却鲜有佳作。在获得了NBA官方认可以后。" + bh.cgz());
            auVar.ao(j2);
            auVar.eQ(random.nextInt(4));
            auVar.eR(random.nextInt(1));
            j2++;
            XB.hzX++;
            auVar.ap(System.currentTimeMillis() + ((long) bh.cgz()));
            this.hhp.fx("message", "INSERT INTO " + EQ(auVar.field_talker) + " (msgid,msgSvrid,type,status,createTime,talker,content,talkerid)  VALUES(" + auVar.field_msgId + "," + auVar.field_msgSvrId + "," + auVar.getType() + "," + auVar.field_status + "," + auVar.field_createTime + ",'" + auVar.field_talker + "','" + auVar.field_content + "'," + Xw(str) + ");");
            if (i % 10000 == 0) {
                this.hhp.fx("message", "COMMIT;");
                this.hhp.fx("message", "BEGIN;");
            }
        }
        this.hhp.fx("message", "COMMIT;");
        this.kpN.WZ(str);
        auVar.ao(1 + j2);
        Q(auVar);
    }

    private void cjN() {
        long currentTimeMillis = System.currentTimeMillis();
        long dz = this.hhp.dz(Thread.currentThread().getId());
        long currentTimeMillis2 = System.currentTimeMillis();
        List arrayList = new ArrayList();
        String str = "message";
        String[] strArr = new String[]{"CREATE INDEX IF NOT EXISTS " + str + "IdIndex ON message ( msgId" + " )", "CREATE INDEX IF NOT EXISTS " + str + "SvrIdIndex ON message ( msgSvrId" + " )", "CREATE INDEX IF NOT EXISTS " + str + "SendCreateTimeIndex ON message ( status" + ",isSend,createTime" + " )", "CREATE INDEX IF NOT EXISTS " + str + "CreateTimeIndex ON message ( createTime" + " )", "CREATE INDEX IF NOT EXISTS " + str + "TaklerIdTypeCreateTimeIndex ON message ( talkerId" + ",type,createTime" + " )", "CREATE INDEX IF NOT EXISTS " + str + "TalkerIdStatusIndex ON message ( talkerId" + ",status )", "CREATE INDEX IF NOT EXISTS " + str + "TalkerIdCreateTimeIsSendIndex ON message ( talkerId" + ",isSend,createTime" + " )", "CREATE INDEX IF NOT EXISTS " + str + "TalkerIdCreateTimeIndex ON message ( talkerId" + ",createTime )", "CREATE INDEX IF NOT EXISTS " + str + "TalkerIdSvrIdIndex ON message ( talkerId" + ",msgSvrId )", "CREATE INDEX IF NOT EXISTS " + str + "TalkerIdTypeIndex ON message ( talkerId" + ",type )", "CREATE INDEX IF NOT EXISTS " + str + "TalkerTypeIndex ON message ( talker" + ",type )", "CREATE INDEX IF NOT EXISTS " + str + "messageTalkerMsgSeqIndex ON message ( talker" + ",msgSeq )", "CREATE INDEX IF NOT EXISTS " + str + "messageTalkerFlagMsgSeqIndex ON message ( talker" + ",flag,msgSeq" + " )"};
        if (!this.xzy) {
            strArr[4] = "CREATE INDEX IF NOT EXISTS  messageCreateTaklerTypeTimeIndex ON message ( talker,type,createTime )";
            strArr[5] = "CREATE INDEX IF NOT EXISTS  messageTalkerStatusIndex ON message ( talker,status )";
            strArr[6] = "CREATE INDEX IF NOT EXISTS  messageTalkerCreateTimeIsSendIndex ON message ( talker,isSend,createTime )";
            strArr[7] = "CREATE INDEX IF NOT EXISTS  messageCreateTaklerTimeIndex ON message ( talker,createTime )";
            strArr[8] = "CREATE INDEX IF NOT EXISTS  messageTalkerSvrIdIndex ON message ( talker,msgSvrId )";
        }
        arrayList.addAll(Arrays.asList(strArr));
        for (int i = 0; i < arrayList.size(); i++) {
            this.hhp.fx("message", (String) arrayList.get(i));
        }
        x.i("MicroMsg.MsgInfoStorage", "build new index last %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
        this.hhp.fS(dz);
        x.i("MicroMsg.MsgInfoStorage", "executeMsgInitSQL last %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    public final void aZm() {
        g.Dk();
        g.Dj().CU().set(348167, Integer.valueOf(1));
    }

    public av(h hVar, ar arVar, as asVar) {
        this.hhp = hVar;
        this.kpL = arVar;
        this.kpN = asVar;
        g.Dk();
        if (((Integer) g.Dj().CU().get(348169, Integer.valueOf(0))).intValue() == 0) {
            int delete = this.hhp.delete("message", "msgId> ? ", new String[]{"80000000"});
            x.i("MicroMsg.MsgInfoStorage", "deleted dirty msg ,count is %d", Integer.valueOf(delete));
            g.Dk();
            g.Dj().CU().set(348169, Integer.valueOf(1));
        }
        a(hVar, "message");
        cjN();
        if (this.xzA == null) {
            this.xzA = new LinkedList();
        }
        this.xzA.clear();
        a(new b(1, "message", b.a(1, 1000000, 10000000, 90000000)));
    }

    public final void a(b bVar) {
        synchronized (this.xzA) {
            this.xzA.add(bVar);
        }
        b(bVar);
    }

    public final void aZn() {
        for (int i = 0; i < this.xzA.size(); i++) {
            b((b) this.xzA.get(i));
        }
    }

    private void b(b bVar) {
        Cursor a = this.hhp.a("select max(msgid) from " + bVar.name, null, 2);
        if (a.moveToFirst()) {
            int i = a.getInt(0);
            x.i("MicroMsg.MsgInfoStorage", "id count is %d, now id:%d", Integer.valueOf(i), Long.valueOf(bVar.hzX));
            if (((long) i) >= bVar.hzX) {
                x.i("MicroMsg.MsgTable", "summermsg setMsgLocalId [%d, %d]  regions[%d, %d] stack[%s]", Long.valueOf(bVar.hzX), Integer.valueOf(i), Long.valueOf(bVar.ooQ[0].ooT), Long.valueOf(bVar.ooQ[1].ooS), bh.cgy());
                if (((long) i) <= bVar.ooQ[0].ooT || ((long) i) >= bVar.ooQ[1].ooS) {
                    bVar.hzX = (long) i;
                } else {
                    x.i("MicroMsg.MsgTable", "summermsg setMsgLocalId revised msgLocalId to %d", Long.valueOf(bVar.ooQ[1].ooS));
                    bVar.hzX = bVar.ooQ[1].ooS;
                    com.tencent.mm.plugin.report.d.pPH.a(111, 169, 1, false);
                }
            }
        }
        a.close();
        x.w("MicroMsg.MsgInfoStorage", "loading new msg id:" + bVar.hzX);
    }

    public final void aZo() {
        if (this.xzy) {
            String str = "message";
            Cursor a = this.hhp.a("select count(*) from " + str + " where talkerId ISNULL ", null, 2);
            if (a != null) {
                int i = a.moveToFirst() ? a.getInt(0) : 0;
                a.close();
                if (i > 0) {
                    x.i("MicroMsg.MsgInfoStorage", " msg table exists null talkerid ,start translate tableName %s ", str);
                    long currentTimeMillis = System.currentTimeMillis();
                    x.i("MicroMsg.MsgInfoStorage", "update result :%b last %d", Boolean.valueOf(this.hhp.fx(str, "update " + str + " set talkerId=(select rowid from rcontact" + " where rcontact.username" + " = " + str + ".talker)")), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    if (this.hhp.fx(str, "update " + str + " set talkerId=(select rowid from rcontact" + " where rcontact.username" + " = " + str + ".talker)") && this.xzy) {
                        this.hhp.fx("message", "DROP INDEX messageCreateTaklerTypeTimeIndex IF EXISTS");
                        this.hhp.fx("message", "DROP INDEX messageTalkerStatusIndex IF EXISTS");
                        this.hhp.fx("message", "DROP INDEX messageTalkerCreateTimeIsSendIndex IF EXISTS");
                        this.hhp.fx("message", "DROP INDEX messageCreateTaklerTimeIndex IF EXISTS");
                        this.hhp.fx("message", "DROP INDEX messageTalkerSvrIdIndex IF EXISTS");
                        x.i("MicroMsg.MsgInfoStorage", "clear talker Name index");
                    }
                }
            }
        }
    }

    public final au dH(long j) {
        au auVar = new au();
        Cursor a = this.hhp.a(fR(j), null, "msgId=?", new String[]{String.valueOf(j)}, null, null, null, 2);
        if (a.moveToFirst()) {
            auVar.b(a);
        }
        a.close();
        return auVar;
    }

    public final au F(String str, long j) {
        au auVar = new au();
        Cursor a = this.hhp.a(EQ(str), null, "msgSvrId=?", new String[]{String.valueOf(j)}, null, null, null, 2);
        if (a.moveToFirst()) {
            auVar.b(a);
        }
        a.close();
        return auVar;
    }

    public final au G(String str, long j) {
        au auVar = new au();
        Cursor a = this.hhp.a(EQ(str), null, Xv(str) + " AND msgSeq=?", new String[]{String.valueOf(j)}, null, null, null, 2);
        if (a.moveToFirst()) {
            auVar.b(a);
        }
        a.close();
        return auVar;
    }

    public final au H(String str, long j) {
        au auVar = new au();
        Cursor a = this.hhp.a(EQ(str), null, "createTime=? AND" + Xv(str), new String[]{String.valueOf(j)}, null, null, null, 2);
        if (a.moveToFirst()) {
            auVar.b(a);
        }
        a.close();
        return auVar;
    }

    public final Cursor Ev(String str) {
        return this.hhp.query(EQ(str), new String[]{"createTime", "msgId"}, Xv(str), null, "createTime", null, "createTime ASC");
    }

    public final List<au> I(String str, long j) {
        List<au> arrayList = new ArrayList();
        String str2 = "Select * From " + EQ(str) + " Where " + Xv(str) + " AND createTime < ? and not ( type = 10000 and isSend != 2 ) " + " Order By createTime Desc Limit 11";
        Cursor a = this.hhp.a(str2, new String[]{String.valueOf(j)}, 2);
        while (a.moveToNext()) {
            au auVar = new au();
            auVar.b(a);
            arrayList.add(auVar);
        }
        a.close();
        return arrayList;
    }

    public final List<au> J(String str, long j) {
        List<au> arrayList = new ArrayList();
        String str2 = "Select * From " + EQ(str) + " Where " + Xv(str) + " AND createTime > ? and not ( type = 10000 and isSend != 2 ) " + " Order By createTime Desc Limit 11" + ";";
        Cursor a = this.hhp.a(str2, new String[]{String.valueOf(j)}, 2);
        while (a.moveToNext()) {
            au auVar = new au();
            auVar.b(a);
            arrayList.add(auVar);
        }
        a.close();
        return arrayList;
    }

    private String Xv(String str) {
        String EQ = EQ(str);
        if (this.xzy && EQ.equals("message")) {
            return " talkerId=" + Xw(str) + " ";
        }
        return " talker= '" + bh.ot(str) + "' ";
    }

    private long Xw(String str) {
        long WP = this.kpL.WP(str);
        if (WP < 0) {
            x xVar = new x(str);
            xVar.setType(2);
            this.kpL.R(xVar);
            WP = this.kpL.WP(str);
        }
        if (!com.tencent.mm.sdk.a.b.ceM()) {
            x.i("MicroMsg.MsgInfoStorage", "getTalkerIdByTalkerName:%s id:%s needinsert:%s [%s]", str, Long.valueOf(WP), Boolean.valueOf(r2), bh.cgy());
        }
        return WP;
    }

    public final ArrayList<au> aZp() {
        ArrayList<au> arrayList = new ArrayList();
        Cursor a = this.hhp.a("message", null, "createTime>=? AND status=? AND isSend=?", new String[]{String.valueOf(System.currentTimeMillis() - 172800000), "5", "1"}, null, null, "createTime ASC", 2);
        while (a.moveToNext()) {
            cf auVar = new au();
            auVar.b(a);
            if (!(((!auVar.cjv() ? 1 : 0) & 1) == 0 || x.Wx(auVar.field_talker) || x.Wz(auVar.field_talker) || x.gy(auVar.field_talker))) {
                arrayList.add(auVar);
            }
        }
        a.close();
        return arrayList;
    }

    public final void G(ArrayList<Long> arrayList) {
        long dz = this.hhp.dz(-1);
        try {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                long longValue = ((Long) it.next()).longValue();
                au dH = dH(longValue);
                dH.fb(dH.gjE | 32);
                x.d("MicroMsg.MsgInfoStorage", "msgId:%d, setOmitFailResend", Long.valueOf(longValue));
                a(longValue, dH);
            }
        } finally {
            this.hhp.fS(dz);
        }
    }

    public final boolean K(String str, long j) {
        return H(str, j).field_msgId > 0;
    }

    public final int c(String str, long j, int i) {
        String str2 = "SELECT * FROM " + EQ(str) + " WHERE" + Xv(str) + "AND createTime < " + j + " ORDER BY createTime ASC LIMIT -1 OFFSET " + i;
        Cursor a = this.hhp.a(str2, null, 0);
        int count = a.getCount();
        a.close();
        x.d("MicroMsg.MsgInfoStorage", "getPositionByCreateTime talk:" + str + " time:" + j + " count " + count + " [" + str2 + "]");
        return count;
    }

    public final au Ew(String str) {
        au auVar = new au();
        Cursor a = this.hhp.a(EQ(str), null, Xv(str), null, null, null, "msgSvrId  DESC limit 1 ", 2);
        if (a.moveToFirst()) {
            auVar.b(a);
        }
        a.close();
        return auVar;
    }

    public final au Ex(String str) {
        if (bh.ov(str)) {
            return null;
        }
        au auVar = new au();
        Cursor a = this.hhp.a("select * from " + EQ(str) + " where" + Xv(str) + "order by createTime DESC limit 1", null, 2);
        if (a.moveToFirst()) {
            auVar.b(a);
        }
        a.close();
        return auVar;
    }

    public final au dk(String str, String str2) {
        if (bh.ov(str)) {
            x.e("MicroMsg.MsgInfoStorage", "getLastMsg failed : talker:%s", str);
            return null;
        }
        cf auVar = new au();
        Cursor a = this.hhp.a("select * from " + EQ(str) + " where" + Xv(str) + str2 + " order by createTime DESC limit 1", null, 2);
        if (a.moveToFirst()) {
            auVar.b(a);
        }
        a.close();
        x.i("MicroMsg.MsgInfoStorage", "getLastMsg talker:%s msgid:%d", str, Long.valueOf(auVar.field_msgId));
        return auVar;
    }

    public final au Ey(String str) {
        if (bh.ov(str)) {
            return null;
        }
        au auVar = new au();
        Cursor a = this.hhp.a("select * from " + EQ(str) + " where" + Xv(str) + "and isSend = 0" + "  order by createTime DESC limit 1", null, 2);
        if (a.moveToFirst()) {
            auVar.b(a);
        }
        a.close();
        return auVar;
    }

    public final List<au> bw(String str, int i) {
        List<au> arrayList = new ArrayList();
        Assert.assertTrue(this.xzA != null);
        Cursor a = this.hhp.a("SELECT * FROM " + EQ(str) + " WHERE" + Xv(str) + "AND status = 3" + " AND type <> 10000" + " ORDER BY createTime DESC LIMIT " + i, null, 2);
        while (a.moveToNext()) {
            au auVar = new au();
            auVar.b(a);
            arrayList.add(auVar);
        }
        a.close();
        return arrayList;
    }

    public final au su(int i) {
        if (this.xzA == null) {
            x.e("MicroMsg.MsgInfoStorage", "getLastMsg failed lstTable is null");
            return null;
        }
        au auVar = new au();
        long j = 0;
        for (int i2 = 0; i2 < this.xzA.size(); i2++) {
            if ((((b) this.xzA.get(i2)).ooR & i) != 0) {
                Cursor a = this.hhp.a("select * from " + ((b) this.xzA.get(i2)).name + "  order by createTime DESC limit 1", null, 2);
                if (a.moveToFirst()) {
                    long j2 = a.getLong(a.getColumnIndex("createTime"));
                    if (j < j2) {
                        auVar.b(a);
                        j = j2;
                    }
                }
                a.close();
            }
        }
        return auVar;
    }

    public final au Ez(String str) {
        if (this.xzA == null) {
            x.e("MicroMsg.MsgInfoStorage", "getLastMsg failed lstTable is null");
            return null;
        }
        String str2;
        au auVar = new au();
        if (bh.ov(str)) {
            str2 = "";
        } else {
            str2 = str.replaceFirst("and", "where");
        }
        long j = 0;
        for (int i = 0; i < this.xzA.size(); i++) {
            if ((((b) this.xzA.get(i)).ooR & 8) != 0) {
                Cursor a = this.hhp.a("select * from " + ((b) this.xzA.get(i)).name + str2 + "  order by createTime DESC limit 1", null, 2);
                if (a.moveToFirst()) {
                    long j2 = a.getLong(a.getColumnIndex("createTime"));
                    if (j < j2) {
                        auVar.b(a);
                        j = j2;
                    }
                }
                a.close();
            }
        }
        return auVar;
    }

    public final List<au> aZq() {
        List<au> arrayList = new ArrayList();
        Assert.assertTrue(this.xzA != null);
        List<au> arrayList2 = new ArrayList();
        for (int i = 0; i < this.xzA.size(); i++) {
            Cursor a = this.hhp.a(((b) this.xzA.get(i)).name, null, "status=1 and isSend=1", null, null, null, "createTime DESC ", 2);
            while (a.moveToNext()) {
                cf auVar = new au();
                auVar.b(a);
                if (auVar.cjg() || auVar.cjf() || auVar.aNe() || auVar.cjq()) {
                    if (ba.Hw() - auVar.field_createTime > 600000) {
                        arrayList2.add(auVar);
                    } else {
                        arrayList.add(auVar);
                    }
                }
            }
            a.close();
        }
        if (arrayList2.size() > 0) {
            long dz = this.hhp.dz(-1);
            for (au auVar2 : arrayList2) {
                x.i("MicroMsg.MsgInfoStorage", "Set msg timtout : id:%d time:%d talker:%s content:%s", Long.valueOf(auVar2.field_msgId), Long.valueOf(auVar2.field_createTime), auVar2.field_talker, bh.VT(auVar2.field_content));
                auVar2.eQ(5);
                a(auVar2.field_msgId, auVar2);
            }
            this.hhp.fS(dz);
        }
        return arrayList;
    }

    public final List<au> bx(String str, int i) {
        List<au> arrayList = new ArrayList();
        Assert.assertTrue(this.xzA != null);
        Cursor a = this.hhp.a("SELECT * FROM " + EQ(str) + " WHERE" + Xv(str) + "AND isSend = 0" + " ORDER BY createTime DESC LIMIT " + i, null, 2);
        while (a.moveToNext()) {
            au auVar = new au();
            auVar.b(a);
            if (auVar.cjg()) {
                arrayList.add(auVar);
            }
        }
        a.close();
        return arrayList;
    }

    public final List<au> K(String str, int i, int i2) {
        List<au> arrayList = new ArrayList();
        x.d("MicroMsg.MsgInfoStorage", "getAppMsgTypeList sql=%s", "SELECT * FROM " + EQ(str) + " WHERE type = 49 ORDER BY createTime" + " DESC LIMIT " + i + " , " + i2);
        Cursor a = this.hhp.a(r1, null, 2);
        while (a.moveToNext()) {
            au auVar = new au();
            auVar.b(a);
            if (auVar.aNc()) {
                arrayList.add(auVar);
            }
        }
        a.close();
        return arrayList;
    }

    public final int P(au auVar) {
        int i = 0;
        if (!(auVar == null || bh.ov(auVar.field_talker))) {
            Cursor a = this.hhp.a("SELECT count(msgId) FROM " + EQ(auVar.field_talker) + " WHERE" + Xv(auVar.field_talker) + "AND isSend = 0" + " AND msgId >= " + auVar.field_msgId + " ORDER BY createTime DESC", null, 2);
            if (a.moveToFirst()) {
                i = a.getInt(0);
            }
            a.close();
        }
        return i;
    }

    private static String Xx(String str) {
        if (bh.ov(str)) {
            return null;
        }
        try {
            Map y = bi.y(str, "msgsource");
            if (y == null || y.isEmpty()) {
                return null;
            }
            return (String) y.get(".msgsource.bizmsg.msgcluster");
        } catch (Throwable e) {
            x.e("MicroMsg.MsgInfoStorage", "exception:%s", bh.i(e));
            x.e("MicroMsg.MsgInfoStorage", "Exception in getMsgcluster, %s", e.getMessage());
            return null;
        }
    }

    private static void af(au auVar) {
        if (auVar != null && auVar.aNc()) {
            try {
                String str = auVar.field_content;
                int indexOf = str.indexOf("<msg>");
                if (indexOf > 0 && indexOf < str.length()) {
                    str = str.substring(indexOf).trim();
                }
                Map y = bi.y(str, "msg");
                if (y != null && y.size() > 0) {
                    auVar.dU(ax.at(y));
                }
            } catch (Exception e) {
                x.e("MicroMsg.MsgInfoStorage", e.getMessage());
            }
        }
    }

    public final long Q(au auVar) {
        return b(auVar, false);
    }

    public final long b(au auVar, boolean z) {
        if (auVar == null || bh.ov(auVar.field_talker)) {
            com.tencent.mm.plugin.report.d.pPH.a(111, 250, 1, false);
            String str = "MicroMsg.MsgInfoStorage";
            String str2 = "Error insert message msg:%s talker:%s";
            Object[] objArr = new Object[2];
            objArr[0] = auVar;
            objArr[1] = auVar == null ? "-1" : auVar.field_talker;
            x.e(str, str2, objArr);
            return -1;
        }
        x.d("MicroMsg.MsgInfoStorage", "insert lockForSync[%b], message seq[%d]", Boolean.valueOf(this.xzK), Long.valueOf(auVar.field_msgSeq));
        String str3 = null;
        ba.b hT = ba.hT(auVar.gjF);
        if (hT != null) {
            str3 = hT.hgF;
        }
        if (s.hj(str3)) {
            x.d("MicroMsg.MsgInfoStorage", "msgCluster = %s", str3);
            if (auVar.getType() == 436207665) {
                x.w("MicroMsg.MsgInfoStorage", "protect:c2c msg should not here");
                return -1;
            }
            auVar.dS("notifymessage");
        }
        b XB = XB(auVar.field_talker);
        if (XB == null) {
            com.tencent.mm.plugin.report.d.pPH.a(111, 249, 1, false);
            x.e("MicroMsg.MsgInfoStorage", "Error insert message getTableByTalker failed. talker:%s", auVar.field_talker);
            return -1;
        }
        XB.aZw();
        auVar.ao(XB.hzX);
        Assert.assertTrue(String.format("check table name from id:%d table:%s getTableNameByLocalId:%s", new Object[]{Long.valueOf(auVar.field_msgId), XB, fR(auVar.field_msgId)}), XB.name.equals(fR(auVar.field_msgId)));
        if (auVar.field_msgSvrId != 0) {
            auVar.gjJ = 1;
            auVar.gfw = true;
        }
        for (e a : this.xzz) {
            if (!a.a(auVar, hT)) {
                x.e("MicroMsg.MsgInfoStorage", "Error dealMsgSource. talker:%s ,msgSouce:%s", auVar.field_talker, auVar.gjF);
                return -1;
            }
        }
        af(auVar);
        if (XB.name.equals("message")) {
            auVar.field_talkerId = (int) Xw(auVar.field_talker);
            auVar.gjp = true;
        }
        x.i("MicroMsg.MsgInfoStorage", "insert:%d talker:%s id:%d type:%d status:%d svrid:%d msgseq:%d flag:%d create:%d issend:%d lockforsync[%s,%d]", Long.valueOf(this.hhp.a(XB.name, "msgId", auVar.vI(), z)), auVar.field_talker, Long.valueOf(auVar.field_msgId), Integer.valueOf(auVar.getType()), Integer.valueOf(auVar.field_status), Long.valueOf(auVar.field_msgSvrId), Long.valueOf(auVar.field_msgSeq), Integer.valueOf(auVar.field_flag), Long.valueOf(auVar.field_createTime), Integer.valueOf(auVar.field_isSend), this.xzL, Long.valueOf(bh.bz(this.xzM)));
        if (this.hhp.a(XB.name, "msgId", auVar.vI(), z) == -1) {
            com.tencent.mm.plugin.report.d.pPH.a(111, 248, 1, false);
            x.e("MicroMsg.MsgInfoStorage", "insert failed svrid:%d ret:%d", Long.valueOf(auVar.field_msgSvrId), Long.valueOf(r10));
            return -1;
        }
        if (this.xzK && bh.bz(this.xzM) > 2000 && auVar.field_isSend == 1 && auVar.field_status == 1) {
            x.w("MicroMsg.MsgInfoStorage", "insert this fucking tag[%s] lockForSync too long:%d force to release Now.", this.xzL, Long.valueOf(bh.bz(this.xzM)));
            Eu(this.xzL);
        }
        c.c cVar;
        if (this.xzK) {
            Object obj;
            str3 = null;
            if (e.xmt != null) {
                str3 = e.xmt.F(auVar);
            }
            if (bh.ov(str3)) {
                obj = auVar.field_talker;
            } else {
                str = str3;
            }
            cVar = null;
            if (this.xzJ.containsKey(obj)) {
                cVar = (c.c) this.xzJ.get(obj);
            }
            if (cVar == null) {
                cVar = new c.c(auVar.field_talker, "insert", auVar);
            } else {
                cVar.ooV.add(auVar);
            }
            if (c.c.T(auVar)) {
                cVar.ooW++;
            }
            cVar.ooX++;
            this.xzJ.put(obj, cVar);
        } else {
            cVar = new c.c(auVar.field_talker, "insert", auVar);
            if (c.c.T(auVar)) {
                cVar.ooW = 1;
            }
            cVar.ooX = 1;
            doNotify();
            a(cVar);
        }
        return auVar.field_msgId;
    }

    public final int dI(long j) {
        cf dH = dH(j);
        String str = dH.field_talker;
        this.xzH.j((int) (bh.Wo() / 86400), dH.field_msgSvrId, dH.field_createTime / 1000);
        int delete = this.hhp.delete(fR(j), "msgId=?", new String[]{String.valueOf(j)});
        if (delete != 0) {
            Wc("delete_id " + j);
            c.c cVar = new c.c(str, "delete", 1);
            cVar.ooZ = j;
            cVar.kGB = dH.field_bizChatId;
            a(cVar);
        } else {
            com.tencent.mm.plugin.report.d.pPH.a(111, 245, 1, false);
        }
        return delete;
    }

    public final List<au> EA(String str) {
        List<au> list = null;
        Cursor a = this.hhp.a("select * from " + str, null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                list = new ArrayList();
                do {
                    au auVar = new au();
                    auVar.b(a);
                    list.add(auVar);
                } while (a.moveToNext());
            }
            a.close();
        }
        return list;
    }

    public final long L(String str, long j) {
        String str2 = "select createTime from " + EQ(str) + " where msgId = " + j;
        long j2 = 0;
        Cursor a = this.hhp.a(str2, null, 2);
        if (a.moveToFirst()) {
            j2 = a.getLong(0);
        }
        a.close();
        return j2;
    }

    public final List<au> c(String str, long j, boolean z) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.MsgInfoStorage", new StringBuilder("getImgMessage fail, argument is invalid, limit = 10").toString());
            return null;
        }
        long L = L(str, j);
        if (L == 0) {
            x.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, msg is null");
            return null;
        }
        String str2;
        List<au> arrayList = new ArrayList();
        if (z) {
            str2 = "select * from " + EQ(str) + " where" + Xv(str) + "AND type IN (3,39,13,43,62,44,268435505) AND " + "createTime > " + L + "  order by createTime ASC limit 10";
        } else {
            str2 = "select * from " + EQ(str) + " where" + Xv(str) + "AND type IN (3,39,13,43,62,44,268435505) AND " + "createTime < " + L + "  order by createTime DESC limit 10";
        }
        Cursor a = this.hhp.a(str2, null, 2);
        while (a.moveToNext()) {
            au auVar = new au();
            auVar.b(a);
            arrayList.add(auVar);
        }
        if (!z) {
            Collections.reverse(arrayList);
        }
        a.close();
        return arrayList;
    }

    public final Cursor L(String str, int i, int i2) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
            return null;
        }
        return this.hhp.a("select * from ( select * from " + EQ(str) + " where" + Xv(str) + " AND type IN (3,39,13,43,62,44,268435505)  order by " + "createTime DESC limit " + i2 + " OFFSET " + i + ") order by createTime ASC ", null, 2);
    }

    public final Cursor k(String str, long j, long j2) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
            return null;
        }
        return this.hhp.a("select * from " + EQ(str) + " where" + Xv(str) + "AND type IN (3,39,13,43,62,44,268435505) AND " + "createTime >= " + j + " AND createTime< " + j2 + " order by createTime ASC", null, 2);
    }

    public final Cursor EB(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
            return null;
        }
        String EQ = EQ(str);
        Cursor a = this.hhp.a("select * from " + EQ + " " + Xy(EQ) + " where" + Xv(str) + "AND type IN (3,39,13,43,62,44,49,268435505)  order by " + "createTime", null, 0);
        x.d("MicroMsg.MsgInfoStorage", "all time: %d, sql: %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), EQ);
        return a;
    }

    public final Cursor by(String str, int i) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
            return null;
        }
        return this.hhp.a("select * from " + EQ(str) + " where" + Xv(str) + " AND type = 49  order by createTime" + " DESC limit " + i + " OFFSET 0", null, 0);
    }

    public final Cursor bz(String str, int i) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
            return null;
        }
        StringBuilder append = new StringBuilder("select msgId,msgSvrId,createTime,content,isSend from ").append(EQ(str)).append(" where").append(Xv(str)).append(" AND ");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" (type = 49");
        stringBuilder.append(" or type = 553648177").append(") ");
        return this.hhp.a(append.append(stringBuilder.toString()).append("  order by createTime DESC limit 100").append(" OFFSET ").append(i).toString(), null, 0);
    }

    public final void b(String str, String str2, String[] strArr) {
        String str3 = "SELECT msgSvrId,createTime FROM " + str + " WHERE createTime > " + ((bh.Wo() - 172800) * 1000);
        if (!bh.ov(str2)) {
            str3 = str3 + " AND " + str2;
        }
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        Cursor a = this.hhp.a(str3, strArr, 2);
        if (a.moveToFirst()) {
            do {
                long j = a.getLong(1) / 1000;
                arrayList.add(Integer.valueOf(a.getInt(0)));
                arrayList2.add(Long.valueOf(j));
            } while (a.moveToNext());
            this.xzH.i(arrayList, arrayList2);
        }
        a.close();
    }

    public final boolean dJ(long j) {
        return this.xzH.fP(j);
    }

    public final void EC(String str) {
        b(str, "", null);
        if (this.hhp.fx(str, "delete from " + str)) {
            Wc("delete_all " + str);
        } else {
            com.tencent.mm.plugin.report.d.pPH.a(111, 247, 1, false);
        }
    }

    public final int M(String str, long j) {
        cf F = F(str, j);
        this.xzH.j((int) (bh.Wo() / 86400), F.field_msgSvrId, F.field_createTime / 1000);
        int delete = this.hhp.delete(EQ(str), "msgSvrId=?", new String[]{String.valueOf(j)});
        if (delete != 0) {
            doNotify();
            a(new c.c(str, "delete", 1));
        } else {
            com.tencent.mm.plugin.report.d.pPH.a(111, 246, 1, false);
        }
        return delete;
    }

    public final int ED(String str) {
        x.w("MicroMsg.MsgInfoStorage", "deleteByTalker :%s  stack:%s", str, ai.cfI());
        b(EQ(str), Xv(str), null);
        int delete = this.hhp.delete(EQ(str), Xv(str), null);
        if (delete != 0) {
            Wc("delete_talker " + str);
            c.c cVar = new c.c(str, "delete", delete);
            cVar.ooZ = -1;
            a(cVar);
        }
        return delete;
    }

    public final int N(String str, long j) {
        String str2 = Xv(str) + " and createTime <= " + j;
        b(EQ(str), str2, null);
        int delete = this.hhp.delete(EQ(str), str2, null);
        if (delete != 0) {
            Wc("delete_talker " + str);
            c.c cVar = new c.c(str, "delete", delete);
            cVar.ooZ = -1;
            a(cVar);
        }
        return delete;
    }

    public final int bA(String str, int i) {
        x.w("MicroMsg.MsgInfoStorage", "deleteByTalkerFrom :%s  :%d stack:%s", str, Integer.valueOf(i), ai.cfI());
        Assert.assertTrue(str.equals(F(str, (long) i).field_talker));
        b(EQ(str), "createTime<=? AND" + Xv(str), new String[]{r0.field_createTime});
        int delete = this.hhp.delete(EQ(str), "createTime<=? AND" + Xv(str), new String[]{r0.field_createTime});
        if (delete != 0) {
            doNotify();
            a(new c.c(str, "delete", delete));
        }
        return delete;
    }

    public final boolean EE(String str) {
        x.w("MicroMsg.MsgInfoStorage", "deleteMessageEndByName nameTag:%s  stack:%s", str, ai.cfI());
        b(EQ(str), " talker like '%" + str + "'", null);
        boolean fx = this.hhp.fx(EQ(str), "delete from " + EQ(str) + " where talker like '%" + str + "'");
        if (fx) {
            doNotify();
        }
        return fx;
    }

    public final Cursor bB(String str, int i) {
        Assert.assertTrue(str.equals(F(str, (long) i).field_talker));
        return this.hhp.query(EQ(str), null, "createTime<=? AND" + Xv(str), new String[]{r5.field_createTime}, null, null, null);
    }

    public final void a(long j, au auVar) {
        if (auVar.cjc()) {
            if (s.hj(Xx(auVar.gjF))) {
                x.d("MicroMsg.MsgInfoStorage", "msgCluster = %s", Xx(auVar.gjF));
                auVar.dS("notifymessage");
            }
        }
        af(auVar);
        if (this.hhp.update(fR(j), auVar.vI(), "msgId=?", new String[]{String.valueOf(j)}) != 0) {
            doNotify();
            a(new c.c(auVar.field_talker, "update", auVar));
            return;
        }
        com.tencent.mm.plugin.report.d.pPH.a(111, 244, 1, false);
    }

    public final void R(au auVar) {
        if (auVar != null && auVar.field_status != 4) {
            auVar.eQ(4);
            String fR = fR(auVar.field_msgId);
            if (fR != null && fR.length() > 0) {
                if (this.hhp.update(fR, auVar.vI(), "msgId=?", new String[]{auVar.field_msgId}) != 0) {
                    doNotify();
                    a(new c.c(auVar.field_talker, "update", auVar, -1));
                }
            }
        }
    }

    public final void b(long j, au auVar) {
        Assert.assertTrue("no talker set when update by svrid", bh.ou(auVar.field_talker).length() > 0);
        if (auVar.cjc()) {
            if (s.hj(Xx(auVar.gjF))) {
                x.d("MicroMsg.MsgInfoStorage", "msgCluster = %s", Xx(auVar.gjF));
                auVar.dS("notifymessage");
            }
        }
        af(auVar);
        if (this.hhp.update(EQ(auVar.field_talker), auVar.vI(), "msgSvrId=?", new String[]{String.valueOf(j)}) != 0) {
            doNotify();
            a(new c.c(auVar.field_talker, "update", auVar));
            return;
        }
        com.tencent.mm.plugin.report.d.pPH.a(111, 243, 1, false);
    }

    public final int EF(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadInfo.STATUS, Integer.valueOf(4));
        int update = this.hhp.update(EQ(str), contentValues, Xv(str) + "AND isSend=? AND status" + "!=? ", new String[]{str, "0", "4"});
        if (update != 0) {
            doNotify();
            a(new c.c(str, "update", null));
        }
        return update;
    }

    public final int S(au auVar) {
        int i = 0;
        if (auVar != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("content", auVar.field_content);
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(auVar.field_status));
            i = this.hhp.update(fR(auVar.field_msgId), contentValues, "msgId=?", new String[]{String.valueOf(auVar.field_msgId)});
            if (i != 0) {
                doNotify();
                a(new c.c(auVar.field_talker, "update", auVar));
            }
        }
        return i;
    }

    public final Cursor EG(String str) {
        return this.hhp.query(EQ(str), null, Xv(str), null, null, null, "createTime ASC ");
    }

    public final Cursor e(String str, int i, long j) {
        return this.hhp.a("SELECT * FROM " + EQ(str) + " WHERE" + Xv(str) + " AND createTime <= " + j + " order by createTime ASC limit " + i, null, 0);
    }

    public final Cursor dl(String str, String str2) {
        return this.hhp.a(("SELECT * FROM " + EQ(str) + " WHERE" + Xv(str) + "AND content LIKE '%" + str2 + "%' AND type = 1") + " ORDER BY createTime DESC", null, 0);
    }

    public final Cursor f(String str, int i, long j) {
        x.i("MicroMsg.MsgInfoStorage", "getInitCursor1 getCursor talk:%s limitCount:%d [%s]", str, Integer.valueOf(i), "SELECT * FROM ( SELECT * FROM " + EQ(str) + " WHERE" + Xv(str) + (j > 0 ? " AND createTime > " + j : "") + " ORDER BY createTime DESC LIMIT " + i + ") ORDER BY createTime ASC");
        return this.hhp.a("SELECT * FROM ( SELECT * FROM " + EQ(str) + " WHERE" + Xv(str) + (j > 0 ? " AND createTime > " + j : "") + " ORDER BY createTime DESC LIMIT " + i + ") ORDER BY createTime ASC", null, 0);
    }

    public final Cursor g(String str, int i, long j) {
        x.i("MicroMsg.MsgInfoStorage", "summerbadcr getInitCursor2 getCursor talk:%s limitCount:%d [%s]", str, Integer.valueOf(i), "SELECT * FROM ( SELECT * FROM ( SELECT * FROM " + EQ(str) + " WHERE" + Xv(str) + "ORDER BY createTime DESC LIMIT " + i + ") ORDER BY createTime ASC ) WHERE createTime" + " <= " + j);
        return this.hhp.a("SELECT * FROM ( SELECT * FROM ( SELECT * FROM " + EQ(str) + " WHERE" + Xv(str) + "ORDER BY createTime DESC LIMIT " + i + ") ORDER BY createTime ASC ) WHERE createTime" + " <= " + j, null, 0);
    }

    public final Cursor EH(String str) {
        return this.hhp.query(EQ(str), null, "isSend=? AND" + Xv(str) + "AND status!=?", new String[]{"0", "4"}, null, null, null);
    }

    public final Cursor bC(String str, int i) {
        return this.hhp.query(EQ(str), null, "isSend=? AND" + Xv(str) + "AND status!=?  order by msgId" + " DESC limit " + i, new String[]{"0", "4"}, null, null, null);
    }

    public final Cursor aZr() {
        return this.hhp.query("message", new String[]{"talker", "count(*) as unReadCount"}, "isSend=? AND status!=?", new String[]{"0", "4"}, "talker", null, null);
    }

    public final au.c EI(String str) {
        au.c cVar = (au.c) this.xzB.get(Integer.valueOf(str.hashCode()));
        if (cVar != null) {
            return cVar;
        }
        cVar = au.c.Xt(str);
        this.xzB.l(Integer.valueOf(str.hashCode()), cVar);
        return cVar;
    }

    public final d EJ(String str) {
        d dVar = (d) this.xzC.get(Integer.valueOf(str.hashCode()));
        if (dVar != null) {
            return dVar;
        }
        dVar = d.Xu(str);
        this.xzC.l(Integer.valueOf(str.hashCode()), dVar);
        return dVar;
    }

    public final a EK(String str) {
        a aVar = null;
        if (bh.ov(str) || this.xzD == null) {
            x.e("MicroMsg.MsgInfoStorage", "input text null ???? %B", Boolean.valueOf(bh.ov(str)));
            x.e("MicroMsg.MsgInfoStorage", "[arthurdan.FriendContentCrash] Fatal error!!! cachesForFriend is null!");
        } else {
            aVar = (a) this.xzD.get(Integer.valueOf(str.hashCode()));
        }
        if (aVar == null) {
            aVar = a.Xr(str);
            if (this.xzD != null) {
                this.xzD.l(Integer.valueOf(bh.az(str, "").hashCode()), aVar);
            }
        }
        return aVar;
    }

    public final au.b EL(String str) {
        au.b bVar = (au.b) this.xzE.get(Integer.valueOf(str.hashCode()));
        if (bVar != null) {
            return bVar;
        }
        bVar = au.b.Xs(str);
        this.xzE.l(Integer.valueOf(str.hashCode()), bVar);
        return bVar;
    }

    public final Cursor aZs() {
        boolean z;
        if (this.xzA.size() > 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        return this.hhp.query(((b) this.xzA.get(0)).name, null, "msgId=?", new String[]{"-1"}, null, null, null);
    }

    public final int EM(String str) {
        int i = 0;
        if (EN(str)) {
            int Xo = this.kpN.Xo(str);
            if (Xo > 0) {
                x.i("MicroMsg.MsgInfoStorage", "getMsgCount conversationStorage.getMsgCountByUsername count:%d", Integer.valueOf(Xo));
                return Xo;
            }
            x.i("MicroMsg.MsgInfoStorage", "getMsgCount contactMsgCount is 0 ,go normal %s", str);
        } else {
            if ("appbrandmessage".equals(EQ(str))) {
                Cursor a = this.hhp.a("SELECT COUNT(*) FROM " + EQ(str) + " WHERE" + Xv(str), null, 0);
                if (a.moveToLast()) {
                    i = a.getInt(0);
                }
                a.close();
                return i;
            }
        }
        return EO(str);
    }

    public final boolean EN(String str) {
        return "message".equals(EQ(str));
    }

    public final int EO(String str) {
        int i;
        Cursor a = this.hhp.a("SELECT COUNT(*) FROM " + EQ(str) + " " + (this.xzy ? "INDEXED BY messageTalkerIdStatusIndex" : "INDEXED BY messageTalkerStatusIndex") + " WHERE" + Xv(str), null, 2);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        } else {
            i = 0;
        }
        a.close();
        return i;
    }

    private String Xy(String str) {
        if (str == null || !str.equals("message")) {
            return "";
        }
        if (this.xzy) {
            return "INDEXED BY messageTaklerIdTypeCreateTimeIndex";
        }
        return "INDEXED BY messageCreateTaklerTypeTimeIndex";
    }

    public final int bD(String str, int i) {
        int i2 = 0;
        Cursor a = this.hhp.a("SELECT COUNT(*) FROM " + EQ(str) + " WHERE" + Xv(str) + "AND type = " + i, null, 2);
        if (a.moveToFirst()) {
            i2 = a.getInt(0);
        }
        a.close();
        return i2;
    }

    public final int l(String str, long j, long j2) {
        int i = 0;
        Cursor a = this.hhp.a("SELECT COUNT(*) FROM " + EQ(str) + " WHERE" + Xv(str) + "AND type = 50" + " AND createTime >= " + j + " AND createTime <= " + j2 + " LIMIT 1", null, 2);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        }
        a.close();
        return i;
    }

    public final int EP(String str) {
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder("SELECT COUNT(*) FROM ");
        String str2 = "username == null";
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(str2, z);
        String str3 = XB(str).name;
        Cursor a = this.hhp.a(stringBuilder.append(str3 + "  indexed by  " + str3 + "TalkerTypeIndex ").append(" WHERE talker= '").append(bh.ot(str)).append("' AND type IN (3,39,13,43,62,44,268435505)").toString(), null, 2);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        }
        a.close();
        return i;
    }

    public final int O(String str, long j) {
        int i = 0;
        cf dH = dH(j);
        if (dH.field_msgId == 0) {
            x.e("MicroMsg.MsgInfoStorage", "getCountEarlyThan fail, msg does not exist");
        } else {
            String EQ = EQ(str);
            Cursor a = this.hhp.a("SELECT COUNT(*) FROM " + EQ + " " + Xy(EQ) + " WHERE " + Xv(str) + "AND type IN (3,39,13,43,62,44,268435505) AND " + "createTime < " + dH.field_createTime, null, 2);
            if (a.moveToFirst()) {
                i = a.getInt(0);
            }
            a.close();
        }
        return i;
    }

    public final String P(String str, long j) {
        String str2 = null;
        int i = 0;
        cf dH = dH(j);
        if (dH.field_msgId == 0) {
            x.e("MicroMsg.MsgInfoStorage", "getCountEarlyThan fail, msg does not exist");
        } else {
            String EQ = EQ(str);
            Cursor a = this.hhp.a("EXPLAIN QUERY PLAN SELECT COUNT(*) FROM " + EQ + " " + Xy(EQ) + " WHERE" + Xv(str) + "AND type IN (3,39,13,43,62,44,268435505) AND " + "createTime < " + dH.field_createTime, null, 0);
            str2 = "";
            if (a.moveToFirst()) {
                while (i < a.getColumnCount()) {
                    str2 = str2 + a.getString(i) + " ";
                    i++;
                }
            }
            a.close();
        }
        return str2;
    }

    public final String aZt() {
        return "type IN (3,39,13,43,62,44,268435505)";
    }

    public final String aZu() {
        return "type IN (3,39,13,43,62,44,49,268435505)";
    }

    public final String EQ(String str) {
        String str2 = "username == null";
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(str2, z);
        return XB(str).name;
    }

    private b Xz(String str) {
        String str2 = "tableName == null";
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(str2, z);
        for (int i = 0; i < this.xzA.size(); i++) {
            if (str.equals(((b) this.xzA.get(i)).name)) {
                return (b) this.xzA.get(i);
            }
        }
        Assert.assertTrue("no table match", false);
        return null;
    }

    private String XA(String str) {
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(z);
        for (e Wq : this.xzz) {
            String Wq2 = Wq.Wq(str);
            if (!bh.ov(Wq2)) {
                return Wq2;
            }
        }
        return "message";
    }

    private b XB(String str) {
        String str2 = "username == null";
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(str2, z);
        return Xz(XA(str));
    }

    public final boolean dK(long j) {
        for (int i = 0; i < this.xzA.size(); i++) {
            if (((b) this.xzA.get(i)).dM(j)) {
                return true;
            }
        }
        return false;
    }

    private String fR(long j) {
        if (j == 0 || j == -1) {
            return null;
        }
        au.fQ(j);
        for (int i = 0; i < this.xzA.size(); i++) {
            if (((b) this.xzA.get(i)).dM(j)) {
                return ((b) this.xzA.get(i)).name;
            }
        }
        Assert.assertTrue(String.format("getTableNameByLocalId failed:%d", new Object[]{Long.valueOf(j)}), false);
        return null;
    }

    public final long ER(String str) {
        String str2 = "select createTime from message where" + Xv(str) + "order by createTime LIMIT 1 OFFSET 0";
        x.d("MicroMsg.MsgInfoStorage", "get first message create time: " + str2);
        Cursor a = this.hhp.a(str2, null, 2);
        if (a == null) {
            x.e("MicroMsg.MsgInfoStorage", "get first message create time failed: " + str);
            return -1;
        } else if (a.moveToFirst()) {
            long j = a.getLong(0);
            a.close();
            return j;
        } else {
            a.close();
            return -1;
        }
    }

    public final long ES(String str) {
        String str2 = "select createTime from message where" + Xv(str) + "order by createTime DESC LIMIT 1 ";
        x.d("MicroMsg.MsgInfoStorage", "get last message create time: " + str2);
        Cursor a = this.hhp.a(str2, null, 2);
        if (a == null) {
            x.e("MicroMsg.MsgInfoStorage", "get last message create time failed " + str);
            return -1;
        } else if (a.moveToFirst()) {
            long j = a.getLong(0);
            a.close();
            return j;
        } else {
            a.close();
            return -1;
        }
    }

    public final long ET(String str) {
        if (bh.ov(str)) {
            return 0;
        }
        String str2 = "select msgSeq from message where" + Xv(str) + "order by msgSeq DESC LIMIT 1 ";
        x.i("MicroMsg.MsgInfoStorage", "summerbadcr get last message msgseq: " + str2);
        Cursor a = this.hhp.a(str2, null, 2);
        if (a == null) {
            x.e("MicroMsg.MsgInfoStorage", "summerbadcr get last message msgseq failed " + str);
            return 0;
        } else if (a.moveToFirst()) {
            long j = a.getLong(0);
            a.close();
            return j;
        } else {
            a.close();
            return 0;
        }
    }

    public final au Q(String str, long j) {
        if (bh.ov(str)) {
            return null;
        }
        String str2 = "select * from message where" + Xv(str) + " and msgSeq > " + j + " order by msgSeq ASC LIMIT 1 ";
        x.i("MicroMsg.MsgInfoStorage", "summerbadcr getNewerMsgByMsgSeq: " + str2);
        Cursor a = this.hhp.a(str2, null, 0);
        if (a == null) {
            x.e("MicroMsg.MsgInfoStorage", "summerbadcr getNewerMsgByMsgSeq failed " + str);
            return null;
        } else if (a.moveToFirst()) {
            au auVar = new au();
            auVar.b(a);
            return auVar;
        } else {
            a.close();
            return null;
        }
    }

    public final au EU(String str) {
        if (bh.ov(str)) {
            return null;
        }
        x.i("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg talker[%s], onlyCache[%b]", str, Boolean.valueOf(false));
        Long l = (Long) this.xzG.get(str);
        au auVar;
        if (l == null || l.longValue() <= 0) {
            x.i("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg not hit cache");
            auVar = new au();
            long currentTimeMillis = System.currentTimeMillis();
            Cursor a = this.hhp.a("SELECT * FROM " + EQ(str) + " WHERE" + Xv(str) + "AND flag %2 = 1  ORDER BY msgSeq" + " DESC LIMIT 1 ", null, 2);
            x.d("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg take %dms, tid[%d]", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Long.valueOf(Thread.currentThread().getId()));
            if (a == null) {
                x.e("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg failed " + str);
                return auVar;
            }
            if (a.moveToFirst()) {
                auVar.b(a);
            }
            a.close();
            this.xzG.l(str, Long.valueOf(auVar.field_msgId));
            return auVar;
        }
        x.i("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg hit cache msgid[%d]", Long.valueOf(l.longValue()));
        auVar = dH(l.longValue());
        if ((auVar.field_flag & 1) != 0) {
            return auVar;
        }
        this.xzG.remove(str);
        return null;
    }

    public final int m(String str, long j, long j2) {
        if (j2 >= j) {
            long j3 = j2;
            j2 = j;
            j = j3;
        }
        x.d("MicroMsg.MsgInfoStorage", "talker %s, get count fromCreateTime %d, toCreateTime %d", str, Long.valueOf(j2), Long.valueOf(j));
        String str2 = "SELECT COUNT(msgId) FROM " + EQ(str) + " WHERE" + Xv(str) + "AND createTime >= " + j2 + " AND createTime <= " + j;
        x.d("MicroMsg.MsgInfoStorage", "get count sql: " + str2);
        Cursor a = this.hhp.a(str2, null, 2);
        if (a == null) {
            x.w("MicroMsg.MsgInfoStorage", "get count error, cursor is null");
            return 0;
        } else if (a.moveToFirst()) {
            x.d("MicroMsg.MsgInfoStorage", "result msg count %d", Integer.valueOf(a.getInt(0)));
            a.close();
            return a.getInt(0);
        } else {
            a.close();
            return 0;
        }
    }

    public final Cursor a(String str, long j, long j2, boolean z) {
        int i;
        if (j2 >= j) {
            long j3 = j2;
            j2 = j;
            j = j3;
        }
        StringBuilder append = new StringBuilder("SELECT * FROM ").append(EQ(str)).append(" WHERE").append(Xv(str)).append("AND createTime >= ").append(j2).append(" AND createTime <= ").append(j).append(" AND isSend=");
        if (z) {
            i = 1;
        } else {
            i = 0;
        }
        String stringBuilder = append.append(i).append(" LIMIT 1").toString();
        x.d("MicroMsg.MsgInfoStorage", "get cursor: " + stringBuilder);
        return this.hhp.a(stringBuilder, null, 0);
    }

    public final Cursor n(String str, long j, long j2) {
        if (j2 >= j) {
            long j3 = j2;
            j2 = j;
            j = j3;
        }
        String str2 = "SELECT * FROM " + EQ(str) + " WHERE" + Xv(str) + "AND createTime >= " + j2 + " AND createTime <= " + j + " ORDER BY createTime ASC ";
        x.d("MicroMsg.MsgInfoStorage", "get cursor: " + str2);
        return this.hhp.a(str2, null, 0);
    }

    public final Cursor b(String str, long j, long j2, int i) {
        if (j2 == 0) {
            String str2 = "SELECT * FROM " + EQ(str) + " WHERE" + Xv(str) + "AND createTime > " + j + " ORDER BY createTime ASC  LIMIT 50" + " OFFSET " + i;
            x.d("MicroMsg.MsgInfoStorage", "get cursor: " + str2);
            return this.hhp.a(str2, null, 0);
        }
        if (j2 >= j) {
            long j3 = j2;
            j2 = j;
            j = j3;
        }
        str2 = "SELECT * FROM " + EQ(str) + " WHERE" + Xv(str) + "AND createTime > " + j2 + " AND createTime < " + j + " ORDER BY createTime ASC  LIMIT 50" + " OFFSET " + i;
        x.d("MicroMsg.MsgInfoStorage", "get cursor: " + str2);
        return this.hhp.a(str2, null, 0);
    }

    public final int o(String str, long j, long j2) {
        int i = 0;
        if (j2 >= j) {
            long j3 = j2;
            j2 = j;
            j = j3;
        }
        Cursor a = this.hhp.a("SELECT * FROM " + EQ(str) + " WHERE" + Xv(str) + "AND createTime > " + j2 + " AND createTime < " + j, null, 2);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        }
        a.close();
        return i;
    }

    public final Cursor p(String str, long j, long j2) {
        if (j2 >= j) {
            long j3 = j2;
            j2 = j;
            j = j3;
        }
        String str2 = "SELECT * FROM " + EQ(str) + " WHERE" + Xv(str) + "AND createTime >= " + j2 + " AND createTime <= " + j;
        x.d("MicroMsg.MsgInfoStorage", "get cursor: " + str2);
        return this.hhp.a(str2, null, 0);
    }

    public final Cursor B(String str, String str2, int i) {
        x.d("MicroMsg.MsgInfoStorage", "getInitCursorByMember getCursor talk:%s member:%s,limitCount:%d [%s]", str, str2, Integer.valueOf(i), " SELECT * FROM " + EQ(str) + " WHERE" + Xv(str) + "AND content LIKE '" + str2 + "%' ORDER BY createTime DESC LIMIT " + i);
        return this.hhp.a(" SELECT * FROM " + EQ(str) + " WHERE" + Xv(str) + "AND content LIKE '" + str2 + "%' ORDER BY createTime DESC LIMIT " + i, null, 0);
    }

    public final Cursor bE(String str, int i) {
        x.d("MicroMsg.MsgInfoStorage", "[getInitCursorBySelf] getCursor talk:%s,limitCount:%d [%s]", str, Integer.valueOf(i), " SELECT * FROM " + EQ(str) + " WHERE" + Xv(str) + "AND isSend=1" + " ORDER BY createTime DESC LIMIT " + i);
        return this.hhp.a(" SELECT * FROM " + EQ(str) + " WHERE" + Xv(str) + "AND isSend=1" + " ORDER BY createTime DESC LIMIT " + i, null, 0);
    }

    public final long R(String str, long j) {
        x.d("MicroMsg.MsgInfoStorage", "get up inc create time, talker %s, fromCreateTime %d, targetIncCount %d", str, Long.valueOf(j), Integer.valueOf(18));
        x.d("MicroMsg.MsgInfoStorage", "get up inc msg create time sql: %s", "SELECT createTime FROM " + EQ(str) + " WHERE" + Xv(str) + "AND createTime < " + j + " ORDER BY createTime DESC  LIMIT 18");
        Cursor a = this.hhp.a(r0, null, 0);
        if (a == null) {
            x.w("MicroMsg.MsgInfoStorage", "get inc msg create time error, cursor is null");
            return j;
        } else if (a.moveToLast()) {
            x.d("MicroMsg.MsgInfoStorage", "result msg create time %d", Long.valueOf(a.getLong(0)));
            a.close();
            return a.getLong(0);
        } else {
            a.close();
            x.w("MicroMsg.MsgInfoStorage", "get result fail");
            return j;
        }
    }

    public final boolean a(long j, String str, String str2, String str3) {
        return this.hhp.fx(null, "UPDATE " + XA(str) + " SET transContent = '" + bh.ot(str2) + "', transBrandWording = '" + bh.ot(bh.ou(str3)) + "' WHERE msgId = " + j);
    }

    public final long S(String str, long j) {
        x.d("MicroMsg.MsgInfoStorage", "get down inc create time, talker %s, fromCreateTime %d, targetIncCount %d", str, Long.valueOf(j), Integer.valueOf(18));
        x.d("MicroMsg.MsgInfoStorage", "get down inc msg create time sql: %s", "SELECT createTime FROM " + EQ(str) + " WHERE" + Xv(str) + "AND createTime > " + j + " ORDER BY createTime ASC  LIMIT 18");
        Cursor a = this.hhp.a(r0, null, 0);
        if (a == null) {
            x.w("MicroMsg.MsgInfoStorage", "get down inc msg create time error, cursor is null");
            return j;
        } else if (a.moveToLast()) {
            x.d("MicroMsg.MsgInfoStorage", "result msg create time %d", Long.valueOf(a.getLong(0)));
            a.close();
            return a.getLong(0);
        } else {
            a.close();
            x.w("MicroMsg.MsgInfoStorage", "get result fail");
            return j;
        }
    }

    public final au[] bF(String str, int i) {
        if (str == null || str.length() == 0 || i <= 0) {
            x.e("MicroMsg.MsgInfoStorage", "getLastMsgList, invalid argument, talker = " + str + ", limit = " + i);
            return null;
        }
        Cursor a = this.hhp.a("select * from " + EQ(str) + " where" + Xv(str) + "order by createTime DESC limit " + i, null, 2);
        if (a.moveToFirst()) {
            ArrayList arrayList = new ArrayList();
            do {
                au auVar = new au();
                auVar.b(a);
                arrayList.add(auVar);
            } while (a.moveToNext());
            a.close();
            x.d("MicroMsg.MsgInfoStorage", "getLastMsgList, talker = " + str + ", limit = " + i + ", count = " + arrayList.size());
            Collections.reverse(arrayList);
            return (au[]) arrayList.toArray(new au[arrayList.size()]);
        }
        x.w("MicroMsg.MsgInfoStorage", "getLastMsgList, cursor is empty");
        a.close();
        return null;
    }

    public final LinkedList<au> dn(String str, String str2) {
        LinkedList<au> linkedList = null;
        Cursor a = this.hhp.a("message", null, "talker=? AND bizClientMsgId=?", new String[]{str, str2}, null, null, null, 2);
        if (a == null || !a.moveToFirst()) {
            x.e("MicroMsg.MsgInfoStorage", "getByBizClientMsgId fail");
        } else {
            linkedList = new LinkedList();
            do {
                au auVar = new au();
                auVar.b(a);
                linkedList.add(auVar);
            } while (a.moveToNext());
            a.close();
        }
        return linkedList;
    }

    public final void dL(long j) {
        this.xzH.a(0, j, 0, false);
    }

    public final List<au> EW(String str) {
        Throwable e;
        Cursor cursor = null;
        Cursor a;
        try {
            ArrayList arrayList = new ArrayList();
            a = this.hhp.a("message", null, "talker=? AND createTime>=? AND type IN (436207665,419430449)", new String[]{bh.ot(str), String.valueOf(System.currentTimeMillis() - 86400000)}, null, null, "createTime ASC", 2);
            while (a.moveToNext()) {
                try {
                    au auVar = new au();
                    auVar.b(a);
                    arrayList.add(auVar);
                } catch (Exception e2) {
                    e = e2;
                }
            }
            if (a != null) {
                a.close();
            }
            return arrayList;
        } catch (Exception e3) {
            e = e3;
            a = null;
            try {
                x.printErrStackTrace("MicroMsg.MsgInfoStorage", e, "getLastDayC2CMsgByTalker error: %s", e.getMessage());
                if (a != null) {
                    a.close();
                }
                return null;
            } catch (Throwable th) {
                e = th;
                cursor = a;
                if (cursor != null) {
                    cursor.close();
                }
                throw e;
            }
        } catch (Throwable th2) {
            e = th2;
            if (cursor != null) {
                cursor.close();
            }
            throw e;
        }
    }

    public final List<au> aZv() {
        Cursor a;
        Throwable e;
        try {
            ArrayList arrayList = new ArrayList();
            a = this.hhp.a("message", null, "createTime>=? AND type IN (436207665,419430449)", new String[]{String.valueOf(System.currentTimeMillis() - 86400000)}, null, null, "createTime ASC", 2);
            while (a.moveToNext()) {
                try {
                    au auVar = new au();
                    auVar.b(a);
                    arrayList.add(auVar);
                } catch (Exception e2) {
                    e = e2;
                }
            }
            if (a != null) {
                a.close();
            }
            return arrayList;
        } catch (Exception e3) {
            e = e3;
            a = null;
            try {
                x.printErrStackTrace("MicroMsg.MsgInfoStorage", e, "getLastDayC2CMsgByTalker error: %s", e.getMessage());
                if (a != null) {
                    a.close();
                }
                return null;
            } catch (Throwable th) {
                e = th;
                if (a != null) {
                    a.close();
                }
                throw e;
            }
        } catch (Throwable th2) {
            e = th2;
            a = null;
            if (a != null) {
                a.close();
            }
            throw e;
        }
    }

    public final long EX(String str) {
        if (bh.ov(str)) {
            return 0;
        }
        b Xz = Xz(str);
        if (Xz != null) {
            return Xz.hzX;
        }
        return 0;
    }

    public final Cursor d(String str, long j, int i) {
        Cursor cursor = null;
        try {
            cursor = this.hhp.a("select * from " + str + " where " + "type IN (3,39,13,43,62,44,49,268435505,34)" + " AND msgId >= " + j + "  order by msgId ASC  limit " + i, null, 0);
        } catch (Exception e) {
        }
        return cursor;
    }

    public final Cursor bG(String str, int i) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
            return null;
        }
        return this.hhp.a("select * from " + EQ(str) + " where" + Xv(str) + " AND type IN (436207665" + ",419430449)  order by createTime" + " DESC limit " + i + " OFFSET 0", null, 0);
    }
}
