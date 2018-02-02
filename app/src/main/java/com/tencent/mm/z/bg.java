package com.tencent.mm.z;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.by.h;
import com.tencent.mm.g.b.aj;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import com.tencent.wcdb.FileUtils;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class bg extends j {
    public static final String[] gJN = new String[]{"CREATE TABLE IF NOT EXISTS readerappnews1 ( tweetid text  PRIMARY KEY , time long  , type int  , name text  , title text  , url text  , shorturl text  , longurl text  , pubtime long  , sourcename text  , sourceicon text  , istop int  , cover text  , digest text  , reserved1 int  , reserved2 long  , reserved3 text  , reserved4 text  ) ", "CREATE TABLE IF NOT EXISTS readerappweibo ( tweetid text  PRIMARY KEY , time long  , type int  , name text  , title text  , url text  , shorturl text  , longurl text  , pubtime long  , sourcename text  , sourceicon text  , istop int  , cover text  , digest text  , reserved1 int  , reserved2 long  , reserved3 text  , reserved4 text  ) ", "CREATE INDEX IF NOT EXISTS  readerapptime ON readerappnews1 ( time )", "CREATE INDEX IF NOT EXISTS  readerapptime ON readerappweibo ( time )"};
    public h hhp;

    public final java.util.List<com.tencent.mm.z.bf> H(java.lang.String r10, int r11) {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1444)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1466)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r9 = this;
        r4 = 1;
        r6 = 0;
        r5 = 0;
        r0 = r9.hhp;
        r1 = gU(r11);
        r2 = new java.lang.String[r4];
        r3 = "*";
        r2[r6] = r3;
        r3 = "reserved3=?";
        r4 = new java.lang.String[r4];
        r4[r6] = r10;
        r8 = 2;
        r6 = r5;
        r7 = r5;
        r1 = r0.a(r1, r2, r3, r4, r5, r6, r7, r8);
        if (r1 == 0) goto L_0x0043;
    L_0x0020:
        r0 = r1.moveToFirst();	 Catch:{ Exception -> 0x0049, all -> 0x0063 }
        if (r0 == 0) goto L_0x0043;	 Catch:{ Exception -> 0x0049, all -> 0x0063 }
    L_0x0026:
        r0 = new java.util.ArrayList;	 Catch:{ Exception -> 0x0049, all -> 0x0063 }
        r0.<init>();	 Catch:{ Exception -> 0x0049, all -> 0x0063 }
    L_0x002b:
        r2 = new com.tencent.mm.z.bf;	 Catch:{ Exception -> 0x0049, all -> 0x0063 }
        r2.<init>();	 Catch:{ Exception -> 0x0049, all -> 0x0063 }
        r2.b(r1);	 Catch:{ Exception -> 0x0049, all -> 0x0063 }
        r0.add(r2);	 Catch:{ Exception -> 0x0049, all -> 0x0063 }
        r2 = r1.moveToNext();	 Catch:{ Exception -> 0x0049, all -> 0x0063 }
        if (r2 != 0) goto L_0x002b;
    L_0x003c:
        if (r1 == 0) goto L_0x0041;
    L_0x003e:
        r1.close();
    L_0x0041:
        r5 = r0;
    L_0x0042:
        return r5;
    L_0x0043:
        if (r1 == 0) goto L_0x0042;
    L_0x0045:
        r1.close();
        goto L_0x0042;
    L_0x0049:
        r0 = move-exception;
        r2 = "MicroMsg.ReaderAppInfoStorage";	 Catch:{ Exception -> 0x0049, all -> 0x0063 }
        r3 = "getByFunctionMsgId, error: %s";	 Catch:{ Exception -> 0x0049, all -> 0x0063 }
        r4 = 1;	 Catch:{ Exception -> 0x0049, all -> 0x0063 }
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0049, all -> 0x0063 }
        r6 = 0;	 Catch:{ Exception -> 0x0049, all -> 0x0063 }
        r0 = r0.getMessage();	 Catch:{ Exception -> 0x0049, all -> 0x0063 }
        r4[r6] = r0;	 Catch:{ Exception -> 0x0049, all -> 0x0063 }
        com.tencent.mm.sdk.platformtools.x.e(r2, r3, r4);	 Catch:{ Exception -> 0x0049, all -> 0x0063 }
        if (r1 == 0) goto L_0x0042;
    L_0x005f:
        r1.close();
        goto L_0x0042;
    L_0x0063:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0069;
    L_0x0066:
        r1.close();
    L_0x0069:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.z.bg.H(java.lang.String, int):java.util.List<com.tencent.mm.z.bf>");
    }

    private static String hW(String str) {
        return "select tweetid,time,type,name,title,url,shorturl,longurl,pubtime,sourcename,sourceicon,istop,cover,digest,reserved1,reserved2,reserved3,reserved4 from " + str + "  ";
    }

    public static String gU(int i) {
        if (i == 20) {
            return "readerappnews1";
        }
        if (i == 11) {
            return "readerappweibo";
        }
        Assert.assertTrue("INFO TYPE NEITHER NEWS NOR WEIBO", false);
        return null;
    }

    public bg(h hVar) {
        this.hhp = hVar;
    }

    public final boolean a(bf bfVar) {
        if (bfVar == null) {
            return false;
        }
        bfVar.fDt = -1;
        ContentValues contentValues = new ContentValues();
        if ((bfVar.fDt & 1) != 0) {
            contentValues.put("tweetid", bfVar.HH());
        }
        if ((bfVar.fDt & 2) != 0) {
            contentValues.put("time", Long.valueOf(bfVar.time));
        }
        if ((bfVar.fDt & 4) != 0) {
            contentValues.put(DownloadSettingTable$Columns.TYPE, Integer.valueOf(bfVar.type));
        }
        if ((bfVar.fDt & 8) != 0) {
            contentValues.put("name", bfVar.getName());
        }
        if ((bfVar.fDt & 16) != 0) {
            contentValues.put("title", bfVar.getTitle());
        }
        if ((bfVar.fDt & 32) != 0) {
            contentValues.put(SlookSmartClipMetaTag.TAG_TYPE_URL, bfVar.getUrl());
        }
        if ((bfVar.fDt & 64) != 0) {
            contentValues.put("shorturl", bfVar.HI());
        }
        if ((bfVar.fDt & FileUtils.S_IWUSR) != 0) {
            contentValues.put("longurl", bfVar.hhg == null ? "" : bfVar.hhg);
        }
        if ((bfVar.fDt & 256) != 0) {
            contentValues.put("pubtime", Long.valueOf(bfVar.hhh));
        }
        if ((bfVar.fDt & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0) {
            contentValues.put("sourcename", bfVar.HJ());
        }
        if ((bfVar.fDt & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            contentValues.put("sourceicon", bfVar.HK());
        }
        if ((bfVar.fDt & 2048) != 0) {
            contentValues.put("istop", Integer.valueOf(bfVar.hhk));
        }
        if ((bfVar.fDt & Downloads.RECV_BUFFER_SIZE) != 0) {
            contentValues.put("cover", bfVar.HL());
        }
        if ((bfVar.fDt & 8192) != 0) {
            contentValues.put("digest", bfVar.HM());
        }
        if ((bfVar.fDt & 16384) != 0) {
            contentValues.put("reserved1", Integer.valueOf(bfVar.hhl));
        }
        if ((bfVar.fDt & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0) {
            contentValues.put("reserved2", Long.valueOf(bfVar.hhm));
        }
        if ((bfVar.fDt & 65536) != 0) {
            contentValues.put("reserved3", bfVar.HN());
        }
        if ((bfVar.fDt & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) != 0) {
            contentValues.put("reserved4", bfVar.hho == null ? "" : bfVar.hho);
        }
        if (((int) this.hhp.insert(gU(bfVar.type), "tweetid", contentValues)) != -1) {
            return true;
        }
        return false;
    }

    public final Cursor aY(int i, int i2) {
        return this.hhp.a("SELECT time from " + gU(i2) + " GROUP BY time ORDER BY time" + " ASC  LIMIT " + i + " offset (SELECT COUNT(*) FROM (SELECT COUNT(*) FROM " + gU(i2) + " GROUP BY time)) -" + i, null, 0);
    }

    public final int gV(int i) {
        int i2 = 0;
        Cursor a = this.hhp.a("select count(*) from (SELECT count(*) FROM " + gU(i) + " group by time)", null, 2);
        if (a.moveToFirst()) {
            i2 = a.getInt(0);
        }
        a.close();
        return i2;
    }

    public final List<bf> a(long j, int i) {
        List<bf> arrayList = new ArrayList();
        String str = hW(gU(20)) + " where reserved2 = " + j;
        x.d("MicroMsg.ReaderAppInfoStorage", "getInfoListByMsgSvrID :" + str);
        Cursor a = this.hhp.a(str, null, 2);
        while (a.moveToNext()) {
            bf bfVar = new bf();
            bfVar.b(a);
            arrayList.add(bfVar);
        }
        a.close();
        return arrayList;
    }

    public final List<bf> b(long j, int i) {
        List<bf> arrayList = new ArrayList();
        String str = hW(gU(i)) + " where time = " + j + " order by istop desc , tweetid" + " asc ";
        x.d("MicroMsg.ReaderAppInfoStorage", "getInfobyGroup :" + str);
        Cursor a = this.hhp.a(str, null, 2);
        while (a.moveToNext()) {
            bf bfVar = new bf();
            bfVar.b(a);
            arrayList.add(bfVar);
        }
        a.close();
        return arrayList;
    }

    public final void aM(long j) {
        x.d("MicroMsg.ReaderAppInfoStorage", "deleteGroupByMsgSvrID:%s", new Object[]{"delete from " + gU(20) + " where reserved2 = " + j});
        if (this.hhp.fx(gU(20), "delete from " + gU(20) + " where reserved2 = " + j)) {
            gX(20);
            doNotify();
        }
    }

    public final void a(String str, int i, boolean z, boolean z2) {
        List<bf> H = H(str, i);
        if (H != null && H.size() != 0) {
            bf bfVar = (bf) H.get(0);
            bf bfVar2 = bfVar;
            for (bf bfVar3 : H) {
                if (bfVar3.hhk != 1) {
                    bfVar3 = bfVar2;
                }
                bfVar2 = bfVar3;
            }
            if (this.hhp.delete(gU(i), "reserved3=?", new String[]{str}) >= 0 && z) {
                doNotify();
            }
            if (z2) {
                x.i("MicroMsg.ReaderAppInfoStorage", "processConversationAfterDeleteInfo, sql is %s", new Object[]{hW(gU(i)) + " where istop = 1  group by time" + " ORDER BY time DESC  limit 2"});
                Cursor a = this.hhp.a(r0, null, 2);
                ae aeVar;
                if (a.moveToFirst()) {
                    ar.Hg();
                    aj WY = c.Fd().WY(bf.gT(i));
                    bf bfVar4 = new bf();
                    bfVar4.b(a);
                    a.close();
                    aeVar = new ae();
                    aeVar.setUsername(bf.gT(i));
                    aeVar.setContent(bfVar4.getTitle());
                    aeVar.aj(bfVar4.time);
                    aeVar.eR(0);
                    if (WY.field_unReadCount <= 0 || bfVar2 == null || !WY.field_content.equals(bfVar2.getTitle())) {
                        aeVar.eO(0);
                    } else {
                        aeVar.eO(WY.field_unReadCount - 1);
                    }
                    ar.Hg();
                    c.Fd().a(aeVar, bf.gT(i));
                    return;
                }
                a.close();
                aeVar = new ae();
                aeVar.setUsername(bf.gT(i));
                aeVar.setContent("");
                aeVar.aj(0);
                aeVar.eR(0);
                aeVar.eO(0);
                ar.Hg();
                c.Fd().a(aeVar, bf.gT(i));
            }
        }
    }

    public final void gW(int i) {
        ar.Hg();
        aj WY = c.Fd().WY(bf.gT(i));
        if (WY != null && WY.field_username.equals(bf.gT(i))) {
            WY.setUsername(bf.gT(i));
            WY.setContent("");
            WY.eR(0);
            WY.eO(0);
            ar.Hg();
            c.Fd().a(WY, bf.gT(i));
            if (this.hhp.fx(gU(i), "delete from " + gU(i))) {
                doNotify();
            }
        }
    }

    public final void gX(int i) {
        x.i("MicroMsg.ReaderAppInfoStorage", "reset conversation, sql is %s", new Object[]{hW(gU(i)) + " where istop = 1  group by time" + " ORDER BY time DESC  limit 2"});
        Cursor a = this.hhp.a(r0, null, 2);
        if (a.moveToFirst()) {
            bf bfVar = new bf();
            bfVar.b(a);
            a.close();
            ae aeVar = new ae();
            aeVar.setUsername(bf.gT(i));
            aeVar.setContent(bfVar.getTitle());
            aeVar.aj(bfVar.time);
            aeVar.eR(0);
            aeVar.eO(0);
            ar.Hg();
            c.Fd().a(aeVar, bf.gT(i));
            return;
        }
        a.close();
        aeVar = new ae();
        aeVar.setUsername(bf.gT(i));
        aeVar.setContent("");
        aeVar.aj(0);
        aeVar.eR(0);
        aeVar.eO(0);
        ar.Hg();
        c.Fd().a(aeVar, bf.gT(i));
    }
}
