package com.tencent.mm.plugin.backup.e;

import com.tencent.mm.plugin.backup.h.u;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.er;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import java.util.HashMap;
import java.util.LinkedList;

public final class h {
    public static er a(au auVar, boolean z, String str, PLong pLong, LinkedList<u> linkedList, HashMap<Long, a> hashMap, boolean z2, boolean z3, long j) {
        if (auVar.field_msgSvrId == 0) {
            x.e("MicroMsg.BackupMsgLogic", "packedMsg msgSvrId is 0, talker[%s], type[%d]", auVar.field_talker, Integer.valueOf(auVar.getType()));
            return null;
        }
        int i;
        er erVar;
        er erVar2 = new er();
        erVar2.vHe = auVar.field_msgSvrId;
        if (auVar.field_isSend == 1) {
            erVar2.vGX = new bdo().UA(str);
            erVar2.vGY = new bdo().UA(auVar.field_talker);
            i = 2;
            erVar = erVar2;
        } else {
            erVar2.vGX = new bdo().UA(auVar.field_talker);
            erVar2.vGY = new bdo().UA(str);
            if (z2) {
                i = 3;
                erVar = erVar2;
            } else {
                i = 4;
                erVar = erVar2;
            }
        }
        erVar.vKa = i;
        erVar2.vKf = new bdn();
        erVar2.vKg = 0;
        erVar2.vKh = 0;
        erVar2.vHc = "";
        erVar2.ktN = l.BG(auVar.getType());
        erVar2.vKb = (int) (auVar.field_createTime / 1000);
        erVar2.vKj = auVar.field_createTime;
        erVar2.vKi = (int) auVar.field_msgSeq;
        erVar2.vKk = auVar.field_flag;
        bdo com_tencent_mm_protocal_c_bdo = new bdo();
        com_tencent_mm_protocal_c_bdo.UA(bh.az(auVar.field_content, ""));
        erVar2.vGZ = com_tencent_mm_protocal_c_bdo;
        l mH = c.apq().mH(l.BG(auVar.getType()));
        if (mH == null) {
            x.d("MicroMsg.BackupMsgLogic", "packedMsg unknow type[%d]", Integer.valueOf(auVar.getType()));
            return null;
        }
        i = mH.a(erVar2, z, auVar, str, linkedList, hashMap, z3, j);
        if (i < 0) {
            return null;
        }
        pLong.value += (long) i;
        pLong.value += 60;
        return erVar2;
    }
}
