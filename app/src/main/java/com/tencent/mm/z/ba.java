package com.tencent.mm.z;

import android.content.SharedPreferences;
import android.database.Cursor;
import com.tencent.mm.ae.d;
import com.tencent.mm.ae.d.c;
import com.tencent.mm.g.a.cb;
import com.tencent.mm.g.a.jn;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import java.util.List;
import java.util.Map;

public final class ba {

    static class AnonymousClass1 implements Runnable {
        final int hgA = 30;
        final int hgB = 5;
        int hgC = 100;
        final /* synthetic */ List hgD;
        final int hgz = 200;

        public AnonymousClass1(List list) {
            this.hgD = list;
        }

        public final void run() {
            x.i("MicroMsg.MsgInfoStorageLogic", "summerdel checkUnfinishedDeleteMsgTask run currentThread[%s, %d] talkers size:%s", Thread.currentThread().getName(), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(this.hgD.size()));
            for (String str : this.hgD) {
                long Es = ((h) g.h(h.class)).FJ().Es(str);
                if (Es > 0) {
                    long Wp = bh.Wp();
                    long j = 0;
                    int i = 0;
                    while (true) {
                        int i2;
                        if (this.hgC < 200 && this.hgC > 30) {
                            if (j > 500) {
                                i2 = this.hgC - 5;
                            } else {
                                i2 = this.hgC + 5;
                            }
                            this.hgC = i2;
                        }
                        long Wp2 = bh.Wp();
                        Cursor e = ((h) g.h(h.class)).aZi().e(str, this.hgC, Es);
                        long j2 = 0;
                        long j3 = 0;
                        while (e.moveToNext()) {
                            cf auVar = new au();
                            auVar.b(e);
                            if (j2 < auVar.field_createTime) {
                                j2 = auVar.field_createTime;
                            }
                            j = 1 + j3;
                            ba.j(auVar);
                            j3 = j;
                        }
                        e.close();
                        long Wp3 = bh.Wp();
                        if (j2 > 0 && j3 > 0) {
                            ((h) g.h(h.class)).aZi().N(str, j2);
                        }
                        j = bh.Wp() - Wp2;
                        x.i("MicroMsg.MsgInfoStorageLogic", "summerdel checkUnfinishedDeleteMsgTask:%s delCnt:%d curCnt:%d msgTimeDiff:%d(%d) run:[%d,%d,%d](%d)", bh.VT(str), Integer.valueOf((int) (((long) i) + j3)), Long.valueOf(j3), Long.valueOf(Es - j2), Long.valueOf(Es), Long.valueOf(r20 - Wp3), Long.valueOf(r20 - Wp2), Long.valueOf(bh.Wp() - Wp), Integer.valueOf(this.hgC));
                        if (j3 <= 0) {
                            break;
                        }
                        i = i2;
                    }
                    ((h) g.h(h.class)).FJ().D(str, 0);
                }
            }
        }
    }

    static class AnonymousClass5 implements Runnable {
        final /* synthetic */ List hgD;

        public AnonymousClass5(List list) {
            this.hgD = list;
        }

        public final void run() {
            x.i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker run currentThread[%s, %d] talkers size:%s", Thread.currentThread().getName(), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(this.hgD.size()));
            for (String str : this.hgD) {
                cf Ex = ((h) g.h(h.class)).aZi().Ex(str);
                long j = Ex == null ? Long.MAX_VALUE : Ex.field_createTime;
                if (Ex != null && Ex.field_createTime > 0) {
                    ((h) g.h(h.class)).FJ().D(str, j);
                }
                x.i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker talker[%s] lastMsg[%s] lastMsgCreateTime[%s]", str, Ex, Long.valueOf(j));
                Cursor EG = ((h) g.h(h.class)).aZi().EG(str);
                if (EG != null) {
                    if (EG.moveToFirst()) {
                        while (!EG.isAfterLast()) {
                            au auVar = new au();
                            auVar.b(EG);
                            ba.j(auVar);
                            EG.moveToNext();
                        }
                    }
                    EG.close();
                    int ED = ((h) g.h(h.class)).aZi().ED(str);
                    x.i("MicroMsg.MsgInfoStorageLogic", "delete msgs %s, %d", str, Integer.valueOf(ED));
                    ((h) g.h(h.class)).FJ().D(str, 0);
                }
            }
        }
    }

