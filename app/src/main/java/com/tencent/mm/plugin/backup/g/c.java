package com.tencent.mm.plugin.backup.g;

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

public final class c {
    public static void k(HashMap<String, Integer> hashMap) {
        x.i("MicroMsg.BackupStorageLogic", "buildConversation, unReadSum size[%d]", new Object[]{Integer.valueOf(hashMap.size())});
        for (String str : hashMap.keySet()) {
            cf dk = d.aqe().aqf().Fa().dk(str, " and not ( type = 10000 and isSend != 2 ) ");
            if (dk != null) {
                int intValue = ((Integer) hashMap.get(str)).intValue();
                String str2 = dk.field_talker;
                x.i("MicroMsg.BackupStorageLogic", "updateConvFromLastMsg, talker:%s, addUnreadCount:%d", new Object[]{str2, Integer.valueOf(intValue)});
                aj WY = d.aqe().aqf().Fd().WY(str2);
                if (WY == null || WY.field_conversationTime <= dk.field_createTime || WY.field_conversationTime == Long.MAX_VALUE) {
                    aj aeVar;
                    boolean z;
                    if (WY == null) {
                        aeVar = new ae(str2);
                        z = true;
                    } else {
                        aeVar = WY;
                        z = false;
                    }
                    aeVar.eR(dk.field_isSend);
                    aeVar.eO(intValue + aeVar.field_unReadCount);
                    aeVar.ac(dk);
                    aeVar.dE(Integer.toString(dk.getType()));
                    aeVar.ak((aeVar.field_flag & 4611686018427387904L) | (dk.field_createTime & 72057594037927935L));
                    aeVar.eN(0);
                    x.i("MicroMsg.BackupStorageLogic", "updateConvFromLastMsg, isNewConv[%b], talker[%s], flag[%d]", new Object[]{Boolean.valueOf(z), str2, Long.valueOf(aeVar.field_flag)});
                    if (z) {
                        d.aqe().aqf().Fd().d(aeVar);
                    } else {
                        d.aqe().aqf().Fd().a(aeVar, str2);
                    }
                } else {
                    x.e("MicroMsg.BackupStorageLogic", "updateConvFromLastMsg ignore(maybe the system time is bigger than normal)");
                }
            }
        }
        d.aqe().aqf().Fd().ciC();
    }

    public static boolean eV(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        return str.endsWith("@chatroom");
    }

    public static long i(au auVar) {
        a WO = d.aqe().aqf().EY().WO(auVar.field_talker);
        if (WO == null || ((int) WO.gJd) == 0) {
            if (!bh.ov(auVar.field_talker)) {
                d.aqe().aqg().e(2, auVar.field_talker);
                d.aqe().aqf().EY().R(new com.tencent.mm.storage.x(auVar.field_talker));
            } else if (auVar.field_talker.endsWith("@chatroom")) {
                b aqf = d.aqe().aqf();
                if (aqf.uin == 0) {
                    throw new b();
                } else if (aqf.kpS.hH(auVar.field_talker) == null) {
                    d.aqe().aqg().e(2, auVar.field_talker);
                }
            }
        }
        long Q = d.aqe().aqf().Fa().Q(auVar);
        if (Q < 0) {
            x.e("MicroMsg.BackupStorageLogic", "insertMsgWithContact faile: type:%d, talker:%s", new Object[]{Integer.valueOf(auVar.getType()), auVar.field_talker});
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
        return d.aqe().aqf().TU().nr(str);
    }

    public static String vy(String str) {
        b aqf = d.aqe().aqf();
        if (aqf.uin == 0) {
            throw new b();
        }
        String a = i.a(aqf.gQi + "voice2/", "msg_", str, ".amr", 2);
        if (bh.ov(a)) {
            return null;
        }
        if (new File(a).exists()) {
            return a;
        }
        StringBuilder stringBuilder = new StringBuilder();
        b aqf2 = d.aqe().aqf();
        if (aqf2.uin == 0) {
            throw new b();
        }
        String stringBuilder2 = stringBuilder.append(aqf2.gQi + "voice/").append(str).toString();
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
