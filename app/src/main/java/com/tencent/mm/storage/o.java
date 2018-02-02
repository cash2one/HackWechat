package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.ag.a.a;
import com.tencent.mm.ag.a.e;
import com.tencent.mm.ag.a.j;
import com.tencent.mm.ag.f;
import com.tencent.mm.ag.y;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.plugin.messenger.foundation.a.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.c.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ba;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class o extends e {
    public static final String[] gJN = new String[]{"CREATE TABLE IF NOT EXISTS bizchatmessage ( msgId INTEGER PRIMARY KEY, msgSvrId INTEGER , type INT, status INT, isSend INT, isShowTimer INTEGER, createTime INTEGER, talker TEXT, content TEXT, imgPath TEXT, reserved TEXT, lvbuffer BLOB, transContent TEXT, transBrandWording TEXT, bizChatId INTEGER DEFAULT -1, bizChatUserId TEXT ) ", "CREATE INDEX IF NOT EXISTS  bizmessageChatIdIndex ON bizchatmessage ( bizChatId )", "CREATE INDEX IF NOT EXISTS  bizmessageSvrIdIndex ON bizchatmessage ( msgSvrId )", "CREATE INDEX IF NOT EXISTS  bizmessageTalkerIndex ON bizchatmessage ( talker )", "CREATE INDEX IF NOT EXISTS  bizmessageTalerStatusIndex ON bizchatmessage ( talker,status )", "CREATE INDEX IF NOT EXISTS  bizmessageCreateTimeIndex ON bizchatmessage ( createTime )", "CREATE INDEX IF NOT EXISTS  bizmessageCreateTaklerTimeIndex ON bizchatmessage ( talker,createTime )", "CREATE INDEX IF NOT EXISTS  bizmessageBizChatIdTypeCreateTimeIndex ON bizchatmessage ( bizChatId,type,createTime )", "CREATE INDEX IF NOT EXISTS  bizmessageSendCreateTimeIndex ON bizchatmessage ( status,isSend,createTime )", "CREATE INDEX IF NOT EXISTS  bizchatmessageTalkerTypeIndex ON bizchatmessage ( talker,type )"};

    public o(c cVar) {
        super(cVar);
        a(aZl(), "bizchatmessage");
        a(new b(16, "bizchatmessage", b.a(2500001, 3000000, 99000001, 102000000)));
    }

    public final String Wq(String str) {
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(z);
        if (f.eE(str)) {
            return "bizchatmessage";
        }
        return null;
    }

    private static String aj(String str, long j) {
        return " bizChatId= " + j + " AND talker= '" + str + "'";
    }

    public final au ak(String str, long j) {
        if (bh.ov(str)) {
            return null;
        }
        au auVar = new au();
        Cursor a = aZl().a("select * from " + EQ(str) + " where" + aj(str, j) + "order by createTime DESC limit 1", null, 0);
        if (a.getCount() != 0) {
            a.moveToFirst();
            auVar.b(a);
        }
        a.close();
        return auVar;
    }

    public final List<au> h(String str, long j, int i) {
        List<au> arrayList = new ArrayList();
        Cursor a = aZl().a("SELECT * FROM " + EQ(str) + " WHERE" + aj(str, j) + "AND isSend = 0" + " ORDER BY createTime DESC LIMIT " + i, null, 0);
        if (a.moveToFirst()) {
            while (!a.isAfterLast()) {
                au auVar = new au();
                auVar.b(a);
                a.moveToNext();
                if (auVar.cjg()) {
                    arrayList.add(auVar);
                }
            }
        }
        a.close();
        return arrayList;
    }

    protected final boolean a(au auVar, ba.b bVar) {
        if (auVar == null) {
            x.w("MicroMsg.BizChatMessageStorage", "dealMsgSourceValue:message == null");
            return false;
        }
        auVar.ar(-1);
        if (bVar != null) {
            if (f.eE(auVar.field_talker)) {
                if (bh.ov(bVar.hgK)) {
                    x.w("MicroMsg.BizChatMessageStorage", "EnterpriseChat msgSourceValue error: %s", new Object[]{auVar.gjF});
                    return false;
                }
                com.tencent.mm.ag.a.c cVar = new com.tencent.mm.ag.a.c();
                cVar.field_bizChatServId = bVar.hgK;
                cVar.field_brandUserName = auVar.field_talker;
                if (!bh.ov(bVar.hgL)) {
                    cVar.field_chatVersion = bh.getInt(bVar.hgL, -1);
                }
                if (!bh.ov(bVar.hgJ)) {
                    cVar.field_chatType = bh.getInt(bVar.hgJ, -1);
                }
                x.d("MicroMsg.BizChatMessageStorage", "bizchatId:%s,userId:%s", new Object[]{bVar.hgK, bVar.userId});
                cVar = e.e(cVar);
                if (cVar != null) {
                    auVar.ar(cVar.field_bizChatLocalId);
                    auVar.field_bizChatUserId = bh.ou(bVar.userId);
                    auVar.gjt = true;
                    if (bVar.hgN.equals("1")) {
                        auVar.eR(1);
                    }
                    if (!(auVar.field_isSend == 1 || bVar.userId == null)) {
                        if (bVar.userId.equals(y.Mj().cb(auVar.field_talker))) {
                            auVar.eR(1);
                        }
                    }
                    if (!bh.ov(bVar.userId)) {
                        j jVar = new j();
                        jVar.field_userId = bVar.userId;
                        jVar.field_userName = bVar.hgM;
                        jVar.field_brandUserName = auVar.field_talker;
                        y.Mj().c(jVar);
                    }
                } else {
                    x.w("MicroMsg.BizChatMessageStorage", "dealMsgSourceValue:bizChatInfo == null!");
                    return false;
                }
            } else if (!bh.ov(bVar.hgK)) {
                x.i("MicroMsg.BizChatMessageStorage", "is EnterpriseChat but contact not ready");
                return false;
            }
        }
        return true;
    }

    public final List<au> b(String str, long j, long j2, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.BizChatMessageStorage", new StringBuilder("getImgMessage fail, argument is invalid, limit = 10").toString());
            return null;
        }
        long L = this.xms.L(str, j2);
        if (L == 0) {
            x.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, msg is null");
            return null;
        }
        String str2;
        List<au> arrayList = new ArrayList();
        if (z) {
            str2 = "select * from " + EQ(str) + " INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + aj(str, j) + "AND " + this.xms.aZt() + " AND createTime > " + L + "  order by createTime ASC limit 10";
        } else {
            str2 = "select * from " + EQ(str) + " INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + aj(str, j) + "AND " + this.xms.aZt() + " AND createTime < " + L + "  order by createTime DESC limit 10";
        }
        Cursor a = aZl().a(str2, null, 0);
        if (a.moveToFirst()) {
            while (!a.isAfterLast()) {
                au auVar = new au();
                auVar.b(a);
                a.moveToNext();
                if (z) {
                    arrayList.add(auVar);
                } else {
                    arrayList.add(0, auVar);
                }
            }
        }
        a.close();
        x.i("MicroMsg.BizChatMessageStorage", "getBizChatImgVideoMessage spent : %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return arrayList;
    }

    public final Cursor al(String str, long j) {
        long currentTimeMillis = System.currentTimeMillis();
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid");
            return null;
        }
        Cursor a = aZl().a("select * from " + EQ(str) + "  INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + aj(str, j) + "AND " + this.xms.aZu() + "  order by createTime", null, 0);
        x.d("MicroMsg.BizChatMessageStorage", "all time: %d, sql: %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), r1});
        return a;
    }

    public final Cursor b(String str, long j, int i, int i2) {
        System.currentTimeMillis();
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid");
            return null;
        }
        return aZl().a("select * from ( select * from " + EQ(str) + "  INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + aj(str, j) + "AND " + this.xms.aZt() + " order by createTime DESC limit " + i2 + " OFFSET " + i + ") order by createTime ASC ", null, 0);
    }

    public final Cursor a(String str, long j, long j2, long j3) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid");
            return null;
        }
        return aZl().a("select * from " + EQ(str) + "  INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + aj(str, j) + "AND " + this.xms.aZt() + " AND createTime >= " + j2 + " AND createTime< " + j3 + " order by createTime ASC", null, 0);
    }

    public final int am(String str, long j) {
        x.w("MicroMsg.BizChatMessageStorage", "deleteByTalker :%s  stack:%s", new Object[]{str, ai.cfI()});
        fA(EQ(str), aj(str, j));
        int delete = aZl().delete(EQ(str), aj(str, j), null);
        if (delete != 0) {
            this.xms.Wc("delete_talker " + str);
            c.c cVar = new c.c(str, "delete", delete);
            cVar.ooZ = -1;
            a(cVar);
        }
        return delete;
    }

    public final int ED(String str) {
        x.w("MicroMsg.BizChatMessageStorage", "not attention  deleteEnterpriseMsgByTalker :%s  stack:%s", new Object[]{str, ai.cfI()});
        String str2 = "talker= '" + str + "'";
        fA(EQ(str), str2);
        int delete = aZl().delete(EQ(str), str2, null);
        if (delete != 0) {
            this.xms.Wc("delete_talker " + str);
            c.c cVar = new c.c(str, "delete", delete);
            cVar.ooZ = -1;
            a(cVar);
        }
        return delete;
    }

    public final Cursor an(String str, long j) {
        return aZl().query(EQ(str), null, aj(str, j), null, null, null, "createTime ASC ");
    }

    public final Cursor i(String str, long j, int i) {
        x.d("MicroMsg.BizChatMessageStorage", "getBizInitCursor talker:%s, bizChatId:%s, limitCount:%s, sql:[%s]", new Object[]{str, Long.valueOf(j), Integer.valueOf(i), "SELECT * FROM ( SELECT * FROM " + EQ(str) + " WHERE" + aj(str, j) + "ORDER BY createTime DESC LIMIT " + i + ") ORDER BY createTime ASC"});
        return aZl().a("SELECT * FROM ( SELECT * FROM " + EQ(str) + " WHERE" + aj(str, j) + "ORDER BY createTime DESC LIMIT " + i + ") ORDER BY createTime ASC", null, 0);
    }

    public final int ao(String str, long j) {
        if (str == null) {
            x.w("MicroMsg.BizChatMessageStorage", "getBizMsgCountFromMsgTable talker:%s,bizChatId:%s", new Object[]{str, Long.valueOf(j)});
            return -1;
        }
        a aS = y.Mi().aS(j);
        if (aS.field_msgCount != 0) {
            return aS.field_msgCount;
        }
        x.i("MicroMsg.BizChatMessageStorage", "geBiztMsgCount contactMsgCount is 0 ,go normal %s", new Object[]{str});
        return ap(str, j);
    }

    public final int ap(String str, long j) {
        int i = 0;
        x.v("MicroMsg.BizChatMessageStorage", "getBizMsgCountFromMsgTable sql:[%s]", new Object[]{"SELECT COUNT(*) FROM " + EQ(str) + " WHERE " + aj(str, j)});
        Cursor a = aZl().a(r1, null, 0);
        if (a.moveToLast()) {
            i = a.getInt(0);
        }
        a.close();
        return i;
    }

    public final int aq(String str, long j) {
        int i = 0;
        Cursor a = aZl().a("SELECT COUNT(*) FROM " + this.xms.EQ(str) + " WHERE " + aj(str, j) + "AND " + this.xms.aZt(), null, 0);
        if (a.moveToLast()) {
            i = a.getInt(0);
        }
        a.close();
        return i;
    }

    public final int s(String str, long j, long j2) {
        int i = 0;
        cf dH = this.xms.dH(j2);
        if (dH.field_msgId == 0) {
            x.e("MicroMsg.BizChatMessageStorage", "getCountEarlyThan fail, msg does not exist");
        } else {
            Cursor a = aZl().a("SELECT COUNT(*) FROM " + EQ(str) + " INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  WHERE " + aj(str, j) + "AND " + this.xms.aZt() + " AND createTime < " + dH.field_createTime, null, 0);
            if (a.moveToLast()) {
                i = a.getInt(0);
            }
            a.close();
        }
        return i;
    }

    public final long ar(String str, long j) {
        String str2 = "select createTime from " + EQ(str) + " where" + aj(str, j) + "order by createTime DESC LIMIT 1 ";
        x.d("MicroMsg.BizChatMessageStorage", "get last message create time: " + str2);
        Cursor a = aZl().a(str2, null, 0);
        if (a == null) {
            x.e("MicroMsg.BizChatMessageStorage", "get last message create time failed " + str);
            return -1;
        } else if (a.moveToFirst()) {
            long j2 = a.getLong(0);
            a.close();
            return j2;
        } else {
            a.close();
            return -1;
        }
    }

    public final int b(String str, long j, long j2, long j3) {
        if (j3 >= j2) {
            long j4 = j3;
            j3 = j2;
            j2 = j4;
        }
        x.d("MicroMsg.BizChatMessageStorage", "talker %s, get count fromCreateTime %d, toCreateTime %d", new Object[]{str, Long.valueOf(j3), Long.valueOf(j2)});
        String str2 = "SELECT COUNT(msgId) FROM " + EQ(str) + " WHERE" + aj(str, j) + "AND createTime >= " + j3 + " AND createTime <= " + j2;
        x.d("MicroMsg.BizChatMessageStorage", "get count sql: " + str2);
        Cursor a = aZl().a(str2, null, 0);
        if (a == null) {
            x.w("MicroMsg.BizChatMessageStorage", "get count error, cursor is null");
            return 0;
        } else if (a.moveToFirst()) {
            x.d("MicroMsg.BizChatMessageStorage", "result msg count %d", new Object[]{Integer.valueOf(a.getInt(0))});
            a.close();
            return a.getInt(0);
        } else {
            a.close();
            return 0;
        }
    }

    public final Cursor c(String str, long j, long j2, long j3) {
        if (j3 >= j2) {
            long j4 = j3;
            j3 = j2;
            j2 = j4;
        }
        String str2 = "SELECT * FROM " + EQ(str) + " WHERE" + aj(str, j) + "AND createTime >= " + j3 + " AND createTime <= " + j2 + " ORDER BY createTime ASC ";
        x.d("MicroMsg.BizChatMessageStorage", "get cursor: " + str2);
        return aZl().a(str2, null, 0);
    }

    public final long t(String str, long j, long j2) {
        x.d("MicroMsg.BizChatMessageStorage", "get up inc create time, talker %s, fromCreateTime %d, targetIncCount %d", new Object[]{str, Long.valueOf(j2), Integer.valueOf(18)});
        x.d("MicroMsg.BizChatMessageStorage", "get up inc msg create time sql: %s", new Object[]{"SELECT createTime FROM " + EQ(str) + " WHERE" + aj(str, j) + "AND createTime < " + j2 + " ORDER BY createTime DESC  LIMIT 18"});
        Cursor a = aZl().a(r0, null, 0);
        if (a == null) {
            x.w("MicroMsg.BizChatMessageStorage", "get inc msg create time error, cursor is null");
            return j2;
        } else if (a.moveToLast()) {
            x.d("MicroMsg.BizChatMessageStorage", "result msg create time %d", new Object[]{Long.valueOf(a.getLong(0))});
            a.close();
            return a.getLong(0);
        } else {
            a.close();
            x.w("MicroMsg.BizChatMessageStorage", "get result fail");
            return j2;
        }
    }

    public final long u(String str, long j, long j2) {
        x.d("MicroMsg.BizChatMessageStorage", "get down inc create time, talker %s, fromCreateTime %d, targetIncCount %d", new Object[]{str, Long.valueOf(j2), Integer.valueOf(18)});
        x.d("MicroMsg.BizChatMessageStorage", "get down inc msg create time sql: %s", new Object[]{"SELECT createTime FROM " + EQ(str) + " WHERE" + aj(str, j) + "AND createTime > " + j2 + " ORDER BY createTime ASC  LIMIT 18"});
        Cursor a = aZl().a(r0, null, 0);
        if (a == null) {
            x.w("MicroMsg.BizChatMessageStorage", "get down inc msg create time error, cursor is null");
            return j2;
        } else if (a.moveToLast()) {
            x.d("MicroMsg.BizChatMessageStorage", "result msg create time %d", new Object[]{Long.valueOf(a.getLong(0))});
            a.close();
            return a.getLong(0);
        } else {
            a.close();
            x.w("MicroMsg.BizChatMessageStorage", "get result fail");
            return j2;
        }
    }
}