    public interface a {
        void HA();

        boolean HB();
    }

    public static class b {
        public String hgF;
        public String hgG;
        public String hgH;
        public String hgI;
        public String hgJ;
        public String hgK;
        public String hgL;
        public String hgM;
        public String hgN;
        public String hgO;
        public int hgP;
        public int hgQ;
        public int hgR;
        public int hgS;
        public String hgT;
        public int scene = 0;
        public String userId;
    }

    public static String T(String str, String str2) {
        if (bh.ov(str)) {
            return null;
        }
        return !bh.ov(str2) ? str2 + ": " + str : str;
    }

    public static int hO(String str) {
        if (str == null) {
            x.e("MicroMsg.MsgInfoStorageLogic", "dz[getGroupChatMsgTalkerPos text is null]");
            return -1;
        } else if (str.length() <= 0) {
            x.e("MicroMsg.MsgInfoStorageLogic", "dz[getGroupChatMsgTalkerPos length < 0]");
            return -1;
        } else if (str.startsWith("~SEMI_XML~")) {
            x.e("MicroMsg.MsgInfoStorageLogic", "dz[getGroupChatMsgTalkerPos startsWith(SemiXml.MAGIC_HEAD)]");
            return -1;
        } else {
            int indexOf = str.indexOf(58);
            if (indexOf == -1 || !str.substring(0, indexOf).contains("<")) {
                return indexOf;
            }
            x.e("MicroMsg.MsgInfoStorageLogic", "dz[reject illegal character]");
            return -1;
        }
    }

    public static String hP(String str) {
        int hO = hO(str);
        if (hO == -1) {
            return null;
        }
        return str.substring(0, hO);
    }

    public static String hQ(String str) {
        int hO = hO(str);
        return (hO != -1 && hO + 2 < str.length()) ? str.substring(hO + 2) : str;
    }

    public static long i(au auVar) {
        com.tencent.mm.l.a WO = ((h) g.h(h.class)).EY().WO(auVar.field_talker);
        if (WO == null || ((int) WO.gJd) == 0) {
            com.tencent.mm.storage.x xVar = new com.tencent.mm.storage.x(auVar.field_talker);
            xVar.setType(2);
            com.tencent.mm.sdk.b.b jnVar = new jn();
            jnVar.fAg.fAh = xVar;
            com.tencent.mm.sdk.b.a.xef.m(jnVar);
            ((h) g.h(h.class)).EY().R(xVar);
        }
        return ((h) g.h(h.class)).aZi().Q(auVar);
    }

    public static boolean gS(int i) {
        switch (i) {
            case 22:
            case 23:
            case 24:
            case 26:
            case 27:
            case 28:
            case 29:
                return true;
            default:
                return false;
        }
    }

    public static long Hw() {
        long currentTimeMillis = System.currentTimeMillis();
        x.i("MicroMsg.MsgInfoStorageLogic", "[oneliang] fix send msg create time, before fix, now is :%s", Long.valueOf(currentTimeMillis));
        SharedPreferences sharedPreferences = ac.getContext().getSharedPreferences("system_config_prefs", 4);
        int i = sharedPreferences.getInt("client_server_diff_time_enable", 0);
        int i2 = sharedPreferences.getInt("client_server_diff_time_interval", 0);
        if (i <= 0 || i2 <= 0) {
            return currentTimeMillis;
        }
        g.Dk();
        Object obj = g.Dj().CU().get(com.tencent.mm.storage.w.a.USERINFO_CLIENT_SERVER_DIFF_TIME_LONG, null);
        if (obj == null) {
            return currentTimeMillis;
        }
        long j = bh.getLong(obj.toString(), 0);
        if (Math.abs(j / 1000) > ((long) i2)) {
            return currentTimeMillis - j;
        }
        return currentTimeMillis;
    }

    public static long hR(String str) {
        long Hw = Hw();
        x.i("MicroMsg.MsgInfoStorageLogic", "[oneliang] fix send msg create time, after fix, now is :%s", Long.valueOf(Hw));
        if (str != null) {
            cf Ex = ((h) g.h(h.class)).aZi().Ex(str);
            if (Ex != null) {
                x.i("MicroMsg.MsgInfoStorageLogic", "[oneliang] fix send msg create time, before return, msg id:%s, now is :%s", Long.valueOf(Ex.field_msgId), Long.valueOf(Hw));
                if (Ex.field_createTime + 1 > Hw) {
                    return Ex.field_createTime + 1;
                }
            }
        }
        return Hw;
    }

