package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.by.h;
import com.tencent.mm.c.f;
import com.tencent.mm.g.b.aj;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.c.c;
import com.tencent.mm.plugin.messenger.foundation.a.d;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.as.b;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;
import org.xwalk.core.R$styleable;

public final class af extends m implements as {
    public static final String[] gJN = new String[]{i.a(com.tencent.mm.m.a.gJc, "rconversation"), i.a(com.tencent.mm.m.a.gJc, "rbottleconversation"), "CREATE TABLE IF NOT EXISTS conversation ( unReadCount INTEGER, status INT, isSend INT, createTime LONG, username VARCHAR(40), content TEXT, reserved TEXT );", "CREATE TABLE IF NOT EXISTS bottleconversation ( unReadCount INTEGER, status INT, isSend INT, createTime LONG, username VARCHAR(40), content TEXT, reserved TEXT );", "DROP INDEX IF EXISTS rconversation_unreadcount_index ", "DROP INDEX IF EXISTS multi_index ", "CREATE INDEX IF NOT EXISTS rconversation_multi_index ON  rconversation ( unReadCount,parentRef )", "CREATE INDEX IF NOT EXISTS rbottleconversation_unreadcount_index ON  rbottleconversation ( unReadCount )"};
    private final e gJP;
    private b xyf;
    private d xyg;
    private a xyh = new a();
    private k<com.tencent.mm.storage.as.a, ae> xyi = new k<com.tencent.mm.storage.as.a, ae>(this) {
        final /* synthetic */ af xyk;

        {
            this.xyk = r1;
        }

        protected final /* synthetic */ void p(Object obj, Object obj2) {
            ((com.tencent.mm.storage.as.a) obj).a((ae) obj2, this.xyk);
        }
    };
    private k<com.tencent.mm.storage.as.a, ae> xyj = new 2(this);

    private static class a extends com.tencent.mm.cd.a<com.tencent.mm.plugin.messenger.foundation.a.e> implements com.tencent.mm.plugin.messenger.foundation.a.e {
        private a() {
        }

        public final void a(au auVar, ae aeVar, boolean z, c cVar) {
            a(new 1(this, auVar, aeVar, z, cVar));
        }

        public final void b(au auVar, ae aeVar, boolean z, c cVar) {
            a(new 2(this, auVar, aeVar, z, cVar));
        }
    }

    public af(e eVar) {
        byte b;
        Assert.assertTrue(eVar instanceof h);
        Cursor a = eVar.a("PRAGMA table_info( rconversation)", null, 2);
        int columnIndex = a.getColumnIndex("name");
        while (a.moveToNext()) {
            if (columnIndex >= 0) {
                if ("flag".equalsIgnoreCase(a.getString(columnIndex))) {
                    b = (byte) 1;
                    break;
                }
            }
        }
        b = (byte) 0;
        a.close();
        List<String> a2 = i.a(com.tencent.mm.m.a.gJc, "rconversation", eVar);
        a2.addAll(i.a(com.tencent.mm.m.a.gJc, "rbottleconversation", eVar));
        for (String fx : a2) {
            eVar.fx("rconversation", fx);
        }
        if (b == (byte) 0) {
            eVar.fx("rconversation", "update rconversation set flag = conversationTime");
        }
        this.gJP = eVar;
    }

    private static String WW(String str) {
        x.v("MicroMsg.ConversationStorage", "talker :" + str);
        if (x.gy(str)) {
            return "rbottleconversation";
        }
        return "rconversation";
    }

    public final void a(b bVar) {
        this.xyf = bVar;
    }

    public final b uw() {
        return this.xyf;
    }

    public final void a(d dVar) {
        this.xyg = dVar;
    }

    public final com.tencent.mm.vending.b.b a(com.tencent.mm.plugin.messenger.foundation.a.e eVar) {
        return this.xyh.aE(eVar);
    }

    public final void a(com.tencent.mm.storage.as.a aVar, Looper looper) {
        this.xyj.a(aVar, looper);
    }

    public final void a(com.tencent.mm.storage.as.a aVar) {
        this.xyj.remove(aVar);
    }

    public final void b(com.tencent.mm.storage.as.a aVar) {
        this.xyi.a(aVar, null);
    }

