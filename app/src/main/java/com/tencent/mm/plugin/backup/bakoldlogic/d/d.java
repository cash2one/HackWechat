package com.tencent.mm.plugin.backup.bakoldlogic.d;

import com.tencent.mm.g.b.aj;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.l.a;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.b;
import java.io.File;
import java.util.HashMap;

public final class d {
    public static void k(HashMap<String, Integer> hashMap) {
        for (String str : hashMap.keySet()) {
            cf dk = b.aqJ().aqK().Fa().dk(str, " and not ( type = 10000 and isSend != 2 ) ");
            if (dk != null) {
                int intValue = ((Integer) hashMap.get(str)).intValue();
                String str2 = dk.field_talker;
                x.i("MicroMsg.BakOldTempStorageLogic", "talker:%s, addUnreadCount:%d", new Object[]{str2, Integer.valueOf(intValue)});
                aj WY = b.aqJ().aqK().Fd().WY(str2);
                if (WY == null || WY.field_conversationTime <= dk.field_createTime || WY.field_conversationTime == Long.MAX_VALUE) {
                    int i;
                    if (WY == null) {
                        x.i("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg conversation is null.");
                        x.d("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg cvs:%s", new Object[]{str2});
                        WY = new ae(str2);
                        i = 1;
                    } else {
                        i = 0;
                    }
                    WY.eR(dk.field_isSend);
                    WY.eO(intValue + WY.field_unReadCount);
                    WY.ac(dk);
                    WY.dE(Integer.toString(dk.getType()));
                    WY.ak((WY.field_flag & 4611686018427387904L) | (dk.field_createTime & 72057594037927935L));
                    WY.eN(0);
                    if (i != 0) {
                        x.d("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg cvs:%s, cvs.flag:%d", new Object[]{str2, Long.valueOf(WY.field_flag)});
                        b.aqJ().aqK().Fd().d(WY);
                    } else {
                        b.aqJ().aqK().Fd().a(WY, str2);
                    }
                } else {
                    x.i("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg ignore(maybe the system time is bigger than normal)");
                }
            }
        }
        b.aqJ().aqK().Fd().ciC();
    }

    public static boolean eV(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        return str.endsWith("@chatroom");
    }

    public static long i(au auVar) {
        a WO = b.aqJ().aqK().EY().WO(auVar.field_talker);
        if (WO == null || ((int) WO.gJd) == 0) {
            if (!bh.ov(auVar.field_talker)) {
                b.aqJ().aqL().e(2, auVar.field_talker);
                b.aqJ().aqK().EY().R(new com.tencent.mm.storage.x(auVar.field_talker));
            } else if (auVar.field_talker.endsWith("@chatroom")) {
                c aqK = b.aqJ().aqK();
                if (aqK.uin == 0) {
                    throw new b();
                } else if (aqK.kpS.hH(auVar.field_talker) == null) {
                    b.aqJ().aqL().e(2, auVar.field_talker);
                }
            }
        }
        long Q = b.aqJ().aqK().Fa().Q(auVar);
        if (Q < 0) {
            x.e("MicroMsg.BakOldTempStorageLogic", "insertMsgWithContact faile: type:%d, talker:%s", new Object[]{Integer.valueOf(auVar.getType()), auVar.field_talker});
        }
        return Q;
    }

    public static int hO(String str) {
        if (str == null || str.length() <= 0) {
            return -1;
        }
        int indexOf = str.indexOf(58);
        if (indexOf == -1 || !str.substring(0, indexOf).contains("<")) {
            return indexOf;
        }
        return -1;
    }

    public static r vx(String str) {
        if (bh.ov(str)) {
            return null;
        }
        return b.aqJ().aqK().TU().nr(str);
    }

    public static String vy(String str) {
        c aqK = b.aqJ().aqK();
        if (aqK.uin == 0) {
            throw new b();
        }
        String a = i.a(aqK.gQi + "voice2/", "msg_", str, ".amr", 2);
        if (bh.ov(a)) {
            return null;
        }
        if (new File(a).exists()) {
            return a;
        }
        StringBuilder stringBuilder = new StringBuilder();
        c aqK2 = b.aqJ().aqK();
        if (aqK2.uin == 0) {
            throw new b();
        }
        String stringBuilder2 = stringBuilder.append(aqK2.gQi + "voice/").append(str).toString();
        if (new File(stringBuilder2 + ".amr").exists()) {
            k.q(stringBuilder2 + ".amr", a, true);
            return a;
        } else if (!new File(stringBuilder2).exists()) {
            return a;
        } else {
            k.q(stringBuilder2, a, true);
            return a;
        }
    }
}