    public static long n(String str, long j) {
        long j2;
        if (str != null) {
            cf Ex = ((h) g.h(h.class)).aZi().Ex(str);
            if (Ex != null) {
                j2 = Ex.field_createTime + 1;
                return j2 <= j * 1000 ? j2 : j * 1000;
            }
        }
        j2 = 0;
        if (j2 <= j * 1000) {
        }
    }

    public static void j(au auVar) {
        if (auVar != null) {
            int type = auVar.getType();
            switch (type) {
                case -1879048191:
                case -1879048190:
                case -1879048189:
                    type = 49;
                    break;
            }
            d aU = c.aU(Integer.valueOf(type));
            if (aU != null) {
                aU.h(auVar);
            }
            com.tencent.mm.sdk.b.b cbVar = new cb();
            cbVar.fql.fqm = auVar.field_msgId;
            cbVar.fql.talker = auVar.field_talker;
            cbVar.fql.msgType = auVar.getType();
            com.tencent.mm.sdk.b.a.xef.m(cbVar);
        }
    }

    public static void E(List<Long> list) {
        if (list.size() != 0) {
            for (Long longValue : list) {
                aK(longValue.longValue());
            }
        }
    }

    public static int aK(long j) {
        cf dH = ((h) g.h(h.class)).aZi().dH(j);
        if (dH.field_msgId != j) {
            return 0;
        }
        j(dH);
        return ((h) g.h(h.class)).aZi().dI(j);
    }

    public static int o(String str, long j) {
        cf F = ((h) g.h(h.class)).aZi().F(str, j);
        if (F.field_msgSvrId != j) {
            return 0;
        }
        j(F);
        return ((h) g.h(h.class)).aZi().M(str, j);
    }

    public static int hS(String str) {
        return ((h) g.h(h.class)).aZi().ED(str);
    }

    public static int a(final String str, final a aVar) {
        x.i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker[%s] stack[%s]", str, bh.cgy());
        e.post(new Runnable() {
            final int hgA = 30;
            final int hgB = 5;
            int hgC = 100;
            final int hgz = 200;

            public final void run() {
                cf Ex = ((h) g.h(h.class)).aZi().Ex(str);
                long j = Ex == null ? Long.MAX_VALUE : Ex.field_createTime;
                if (Ex != null && Ex.field_createTime > 0) {
                    ((h) g.h(h.class)).FJ().D(str, j);
                }
                x.i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker run currentThread[%s, %d] lastMsg[%s] lastMsgCreateTime[%s]", Thread.currentThread().getName(), Long.valueOf(Thread.currentThread().getId()), Ex, Long.valueOf(j));
                long Wp = bh.Wp();
                int i = 0;
                long j2 = 0;
                long j3;
                do {
                    if (this.hgC < 200 && this.hgC > 30) {
                        int i2;
                        if (j2 > 500) {
                            i2 = this.hgC - 5;
                        } else {
                            i2 = this.hgC + 5;
                        }
                        this.hgC = i2;
                    }
                    long Wp2 = bh.Wp();
                    Cursor e = ((h) g.h(h.class)).aZi().e(str, this.hgC, j);
                    long j4 = 0;
                    j3 = 0;
                    while (e.moveToNext()) {
                        cf auVar = new au();
                        auVar.b(e);
                        if (j4 < auVar.field_createTime) {
                            j4 = auVar.field_createTime;
                        }
                        j2 = 1 + j3;
                        ba.j(auVar);
                        j3 = j2;
                    }
                    e.close();
                    long Wp3 = bh.Wp();
                    if (j4 > 0 && j3 > 0) {
                        ((h) g.h(h.class)).aZi().N(str, j4);
                    }
                    i = (int) (((long) i) + j3);
                    j2 = bh.Wp() - Wp2;
                    x.i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker:%s delCnt:%d curCnt:%d msgTimeDiff:%d(%d) run:[%d,%d,%d](%d)", bh.VT(str), Integer.valueOf(i), Long.valueOf(j3), Long.valueOf(j - j4), Long.valueOf(j), Long.valueOf(bh.Wp() - Wp3), Long.valueOf(bh.Wp() - Wp2), Long.valueOf(bh.Wp() - Wp), Integer.valueOf(this.hgC));
                } while (j3 > 0);
                ((h) g.h(h.class)).FJ().D(str, 0);
            }
        }, "deleteMsgByTalker");
        ag.y(new Runnable() {
            public final void run() {
                if (aVar != null) {
                    aVar.HA();
                }
            }
        });
        return 0;
    }