    public final void c(com.tencent.mm.storage.as.a aVar) {
        this.xyi.remove(aVar);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(com.tencent.mm.plugin.messenger.foundation.a.a.c cVar, c cVar2) {
        if (cVar2 == null) {
            x.f("MicroMsg.ConversationStorage", "null notifyInfo");
            return;
        }
        ae aeVar;
        boolean z;
        int i;
        int i2;
        String str = cVar2.talker;
        ae WY = WY(str);
        cf Ex = cVar.Ex(str);
        if (WY == null) {
            aj aeVar2 = new ae(str);
            if (x.gy(str)) {
                aeVar2.eP(1);
            }
            aeVar = aeVar2;
            z = true;
        } else {
            aeVar = WY;
            z = false;
        }
        this.xyh.a(Ex, aeVar, z, cVar2);
        x.i("MicroMsg.ConversationStorage", "dkevent user:%s func:%s cnt:%d ", new Object[]{cVar2.talker, cVar2.ooU, Integer.valueOf(cVar2.ooW)});
        if (!(Ex == null || Ex.field_msgId == 0)) {
            if (cVar2.ooW == 1 && ((au) cVar2.ooV.get(0)).field_msgId != Ex.field_msgId) {
                x.w("MicroMsg.ConversationStorage", "Warning ! getLastMsg may wrong , lastid:%d  insertlist:%d", new Object[]{Long.valueOf(Ex.field_msgId), Long.valueOf(((au) cVar2.ooV.get(0)).field_msgId)});
            }
            i = Ex.field_flag;
            long j = aeVar.field_lastSeq;
            long j2 = Ex.field_msgSeq;
            x.i("MicroMsg.ConversationStorage", "summerbadcr check last message flag[%d], newseq[%d] oldseq[%d], undeliverCount[%d]", new Object[]{Integer.valueOf(i), Long.valueOf(j2), Long.valueOf(j), Long.valueOf((long) aeVar.field_UnDeliverCount)});
            long ET;
            if ((cVar2.ooU.equals("insert") && cVar2.ooW > 0) || (cVar2.ooU.equals("update") && aeVar.field_unReadCount + cVar2.ooW >= 0)) {
                aeVar.eO(aeVar.field_unReadCount + cVar2.ooW);
                if (j2 > j) {
                    x.i("MicroMsg.ConversationStorage", "summerbadcr insert or update reset lastseq[%d]", new Object[]{Long.valueOf(j2)});
                    if (ET <= 0 || (i & 2) != 0) {
                        aeVar.al(j2);
                    } else {
                        x.i("MicroMsg.ConversationStorage", "summerbadcr insert or update reset lastseq but undeliver flag not match[%d, %d, %d, %d]", new Object[]{Long.valueOf(j2), Long.valueOf(j), Long.valueOf(ET), Integer.valueOf(i)});
                    }
                }
            } else if (cVar2.ooY > 0 && j2 < j && ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZi().G(aeVar.field_username, j).field_msgId == 0) {
                ET = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZi().ET(aeVar.field_username);
                x.i("MicroMsg.ConversationStorage", "summerbadcr delete reset lastseq[%d, %d], lastMsgSeq[%d]", new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(ET)});
                aeVar.al(j2);
                if (j > ET) {
                    ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).FJ().C(aeVar.field_username, ET);
                }
            }
            if (Ex.cji() && Ex.field_isSend == 1) {
                aeVar.field_sightTime = Ex.field_createTime;
                aeVar.fXe = true;
            }
        }
        if (cVar2.ooU.equals("insert") && cVar2.ooV.size() > 0 && s.eV(cVar2.talker)) {
            str = q.FS();
            Iterator it = cVar2.ooV.iterator();
            while (it.hasNext()) {
                au auVar = (au) it.next();
                if (auVar.field_isSend != 1) {
                    if (!auVar.cjg()) {
                    }
                    if (auVar.Xq(str)) {
                        aeVar.eU(aeVar.field_atCount + 1);
                    } else if (auVar.cjD()) {
                        aeVar.eU(aeVar.field_atCount + Downloads.RECV_BUFFER_SIZE);
                    }
                }
                Map y = f.y(auVar.field_content, "sysmsg");
                if (au.au(y)) {
                    aeVar.eX(aeVar.field_UnReadInvite + 1);
                } else if (au.av(y)) {
                    aeVar.eX(aeVar.field_UnReadInvite + Downloads.RECV_BUFFER_SIZE);
                }
            }
        }
        i = 0;
        String str2 = cVar2 != null ? cVar2.talker : null;
        if (!(cVar2 == null || cVar2.ooU == null || !cVar2.ooU.equals("delete"))) {
            if (cVar2.ooY > 0) {
                i = cVar2.ooY;
            }
            x.i("MicroMsg.ConversationStorage", "notify delete count %d ", new Object[]{Integer.valueOf(cVar2.ooY)});
        }
        int i3 = i;
        if (cVar2 == null || cVar2.ooU == null || !cVar2.ooU.equals("insert")) {
            i2 = 0;
        } else {
            i = cVar2.ooX > 0 ? cVar2.ooX : 0;
            x.i("MicroMsg.ConversationStorage", "notify insert all count %d ", new Object[]{Integer.valueOf(cVar2.ooX)});
            i2 = i;
        }
        String str3 = "MicroMsg.ConversationStorage";
        String str4 = "summerbadcr updateConversation talker[%s] msgseq[%d],newConv[%b],newMsgInsertCount[%d], deleteCount[%d], tid[%d]";
        Object[] objArr = new Object[6];
        objArr[0] = bh.az(str2, "");
        objArr[1] = Long.valueOf(Ex != null ? Ex.field_msgSeq : -1);
        objArr[2] = Boolean.valueOf(z);
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = Integer.valueOf(i3);
        objArr[5] = Long.valueOf(Thread.currentThread().getId());
        x.i(str3, str4, objArr);
        if (z && i3 > 0 && i2 == 0) {
            x.i("MicroMsg.ConversationStorage", "summerdel ignore delete event [%s, %s]", new Object[]{str2, aeVar.field_username});
            return;
        }
        this.xyi.ca(aeVar);
        this.xyi.doNotify();
        if (str2 == null) {
            x.e("MicroMsg.ConversationStorage", "talker == null");
        } else if (str2.equals(aeVar.field_username)) {
            if (Ex == null || Ex.field_msgId == 0) {
                x.i("MicroMsg.ConversationStorage", "update null conversation with talker " + str2);
                if (!z) {
                    aeVar.ciy();
                    a(aeVar, i3, i2);
                    a(aeVar, str2, true);
                } else if (((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZi().EM(str2) > 0) {
                    if (Ex.cji() || com.tencent.mm.sdk.a.b.ceM()) {
                        aeVar.aj(Ex.field_createTime);
                    } else {
                        aeVar.aj(bh.Wp());
                    }
                    a(aeVar, i3, i2);
                    d(aeVar);
                }
            } else {
                x.v("MicroMsg.ConversationStorage", "onNotifyChange   msgId:" + Ex.field_msgId);
                aeVar.ac(Ex);
                if (this.xyf != null) {
                    PString pString = new PString();
                    PString pString2 = new PString();
                    PInt pInt = new PInt();
                    this.xyf.a(Ex, pString, pString2, pInt, aeVar.gc(2097152));
                    x.d("MicroMsg.ConversationStorage", "oreh onNotifyChange genDigest: pDigestUser.value=%s", new Object[]{pString2.value});
                    aeVar.dF(pString.value);
                    aeVar.dG(pString2.value);
                    aeVar.eS(pInt.value);
                } else {
                    str3 = aS(Ex.getType(), aeVar.field_content);
                    aeVar.dF(bh.ou(aeVar.field_digest).concat(bh.ov(str3) ? "" : " " + bh.ou(str3)));
                }
                aeVar.dE(Integer.toString(Ex.getType()));
                if (this.xyg != null) {
                    this.xyg.a(Ex, aeVar);
                }
                aeVar.ak(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(aeVar, 1, Ex.field_createTime));
                if (z) {
                    com.tencent.mm.g.b.af WO = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).EY().WO(str2);
                    if (!(WO == null || bh.ov(WO.field_username) || !WO.AL())) {
                        aeVar.ak(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(aeVar, 2, 0));
                    }
                    a(aeVar, i3, i2);
                    if (Ex.cji() || com.tencent.mm.sdk.a.b.ceM()) {
                        aeVar.aj(Ex.field_createTime);
                    } else {
                        aeVar.aj(bh.Wp());
                    }
                    d(aeVar);
                } else {
                    a(aeVar, i3, i2);
                    a(aeVar, str2, true);
                }
            }
            this.xyj.ca(aeVar);
            this.xyj.doNotify();
            this.xyh.b(Ex, aeVar, z, cVar2);
        } else {
            x.e("MicroMsg.ConversationStorage", "process message for conversation failed: inconsist username");
        }
    }

