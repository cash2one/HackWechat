package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.mm.a.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.protocal.c.akb;
import com.tencent.mm.protocal.c.aqs;
import com.tencent.mm.protocal.c.bjr;
import com.tencent.mm.protocal.c.bjv;
import com.tencent.mm.protocal.c.bkk;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;
import java.util.HashMap;
import java.util.List;

public final class m {
    private static final ThreadLocal<HashMap<String, Long>> qSb = new ThreadLocal();

    public static boolean JU(String str) {
        com.tencent.mm.plugin.sns.storage.m Lm = ae.bvv().Lm(str);
        return a(Lm, ai.n(Lm));
    }

    public static boolean h(com.tencent.mm.plugin.sns.storage.m mVar) {
        return a(mVar, ai.n(mVar));
    }

    public static boolean a(com.tencent.mm.plugin.sns.storage.m mVar, bjv com_tencent_mm_protocal_c_bjv) {
        aqs byi = mVar.byi();
        if (mVar.field_type != 21) {
            return true;
        }
        if (byi.fLD == 1) {
            return true;
        }
        if (q.FS().equals(mVar.field_userName)) {
            return true;
        }
        if (com_tencent_mm_protocal_c_bjv.wNo != null) {
            List<bjr> list = com_tencent_mm_protocal_c_bjv.wNo.wNR;
            if (list == null || list.size() == 0) {
                return false;
            }
            String FS = q.FS();
            for (bjr com_tencent_mm_protocal_c_bjr : list) {
                if (FS.equals(com_tencent_mm_protocal_c_bjr.vIy)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int i(com.tencent.mm.plugin.sns.storage.m mVar) {
        if (mVar == null) {
            return 0;
        }
        bjv n = ai.n(mVar);
        if (n == null) {
            return 0;
        }
        bkk com_tencent_mm_protocal_c_bkk = n.wNo;
        return (com_tencent_mm_protocal_c_bkk == null || com_tencent_mm_protocal_c_bkk.wNR.size() == 0) ? 0 : com_tencent_mm_protocal_c_bkk.wNR.size();
    }

    public static long j(com.tencent.mm.plugin.sns.storage.m mVar) {
        return b(mVar, null);
    }

    public static long b(com.tencent.mm.plugin.sns.storage.m mVar, bjv com_tencent_mm_protocal_c_bjv) {
        long j = 0;
        if (mVar == null) {
            return 0;
        }
        if (com_tencent_mm_protocal_c_bjv == null) {
            com_tencent_mm_protocal_c_bjv = ai.n(mVar);
        }
        if (com_tencent_mm_protocal_c_bjv == null) {
            return 0;
        }
        bkk com_tencent_mm_protocal_c_bkk = com_tencent_mm_protocal_c_bjv.wNo;
        if (com_tencent_mm_protocal_c_bkk == null) {
            return 0;
        }
        List<bjr> list = com_tencent_mm_protocal_c_bkk.wNR;
        if (list == null) {
            return 0;
        }
        String str = mVar.roI;
        if (bh.ov(str)) {
            Object obj = g.s(mVar.field_content) + g.s(mVar.field_attrBuf);
        } else {
            String str2 = str;
        }
        HashMap hashMap = (HashMap) qSb.get();
        if (hashMap != null && hashMap.containsKey(obj)) {
            return ((Long) hashMap.get(obj)).longValue();
        }
        for (bjr com_tencent_mm_protocal_c_bjr : list) {
            akb com_tencent_mm_protocal_c_akb = new akb();
            try {
                com_tencent_mm_protocal_c_akb.aF(n.a(com_tencent_mm_protocal_c_bjr.wMA));
            } catch (Exception e) {
                x.e("MicrMsg.SnsLuckyUtil", e.getMessage() + "hbBuffer is error");
            }
            j += com_tencent_mm_protocal_c_akb.fLR;
        }
        if (hashMap == null) {
            hashMap = new HashMap();
        }
        hashMap.put(obj, Long.valueOf(j));
        qSb.set(hashMap);
        return j;
    }
}