    public static void a(final a aVar) {
        g.Dk();
        g.Dm().F(new Runnable() {
            public final void run() {
                if (aVar == null || !aVar.HB()) {
                    ((h) g.h(h.class)).Fd().ciz();
                    if (aVar == null || !aVar.HB()) {
                        ba.Hy();
                        if (aVar == null || !aVar.HB()) {
                            ba.Hz();
                            if (aVar == null || !aVar.HB()) {
                                ba.Hx();
                                if (aVar == null || !aVar.HB()) {
                                    List EA = ((h) g.h(h.class)).aZi().EA("message");
                                    if (EA != null) {
                                        for (int i = 0; i < EA.size(); i++) {
                                            ba.j((au) EA.get(i));
                                        }
                                    }
                                    ((h) g.h(h.class)).aZi().EC("message");
                                }
                            }
                        }
                    }
                }
                if (aVar != null) {
                    ag.y(new Runnable(this) {
                        final /* synthetic */ AnonymousClass4 hgE;

                        {
                            this.hgE = r1;
                        }

                        public final void run() {
                            aVar.HA();
                        }
                    });
                }
            }

            public final String toString() {
                return super.toString() + "|deleteAllMsg";
            }
        });
    }

    public static void Hx() {
        List EA = ((h) g.h(h.class)).aZi().EA("bottlemessage");
        if (EA != null) {
            for (int i = 0; i < EA.size(); i++) {
                j((au) EA.get(i));
            }
        }
        ((h) g.h(h.class)).aZi().EC("bottlemessage");
    }

    public static void Hy() {
        List EA = ((h) g.h(h.class)).aZi().EA("qmessage");
        if (EA != null) {
            for (int i = 0; i < EA.size(); i++) {
                j((au) EA.get(i));
            }
        }
        ((h) g.h(h.class)).aZi().EC("qmessage");
    }

    public static void Hz() {
        List EA = ((h) g.h(h.class)).aZi().EA("tmessage");
        if (EA != null) {
            for (int i = 0; i < EA.size(); i++) {
                j((au) EA.get(i));
            }
        }
        ((h) g.h(h.class)).aZi().EC("tmessage");
    }

    public static b hT(String str) {
        if (bh.ov(str)) {
            return null;
        }
        try {
            Map y = bi.y(str, "msgsource");
            if (y == null || y.isEmpty()) {
                return null;
            }
            b bVar = new b();
            bVar.hgF = (String) y.get(".msgsource.bizmsg.msgcluster");
            bVar.hgH = (String) y.get(".msgsource.kf.kf_worker");
            bVar.hgG = bh.ou((String) y.get(".msgsource.bizmsg.bizclientmsgid"));
            bVar.hgJ = bh.ou((String) y.get(".msgsource.enterprise_info.qy_msg_type"));
            bVar.hgK = bh.ou((String) y.get(".msgsource.enterprise_info.bizchat_id"));
            bVar.hgL = bh.ou((String) y.get(".msgsource.enterprise_info.bizchat_ver"));
            bVar.userId = bh.ou((String) y.get(".msgsource.enterprise_info.user_id"));
            bVar.hgM = bh.ou((String) y.get(".msgsource.enterprise_info.user_nickname"));
            bVar.hgN = bh.ou((String) y.get(".msgsource.enterprise_info.sync_from_qy_im"));
            bVar.hgI = (String) y.get(".msgsource.strangerantispamticket.$ticket");
            bVar.scene = bh.getInt((String) y.get(".msgsource.strangerantispamticket.$scene"), 0);
            bVar.hgO = (String) y.get(".msgsource.NotAutoDownloadRange");
            bVar.hgP = bh.getInt((String) y.get(".msgsource.DownloadLimitKbps"), 0);
            bVar.hgQ = bh.getInt((String) y.get(".msgsource.videopreloadlen"), 0);
            bVar.hgR = bh.getInt((String) y.get(".msgsource.PreDownload"), 0);
            bVar.hgS = bh.getInt((String) y.get(".msgsource.PreDownloadNetType"), 0);
            bVar.hgT = (String) y.get(".msgsource.NoPreDownloadRange");
            return bVar;
        } catch (Throwable e) {
            x.e("MicroMsg.MsgInfoStorageLogic", "exception:%s", bh.i(e));
            x.e("MicroMsg.MsgInfoStorageLogic", "Exception in getMsgSourceValue, %s", e.getMessage());
            return null;
        }
    }