    private static long c(ae aeVar) {
        if (aeVar != null) {
            return com.tencent.mm.plugin.messenger.foundation.a.a.a.a(aeVar, aeVar.field_conversationTime);
        }
        return bh.Wp() & 72057594037927935L;
    }

    public final void WX(String str) {
        x.w("MicroMsg.ConversationStorage", "delChatContact username:%s  stack:%s", new Object[]{str, ai.cfI()});
        if (this.gJP.delete(WW(str), "username=?", new String[]{str}) != 0) {
            b(5, this, str);
        }
    }

    public final boolean ciz() {
        boolean z = this.gJP.fx("rconversation", "delete from rconversation") || this.gJP.fx("rconversation", "delete from rbottleconversation");
        if (z) {
            b(5, this, "");
        }
        return z;
    }

    public final boolean ciA() {
        x.w("MicroMsg.ConversationStorage", "deleteBottleConversation stack:%s", new Object[]{ai.cfI()});
        boolean fx = this.gJP.fx("rconversation", "delete from rbottleconversation");
        if (fx) {
            b(5, this, "");
        }
        return fx;
    }

    public final boolean EE(String str) {
        x.w("MicroMsg.ConversationStorage", "deleteMessageEndByName nameTag:%s  stack:%s", new Object[]{str, ai.cfI()});
        boolean fx = this.gJP.fx("rconversation", "delete from " + WW(str) + " where username like '%" + str + "'");
        if (fx) {
            b(5, this, str);
        }
        return fx;
    }

    public final ae WY(String str) {
        Cursor a = this.gJP.a(WW(str), null, "username=?", new String[]{str}, null, null, null, 2);
        if (a.moveToFirst()) {
            ae aeVar = new ae();
            aeVar.b(a);
            a.close();
            return aeVar;
        }
        x.w("MicroMsg.ConversationStorage", "get null with username:" + str);
        a.close();
        return null;
    }

    public final void ad(au auVar) {
        String str = auVar.field_talker;
        boolean z = false;
        ae WY = WY(str);
        if (WY == null || WY.field_conversationTime <= auVar.field_createTime || WY.field_conversationTime == Long.MAX_VALUE) {
            if (WY == null) {
                WY = new ae(str);
                z = true;
            }
            WY.eR(auVar.field_isSend);
            WY.eO(WY.field_unReadCount);
            WY.ac(auVar);
            WY.dE(Integer.toString(auVar.getType()));
            WY.ak((WY.field_flag & 4611686018427387904L) | (auVar.field_createTime & 72057594037927935L));
            if (z) {
                d(WY);
                return;
            } else {
                a(WY, str, true);
                return;
            }
        }
        x.i("MicroMsg.ConversationStorage", "updateConvFromLastMsg ignore(maybe the system time is bigger than normal)");
    }

    public final HashMap<String, Long> ciB() {
        long currentTimeMillis = System.currentTimeMillis();
        HashMap<String, Long> hashMap = new HashMap();
        Cursor a = this.gJP.a("rconversation", new String[]{"username", "conversationTime"}, null, null, null, null, null, 2);
        if (a.moveToFirst()) {
            while (true) {
                int i = a == null ? 0 : (a.isClosed() || a.isBeforeFirst() || a.isAfterLast()) ? 0 : 1;
                if (i != 0) {
                    hashMap.put(a.getString(0), Long.valueOf(a.getLong(1)));
                    a.moveToNext();
                } else {
                    a.close();
                    x.d("MicroMsg.ConversationStorage", "kevin getALLTimeIndex:" + (System.currentTimeMillis() - currentTimeMillis));
                    return hashMap;
                }
            }
        }
        a.close();
        return hashMap;
    }

