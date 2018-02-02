package com.tencent.mm.ui.chatting.b;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewStub;
import com.tencent.mm.a.e;
import com.tencent.mm.g.b.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.u;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;

public final class g {
    public static void a(p pVar, au auVar, Intent intent) {
        if (pVar != null && auVar != null) {
            String str;
            int i;
            Bundle bundle;
            String crz = pVar.crz();
            String str2 = pVar.csi().field_username;
            if (pVar.cse() || pVar.csf()) {
                if (pVar.cse()) {
                    String hP = ba.hP(auVar.field_content);
                    if (str2 == null || hP == null || hP.length() <= 0) {
                        hP = str2;
                    }
                    str2 = hP;
                } else if (auVar != null) {
                    str2 = auVar.field_bizChatUserId;
                }
            }
            Bundle bundle2 = new Bundle();
            if (pVar.cse()) {
                str = "stat_scene";
                i = 2;
                bundle = bundle2;
            } else {
                str = "stat_scene";
                if (s.gF(crz)) {
                    i = 7;
                    bundle = bundle2;
                } else {
                    i = 1;
                    bundle = bundle2;
                }
            }
            bundle.putInt(str, i);
            bundle2.putString("stat_msg_id", "msg_" + Long.toString(auVar.field_msgSvrId));
            bundle2.putString("stat_chat_talker_username", crz);
            bundle2.putString("stat_send_msg_user", str2);
            intent.putExtra("_stat_obj", bundle2);
        }
    }

    public static boolean c(au auVar, String str) {
        if (System.currentTimeMillis() - auVar.field_createTime <= 259200000 || (!bh.ov(str) && e.bO(str))) {
            return false;
        }
        return true;
    }

    public static boolean V(x xVar) {
        return xVar.field_username.equals("medianote") && (q.FW() & 16384) == 0;
    }

    public static ViewStub a(u uVar, int i) {
        ViewStub viewStub = (ViewStub) uVar.findViewById(i);
        if (viewStub != null) {
            viewStub.inflate();
        }
        return viewStub;
    }

    public static boolean Zi(String str) {
        int i = -1;
        if (s.gE(str) || !s.gx(str) || q.gr(str)) {
            return false;
        }
        int i2;
        ar.Hg();
        af WO = c.EY().WO(str);
        if (WO != null) {
            i2 = WO.field_type;
            ar.Hg();
            WO = c.EY().WO(WO.field_encryptUsername);
            if (WO != null) {
                i = WO.field_type;
            }
        } else {
            i2 = -1;
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.ChattingLogic", "isStranger:%s type:%d etype:%d", new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i)});
        return true;
    }
}