    public static String hU(String str) {
        b hT = hT(str);
        if (hT == null) {
            return null;
        }
        return hT.hgH;
    }

    public static void a(au auVar, com.tencent.mm.ae.d.a aVar) {
        if (auVar == null || aVar == null || aVar.hmq == null) {
            x.e("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvMsgWithAddMsgInfo error input is null, stack[%s]", bh.cgy());
        } else if (auVar.field_msgSvrId == aVar.hmq.vHe) {
            bw bwVar = aVar.hmq;
            if (auVar.field_isSend == 0 || bwVar.vHf != 0) {
                if (auVar.field_msgSeq == 0 && bwVar.vHf != 0) {
                    auVar.as((long) bwVar.vHf);
                }
                int i = auVar.field_flag;
                if (aVar.hmr) {
                    i |= 2;
                } else {
                    i &= -3;
                }
                if (aVar.hms) {
                    i |= 1;
                } else {
                    i &= -2;
                }
                if (aVar.hmt) {
                    i |= 4;
                } else {
                    i &= -5;
                }
                auVar.fa(i);
                if (auVar.field_msgId == 0 && aVar.hmr) {
                    auVar.aq(a(auVar.field_talker, (long) aVar.hmq.pbl, aVar.hmt, (long) aVar.hmq.vHf));
                }
            }
        }
    }

    public static int c(com.tencent.mm.ae.d.a aVar) {
        int i = 0;
        if (aVar.hmr) {
            i = 2;
        }
        if (aVar.hms) {
            i |= 1;
        }
        if (aVar.hmt) {
            return i | 4;
        }
        return i;
    }

    public static long a(String str, long j, boolean z, long j2) {
        long j3 = j * 1000;
        long j4 = 0;
        long j5 = -1;
        cf cfVar = null;
        if (str != null) {
            cfVar = ((h) g.h(h.class)).aZi().Ex(str);
            if (cfVar != null) {
                j4 = cfVar.field_createTime;
            }
            j5 = ((h) g.h(h.class)).aZi().ER(str);
        }
        if (j5 == j4) {
            return j3 == j4 ? j3 + 1 : j3;
        } else {
            if (j5 >= j4) {
                x.w("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvMsgCreateTime first > last [%d > %d], ret serverMillTime:%d", Long.valueOf(j5), Long.valueOf(j4), Long.valueOf(j3));
                return j3;
            } else if (j3 == j5) {
                return j3 - 1;
            } else {
                if (j3 == j4) {
                    return j3 + 1;
                }
                if (z || j2 == 0 || j3 > j4) {
                    return j3;
                }
                cf H = ((h) g.h(h.class)).aZi().H(str, j3);
                if (H.field_msgSeq == 0 || H.field_msgSeq == j2) {
                    j5 = j3;
                } else {
                    j5 = H.field_msgSeq < j2 ? 1 + j3 : j3 - 1;
                    x.i("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvGetMsgCreateTime 1 seq[%d, %d] need fix serverMillTime[%d]", Long.valueOf(H.field_msgSeq), Long.valueOf(j2), Long.valueOf(j5));
                    if (!(j5 != j4 || cfVar == null || cfVar.field_msgSeq == 0)) {
                        j5 = cfVar.field_msgSeq < j2 ? 1 + j4 : j4 - 1;
                        x.i("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvGetMsgCreateTime 2 seq[%d, %d] need fix serverMillTime[%d]", Long.valueOf(cfVar.field_msgSeq), Long.valueOf(j2), Long.valueOf(j5));
                    }
                }
                return j5;
            }
        }
    }
}