    public final long d(ae aeVar) {
        String ou = bh.ou(aeVar.field_username);
        if (ou.length() <= 0) {
            x.e("MicroMsg.ConversationStorage", "insert conversation failed, username empty");
            return -1;
        }
        aeVar.ak(c(aeVar));
        e(aeVar);
        long insert = this.gJP.insert(WW(ou), null, aeVar.vI());
        if (insert != -1) {
            b(2, this, aeVar.field_username);
        } else {
            x.e("MicroMsg.ConversationStorage", "insert failed return -1, table:%s", new Object[]{WW(ou)});
        }
        return insert;
    }

    public final void a(ae aeVar, int i, int i2) {
        if (!((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZi().EN(aeVar.field_username)) {
            return;
        }
        if (bh.ou(aeVar.field_username).length() <= 0) {
            x.e("MicroMsg.ConversationStorage", "countMsg conversation failed, username empty");
            return;
        }
        if (aeVar.field_msgCount == 0) {
            aeVar.eN(((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZi().EO(aeVar.field_username));
            x.i("MicroMsg.ConversationStorage", "getMsgCount from message table");
        } else if (i > 0) {
            aeVar.eN(aeVar.field_msgCount - i);
            if (aeVar.field_msgCount < 0) {
                x.e("MicroMsg.ConversationStorage", "msg < 0 ,some path must be ignore!");
                aeVar.eN(0);
            }
        } else if (i2 > 0) {
            aeVar.eN(aeVar.field_msgCount + i2);
        }
        x.i("MicroMsg.ConversationStorage", "countMsg %d talker :%s deleteCount:%d insertCount:%d", new Object[]{Integer.valueOf(aeVar.field_msgCount), aeVar.field_username, Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public final void ciC() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("msgCount", Integer.valueOf(0));
        this.gJP.update("rconversation", contentValues, null, null);
    }

    public final void WZ(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("msgCount", Integer.valueOf(0));
        this.gJP.update("rconversation", contentValues, "username=?", new String[]{str});
    }

    public final boolean Xa(String str) {
        if (str == null || str.length() <= 0) {
            x.e("MicroMsg.ConversationStorage", "update conversation failed");
            return false;
        }
        aj WY = WY(str);
        if (WY == null) {
            return true;
        }
        if (WY.field_unReadCount == 0 && WY.field_unReadMuteCount == 0 && str.equals(WY.field_username)) {
            a(str, 1048576, false, WY.field_attrflag);
            ContentValues contentValues = new ContentValues();
            contentValues.put("UnReadInvite", Integer.valueOf(0));
            if (this.gJP.update(WW(str), contentValues, "username= ?", new String[]{bh.ot(str)}) <= 0) {
                return true;
            }
            b(3, this, str);
            return true;
        }
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("unReadCount", Integer.valueOf(0));
        contentValues2.put("unReadMuteCount", Integer.valueOf(0));
        contentValues2.put("UnReadInvite", Integer.valueOf(0));
        contentValues2.put("atCount", Integer.valueOf(0));
        contentValues2.put("attrflag", Integer.valueOf(WY.field_attrflag & -1048577));
        int update = this.gJP.update(WW(str), contentValues2, "username= ?", new String[]{bh.ot(str)});
        if (update > 0) {
            b(3, this, str);
        }
        if (update <= 0) {
            return false;
        }
        return true;
    }

    public final boolean Xb(String str) {
        if (str == null || str.length() <= 0) {
            x.e("MicroMsg.ConversationStorage", "update conversation failed");
            return false;
        }
        aj WY = WY(str);
        if (WY == null || (WY.field_unReadCount > 0 && str.equals(WY.field_username))) {
            return true;
        }
        boolean fx = this.gJP.fx("rconversation", "update " + WW(str) + " set unReadCount = 1, atCount" + " = 0, attrflag = " + (WY.field_attrflag | 1048576) + " where username = \"" + bh.ot(str) + "\"");
        if (!fx) {
            return fx;
        }
        b(3, this, str);
        return fx;
    }

    public final boolean a(String str, int i, boolean z, int i2) {
        if (bh.ov(str)) {
            return false;
        }
        if (WY(str) == null) {
            return true;
        }
        int i3;
        if (z) {
            i3 = i2 | i;
        } else {
            i3 = (i ^ -1) & i2;
        }
        if (i3 == i2) {
            return false;
        }
        boolean fx = this.gJP.fx("rconversation", "update " + WW(str) + " set attrflag = " + i3 + " where username = \"" + bh.ot(str) + "\"");
        if (!fx) {
            return fx;
        }
        b(3, this, str);
        return fx;
    }

    public final int a(ae aeVar, String str) {
        return a(aeVar, str, true);
    }

    public final int a(ae aeVar, String str, boolean z) {
        if (str == null || str.length() <= 0) {
            x.e("MicroMsg.ConversationStorage", "update conversation failed");
            return 0;
        }
        if (z) {
            aeVar.ak(c(aeVar));
        }
        e(aeVar);
        int update = this.gJP.update(WW(str), aeVar.vI(), "username=?", new String[]{str});
        if (update != 0) {
            b(3, this, str);
            return update;
        }
        x.e("MicroMsg.ConversationStorage", "update failed return 0,  table:%s", new Object[]{WW(str)});
        return update;
    }

    private static void e(ae aeVar) {
        if (aeVar != null && aeVar.field_unReadCount > 0) {
            x.d("MicroMsg.ConversationStorage", "jacks check attrFlag & cancel mark");
            if ((aeVar.field_attrflag & 1048576) != 0) {
                aeVar.eO(aeVar.field_unReadCount - 1);
                aeVar.eT(aeVar.field_attrflag & -1048577);
            }
        }
    }

    private long ciD() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        Cursor a = this.gJP.a("select max(conversationTime) as conversationTime from rconversation", null, 2);
        while (a.moveToNext()) {
            j = a.getLong(0);
        }
        a.close();
        x.d("MicroMsg.ConversationStorage", "latestConversationTime = %s, cost = %d", new Object[]{Long.valueOf(j), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return j;
    }

    public final boolean Xc(String str) {
        boolean z = false;
        if (str == null || str.length() <= 0) {
            x.e("MicroMsg.ConversationStorage", "setMoveUp conversation failed");
        } else {
            aj WY = WY(str);
            if (WY == null) {
                x.e("MicroMsg.ConversationStorage", "setMoveUp conv == null");
            } else {
                z = this.gJP.fx("rconversation", "update " + WW(WY.field_username) + " set flag = " + com.tencent.mm.plugin.messenger.foundation.a.a.a.a(WY, 1, ciD() + 1) + " where username = \"" + bh.ot(WY.field_username) + "\"");
                if (z) {
                    b(3, this, WY.field_username);
                }
            }
        }
        return z;
    }

    public final boolean Xd(String str) {
        boolean z = false;
        if (str == null || str.length() <= 0) {
            x.e("MicroMsg.ConversationStorage", "setPlacedTop conversation failed");
        } else {
            if (WY(str) == null) {
                ae aeVar = new ae(str);
                aeVar.aj(System.currentTimeMillis());
                d(aeVar);
                x.i("MicroMsg.ConversationStorage", "setPlacedTop username = " + str);
            }
            aj WY = WY(str);
            if (WY != null) {
                z = this.gJP.fx("rconversation", "update " + WW(WY.field_username) + " set flag = " + com.tencent.mm.plugin.messenger.foundation.a.a.a.a(WY, 2, 0) + " where username = \"" + bh.ot(WY.field_username) + "\"");
                if (z) {
                    b(3, this, WY.field_username);
                }
            }
        }
        return z;
    }

    public final boolean Xe(String str) {
        if (str != null && str.length() > 0) {
            return f(WY(str));
        }
        x.e("MicroMsg.ConversationStorage", "unSetPlacedTop conversation failed");
        return false;
    }

    public final boolean f(ae aeVar) {
        if (aeVar == null) {
            x.e("MicroMsg.ConversationStorage", "unSetPlacedTop conversation null");
            return false;
        }
        boolean fx = this.gJP.fx("rconversation", "update " + WW(aeVar.field_username) + " set flag = " + com.tencent.mm.plugin.messenger.foundation.a.a.a.a(aeVar, 3, aeVar.field_conversationTime) + " where username = \"" + bh.ot(aeVar.field_username) + "\"");
        if (!fx) {
            return fx;
        }
        b(3, this, aeVar.field_username);
        return fx;
    }

    public final boolean Xf(String str) {
        if (str != null && str.length() > 0) {
            return g(WY(str));
        }
        x.e("MicroMsg.ConversationStorage", "isPlacedTop failed");
        return false;
    }

    public final boolean g(ae aeVar) {
        if (aeVar == null) {
            x.e("MicroMsg.ConversationStorage", "isPlacedTop failed, conversation null");
            return false;
        } else if (com.tencent.mm.plugin.messenger.foundation.a.a.a.a(aeVar, 4, 0) != 0) {
            return true;
        } else {
            return false;
        }
    }

    public final Cursor c(String str, List<String> list, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from rconversation where ");
        if (com.tencent.mm.m.a.gJf == str2) {
            stringBuilder.append(" ( parentRef is null  or ").append("parentRef = '' ) ");
        } else if ("*".equals(str2)) {
            stringBuilder.append(" 1 = 1 ");
        } else {
            stringBuilder.append("parentRef = '").append(bh.ot(str2)).append("' ");
        }
        stringBuilder.append(bh.ou(str));
        if (list != null && list.size() > 0) {
            for (String append : list) {
                stringBuilder.append(" and rconversation.username").append(" != '").append(append).append("'");
            }
        }
        stringBuilder.append(" order by flag desc, conversationTime").append(" desc");
        return this.gJP.rawQuery(stringBuilder.toString(), null);
    }

    public final List<String> ciE() {
        List arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select rconversation.username from rconversation").append(",rcontact where ");
        stringBuilder.append("rconversation.username = rcontact.username");
        stringBuilder.append(bh.ou(bh.ou(s.hfk)));
        stringBuilder.append(" and ( verifyFlag & 8 ) = 0");
        stringBuilder.append(" and ( rconversation.parentRef is null  or ").append("rconversation.parentRef = '' ) ");
        for (String append : s.hfr) {
            stringBuilder.append(" and rconversation.username != '").append(append).append("'");
        }
        stringBuilder.append(" order by sightTime desc, flag").append(" desc, conversationTime desc");
        Cursor a = this.gJP.a(stringBuilder.toString(), null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                do {
                    arrayList.add(a.getString(0));
                } while (a.moveToNext());
            }
            a.close();
        }
        x.d("MicroMsg.ConversationStorage", "user list:%s", new Object[]{arrayList});
        return arrayList;
    }

    public final Cursor a(String str, List<String> list, String str2, boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select unReadCount, status, isSend, conversationTime, username, content, msgType, flag, digest, digestUser, attrflag, editingMsg, atCount, unReadMuteCount, UnReadInvite");
        stringBuilder.append(" from rconversation where ");
        if (com.tencent.mm.m.a.gJf == str2) {
            stringBuilder.append(" ( parentRef is null  or ").append("parentRef = '' ) ");
        } else if ("*".equals(str2)) {
            stringBuilder.append(" 1 = 1 ");
        } else {
            stringBuilder.append("parentRef = '").append(bh.ot(str2)).append("' ");
        }
        stringBuilder.append(bh.ou(str));
        if (list != null && list.size() > 0) {
            for (String append : list) {
                stringBuilder.append(" and rconversation.username").append(" != '").append(append).append("'");
            }
        }
        stringBuilder.append(" order by flag desc");
        x.d("MicroMsg.ConversationStorage", "getNecessaryCursor sql " + stringBuilder.toString());
        return this.gJP.a(stringBuilder.toString(), null, z ? 4 : 0);
    }

    public final Cursor a(ArrayList<String> arrayList, String str, List<String> list, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select unReadCount, status, isSend, conversationTime, username, content, msgType,flag, digest, digestUser, attrflag, editingMsg, atCount, unReadMuteCount, UnReadInvite");
        stringBuilder.append(" from rconversation where (");
        for (int i = 0; i < arrayList.size(); i++) {
            if (i != arrayList.size() - 1) {
                stringBuilder.append("username = '" + ((String) arrayList.get(i)) + "' OR ");
            } else {
                stringBuilder.append("username = '" + ((String) arrayList.get(i)) + "'");
            }
        }
        stringBuilder.append(") and ");
        if (com.tencent.mm.m.a.gJf == str2) {
            stringBuilder.append(" ( parentRef is null  or ").append("parentRef = '' ) ");
        } else if ("*".equals(str2)) {
            stringBuilder.append(" 1 = 1 ");
        } else {
            stringBuilder.append("parentRef = '").append(bh.ot(str2)).append("' ");
        }
        stringBuilder.append(bh.ou(str));
        if (list != null && list.size() > 0) {
            for (String append : list) {
                stringBuilder.append(" and rconversation.username").append(" != '").append(append).append("'");
            }
        }
        x.d("MicroMsg.ConversationStorage", "getNecessaryCursorByNames sql " + stringBuilder.toString());
        return this.gJP.rawQuery(stringBuilder.toString(), null);
    }

    public final Cursor b(String str, List<String> list, boolean z, String str2) {
        String str3 = " ";
        String str4 = " ";
        if (str2 != null && str2.length() > 0) {
            str4 = " and rconversation.username = rcontact.username ";
        }
        String str5 = "select unReadCount, status, isSend, conversationTime, rconversation.username, content, rconversation.msgType, rconversation.flag, rconversation.digest, rconversation.digestUser, rconversation.hasTrunc, rcontact.nickname from rconversation,rcontact" + str3 + " where rconversation.username" + " = rcontact.username" + str4 + bh.ou(str);
        str4 = "";
        if (list != null && list.size() > 0) {
            str3 = str4;
            for (String str42 : list) {
                str3 = str3 + " and rconversation.username != '" + str42 + "'";
            }
            str42 = str3;
        }
        str42 = str5 + str42;
        if (z) {
            str42 = str42 + " and ( verifyFlag & 8 ) = 0";
        }
        if (str2 != null && str2.length() > 0) {
            str42 = str42 + (" and ( rconversation.username like '%" + str2 + "%' or content like '%" + str2 + "%' or rcontact.nickname" + " like '%" + str2 + "%' or rcontact.alias" + " like '%" + str2 + "%' or rcontact.pyInitial" + " like '%" + str2 + "%' or rcontact.quanPin" + " like '%" + str2 + "%' or rcontact.conRemark" + " like '%" + str2 + "%'  ) ");
        }
        if (str2 == null || str2.equals("")) {
            str42 = str42 + " order by flag desc, conversationTime desc";
        } else {
            str42 = str42 + " order by rconversation.username like \"%@chatroom\" asc";
        }
        x.d("MicroMsg.ConversationStorage", "getSearchCursor sql " + str42);
        return this.gJP.rawQuery(str42, null);
    }

    public final Cursor Xg(String str) {
        return this.gJP.rawQuery("select unReadCount, status, isSend, conversationTime, rconversation.username, content, rconversation.msgType, nickname from rconversation,rcontact where rconversation.username = rcontact.username" + bh.ou(str) + " order by flag desc, conversationTime" + " desc", null);
    }

    public final void aw(LinkedList<String> linkedList) {
        x.w("MicroMsg.ConversationStorage", "deleteConversations   stack:%s", new Object[]{ai.cfI()});
        if (linkedList.isEmpty()) {
            x.w("MicroMsg.ConversationStorage", "deleteConversation:namelist is null");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        String str = (String) linkedList.poll();
        stringBuilder.append("delete from rconversation where ");
        stringBuilder.append("username='").append(str).append('\'');
        while (!linkedList.isEmpty()) {
            stringBuilder.append(" or username='").append((String) linkedList.poll()).append('\'');
        }
        x.i("MicroMsg.ConversationStorage", "deleteConversations:sql is %s", new Object[]{stringBuilder.toString()});
        this.gJP.fx("rconversation", stringBuilder.toString());
    }

    public final List<String> ciF() {
        List arrayList = new ArrayList();
        List<String> arrayList2 = new ArrayList();
        String str = "select username from rconversation";
        int i = 0;
        while (i < arrayList.size()) {
            String str2 = str + (i > 0 ? " and " : " where ") + "username != \"" + bh.ot((String) arrayList.get(i)) + "\"";
            i++;
            str = str2;
        }
        Cursor rawQuery = this.gJP.rawQuery(str + " order by flag desc, conversationTime desc", null);
        i = rawQuery.getColumnIndex("username");
        while (rawQuery.moveToNext()) {
            arrayList2.add(rawQuery.getString(i));
        }
        rawQuery.close();
        return arrayList2;
    }

    public final Cursor j(List<String> list, int i) {
        String str = "select username from rconversation";
        int i2 = 0;
        while (i2 < list.size()) {
            String str2 = str + (i2 > 0 ? " and " : " where ") + "username != \"" + bh.ot((String) list.get(i2)) + "\"";
            i2++;
            str = str2;
        }
        return this.gJP.rawQuery(str + " order by flag desc, conversationTime desc limit 50 offset " + i, null);
    }

    public final Cursor ciG() {
        return this.gJP.rawQuery("select * from rbottleconversation order by flag desc, conversationTime desc", null);
    }

    public final boolean AX(String str) {
        boolean z;
        Cursor a = this.gJP.a(WW(str), null, "username=?", new String[]{str}, null, null, null, 2);
        if (a.moveToFirst()) {
            z = true;
        } else {
            z = false;
        }
        a.close();
        return z;
    }

    public final Cursor Xh(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT username, unReadCount");
        stringBuilder.append(" FROM rconversation");
        stringBuilder.append(" WHERE username LIKE '%@chatroom' ");
        stringBuilder.append(bh.ou(str));
        stringBuilder.append(" AND unReadCount > 0");
        return this.gJP.rawQuery(stringBuilder.toString(), null);
    }

    public final Cursor fD(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select unReadCount");
        stringBuilder.append(" from rconversation where username").append(" = '").append(str).append("' AND ( parentRef is ").append(com.tencent.mm.m.a.gJf).append(" or parentRef = '' ) ").append(bh.ou(str2));
        return this.gJP.rawQuery(stringBuilder.toString(), null);
    }

    public final Cursor r(String str, List<String> list) {
        x.i("MicroMsg.ConversationStorage", "getTotalUnreadCursor filter[%s] [%s]", new Object[]{str, bh.cgy()});
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select sum(unReadCount) from rconversation").append(", rcontact");
        stringBuilder.append(" where rconversation.unReadCount").append(" > 0 AND (rconversation.parentRef").append(" is ").append(com.tencent.mm.m.a.gJf).append(" or parentRef = '' ) AND ").append("rconversation.username = ").append("rcontact.username").append(bh.ou(str)).append(" AND ( type & 512").append(" ) == 0 AND rcontact.").append("username != 'officialaccounts'");
        if (!(list == null || list.isEmpty())) {
            for (String append : list) {
                stringBuilder.append(" AND rconversation.username").append(" != '").append(append).append("'");
            }
        }
        x.v("MicroMsg.ConversationStorage", "get total unread with black list, sql is %s", new Object[]{stringBuilder.toString()});
        return this.gJP.rawQuery(stringBuilder.toString(), null);
    }

    public final Cursor s(String str, List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT COUNT(rconversation.username)");
        stringBuilder.append(" FROM rconversation, rcontact");
        stringBuilder.append(" WHERE unReadCount > 0");
        stringBuilder.append(" AND rconversation.username = rcontact.username");
        stringBuilder.append(bh.ou(str));
        stringBuilder.append(" AND ( type & 512").append(" ) == 0");
        stringBuilder.append(" AND ( attrflag & 2097152 ) == 0");
        stringBuilder.append(" AND ( ( parentRef is ").append(com.tencent.mm.m.a.gJf).append(" or parentRef = '' ) ");
        stringBuilder.append(" AND rcontact.username").append(" != 'officialaccounts')");
        x.i("MicroMsg.ConversationStorage", "get total unread talker, sql is %s", new Object[]{stringBuilder.toString()});
        return this.gJP.rawQuery(stringBuilder.toString(), null);
    }

    public final Cursor db(String str, int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT rconversation.username");
        stringBuilder.append(" FROM rconversation, rcontact");
        stringBuilder.append(" WHERE unReadCount > 0");
        stringBuilder.append(" AND rconversation.username = rcontact.username");
        stringBuilder.append(bh.ou(str));
        stringBuilder.append(" AND ( type & 512").append(" ) == 0");
        stringBuilder.append(" AND ( ( parentRef is ").append(com.tencent.mm.m.a.gJf).append(" or parentRef = '' ) ");
        stringBuilder.append(" AND rcontact.username").append(" != 'officialaccounts')");
        stringBuilder.append(" ORDER BY flag DESC, conversationTime").append(" DESC ");
        if (i > 0) {
            stringBuilder.append(" LIMIT ").append(String.valueOf(i));
        }
        x.i("MicroMsg.ConversationStorage", "get total unread talker, sql is %s", new Object[]{stringBuilder.toString()});
        return this.gJP.rawQuery(stringBuilder.toString(), null);
    }

    public final int ciH() {
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT SUM(rconversation.unReadCount").append(")");
        stringBuilder.append(" FROM rconversation");
        stringBuilder.append(" WHERE parentRef = 'officialaccounts").append("'");
        x.d("MicroMsg.ConversationStorage", "getTotalUnreadBizCount sql %s", new Object[]{stringBuilder.toString()});
        Cursor a = this.gJP.a(r1, null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                i = a.getInt(0);
            }
            a.close();
        }
        return i;
    }

    public final String ciI() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT rconversation.username");
        stringBuilder.append(" FROM rconversation");
        stringBuilder.append(" WHERE parentRef = 'officialaccounts").append("'");
        stringBuilder.append(" ORDER BY flag DESC, conversationTime").append(" DESC ");
        stringBuilder.append(" LIMIT 1 ");
        x.i("MicroMsg.ConversationStorage", "get last conversation user, sql is %s", new Object[]{stringBuilder.toString()});
        Cursor a = this.gJP.a(r1, null, 2);
        if (a == null) {
            return null;
        }
        if (a.moveToFirst()) {
            String string = a.getString(0);
            a.close();
            return string;
        }
        a.close();
        return null;
    }

    public final int Xi(String str) {
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT COUNT(*) FROM rconversation");
        stringBuilder.append(" WHERE parentRef = '").append(str).append("'");
        x.i("MicroMsg.ConversationStorage", "get enterprise conversation count, sql is %s", new Object[]{stringBuilder.toString()});
        Cursor a = this.gJP.a(r1, null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                i = a.getInt(0);
            }
            a.close();
        }
        return i;
    }

    public final String Xj(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT rconversation.username");
        stringBuilder.append(" FROM rconversation");
        stringBuilder.append(" WHERE parentRef = '").append(str).append("'");
        stringBuilder.append(" ORDER BY conversationTime DESC, conversationTime").append(" DESC ");
        stringBuilder.append(" LIMIT 1 ");
        x.i("MicroMsg.ConversationStorage", "get last enterprise conversation user, sql is %s", new Object[]{stringBuilder.toString()});
        Cursor a = this.gJP.a(r1, null, 2);
        if (a == null) {
            return null;
        }
        if (a.moveToFirst()) {
            String string = a.getString(0);
            a.close();
            return string;
        }
        a.close();
        return null;
    }

    public final Cursor ciJ() {
        x.i("MicroMsg.ConversationStorage", "get bottle total conversation unread sql is %s", new Object[]{"select count(*) from rbottleconversation where unReadCount > 0"});
        return this.gJP.rawQuery("select count(*) from rbottleconversation where unReadCount > 0", null);
    }

    public final int hv(String str) {
        int i = 0;
        Cursor a = this.gJP.a("select sum(unReadCount) from rconversation,rcontact where rconversation.username = rcontact.username" + bh.ou(str), null, 2);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        }
        a.close();
        return i;
    }

    public final ae ciK() {
        Cursor c = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Fd().c(s.hfk, null, "officialaccounts");
        if (c == null) {
            return null;
        }
        ae aeVar;
        if (c.getCount() <= 0 || !c.moveToFirst()) {
            aeVar = null;
        } else {
            aeVar = new ae();
            aeVar.b(c);
        }
        c.close();
        return aeVar;
    }

    public final ae Xk(String str) {
        Cursor c = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Fd().c(s.hfk, null, str);
        if (c == null) {
            return null;
        }
        ae aeVar;
        if (c.getCount() <= 0 || !c.moveToFirst()) {
            aeVar = null;
        } else {
            aeVar = new ae();
            aeVar.b(c);
        }
        c.close();
        return aeVar;
    }

    public final void d(String[] strArr, String str) {
        int i;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Update rconversation");
        stringBuilder.append(" set parentRef = '").append(bh.ou(str)).append("' where 1 != 1 ");
        for (i = 0; i <= 0; i++) {
            stringBuilder.append(" or username = '").append(strArr[0]).append("'");
        }
        x.d("MicroMsg.ConversationStorage", "update sql: %s", new Object[]{stringBuilder.toString()});
        if (this.gJP.fx("rconversation", stringBuilder.toString())) {
            for (i = 0; i <= 0; i++) {
                b(3, this, strArr[0]);
            }
        }
    }

    public final int Xl(String str) {
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select sum(atCount) from rconversation");
        stringBuilder.append(" where unReadCount > 0");
        if (!bh.ov(str)) {
            stringBuilder.append(" and username = '").append(str).append("'");
        }
        x.d("MicroMsg.ConversationStorage", "query sql: %s", new Object[]{stringBuilder.toString()});
        Cursor a = this.gJP.a(r1, null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                i = a.getInt(0);
            }
            a.close();
        }
        return i;
    }

    public final String aS(int i, String str) {
        if (bh.ov(str)) {
            return null;
        }
        switch (i) {
            case R$styleable.AppCompatTheme_actionButtonStyle /*49*/:
                Map y = bi.y(str, "msg");
                if (y == null) {
                    return null;
                }
                x.d("MicroMsg.ConversationStorage", "[oneliang][parseConversationMsgContentTitle] title:%s", new Object[]{(String) y.get(".msg.appmsg.title")});
                return (String) y.get(".msg.appmsg.title");
            default:
                return null;
        }
    }

    protected final boolean NE() {
        if (this.gJP != null && !this.gJP.cgM()) {
            return true;
        }
        String str = "MicroMsg.ConversationStorage";
        String str2 = "shouldProcessEvent db is close :%s";
        Object[] objArr = new Object[1];
        objArr[0] = this.gJP == null ? "null" : Boolean.valueOf(this.gJP.cgM());
        x.w(str, str2, objArr);
        return false;
    }

    public final void Xm(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Update rconversation");
        stringBuilder.append(" set parentRef = '', unReadCount = 0").append(" where username = \"" + bh.ot(str) + "\"");
        x.d("MicroMsg.ConversationStorage", "removeParentRefAndUnread sql: %s", new Object[]{stringBuilder.toString()});
        if (this.gJP.fx("rconversation", stringBuilder.toString())) {
            b(3, this, str);
        }
    }

    public final void Xn(String str) {
        x.d("MicroMsg.ConversationStorage", "delEnterpriseFatherAndChildConv %s %d", new Object[]{str, Integer.valueOf(this.gJP.delete(WW(str), "username=? or parentRef =?", new String[]{str, str}))});
        if (this.gJP.delete(WW(str), "username=? or parentRef =?", new String[]{str, str}) != 0) {
            b(5, this, str);
        }
    }

    public final int Xo(String str) {
        int i = -1;
        if (str != null && str.length() > 0) {
            Cursor a = this.gJP.a("select msgCount from rconversation where username=" + h.fe(str), null, 2);
            if (a.moveToFirst()) {
                i = a.getInt(0);
            }
            a.close();
        }
        return i;
    }
}
