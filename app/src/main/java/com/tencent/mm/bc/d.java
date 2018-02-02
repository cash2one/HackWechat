package com.tencent.mm.bc;

import android.content.SharedPreferences;
import android.util.Base64;
import com.tencent.mm.protocal.c.asp;
import com.tencent.mm.protocal.c.asq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import java.io.IOException;
import java.util.Collections;

public final class d {
    public static asq hKE;

    public static asq QX() {
        if (hKE == null) {
            String QV = QV();
            hKE = new asq();
            QV = ac.getContext().getSharedPreferences("fts_recent_biz_sp", 0).getString(QV, "");
            if (!bh.ov(QV)) {
                try {
                    hKE.aF(Base64.decode(QV.getBytes(), 0));
                } catch (IOException e) {
                }
            }
        }
        return hKE;
    }

    private static String QV() {
        return "key_pb_most_search_biz_list" + q.FS();
    }

    public static void lT(String str) {
        if (s.gF(str)) {
            asp com_tencent_mm_protocal_c_asp;
            if (hKE == null) {
                QX();
            }
            long currentTimeMillis = System.currentTimeMillis();
            asp com_tencent_mm_protocal_c_asp2 = null;
            int i = 0;
            while (i < hKE.ksP.size()) {
                com_tencent_mm_protocal_c_asp = (asp) hKE.ksP.get(i);
                long j = (currentTimeMillis - com_tencent_mm_protocal_c_asp.wAh) / 86400000;
                com_tencent_mm_protocal_c_asp.wAg *= Math.pow(0.98d, (double) j);
                com_tencent_mm_protocal_c_asp.wAh = (j * 86400000) + com_tencent_mm_protocal_c_asp.wAh;
                x.d("MicroMsg.FTS.FTSMostSearchBizLogic", "after update: %.2f %d %s", new Object[]{Double.valueOf(com_tencent_mm_protocal_c_asp.wAg), Long.valueOf(com_tencent_mm_protocal_c_asp.wAh), com_tencent_mm_protocal_c_asp.vIy});
                if (!com_tencent_mm_protocal_c_asp.vIy.equals(str)) {
                    com_tencent_mm_protocal_c_asp = com_tencent_mm_protocal_c_asp2;
                }
                i++;
                com_tencent_mm_protocal_c_asp2 = com_tencent_mm_protocal_c_asp;
            }
            if (com_tencent_mm_protocal_c_asp2 == null) {
                com_tencent_mm_protocal_c_asp = new asp();
                com_tencent_mm_protocal_c_asp.wAg = 1.0d;
                com_tencent_mm_protocal_c_asp.wAh = currentTimeMillis;
                com_tencent_mm_protocal_c_asp.vIy = str;
                hKE.ksP.add(com_tencent_mm_protocal_c_asp);
                x.i("MicroMsg.FTS.FTSMostSearchBizLogic", "add new use %s", new Object[]{str});
            } else {
                com_tencent_mm_protocal_c_asp2.wAg += 1.0d;
                x.i("MicroMsg.FTS.FTSMostSearchBizLogic", "update use %s %.2f", new Object[]{str, Double.valueOf(com_tencent_mm_protocal_c_asp2.wAg)});
            }
            Collections.sort(hKE.ksP, new 1());
            for (int size = hKE.ksP.size() - 1; size < hKE.ksP.size() && hKE.ksP.size() > 8; size++) {
                if (((asp) hKE.ksP.get(size)).wAg < 0.5d) {
                    hKE.ksP.remove(size);
                }
            }
            SharedPreferences sharedPreferences = ac.getContext().getSharedPreferences("fts_recent_biz_sp", 0);
            try {
                sharedPreferences.edit().putString(QV(), Base64.encodeToString(hKE.toByteArray(), 0)).commit();
                x.i("MicroMsg.FTS.FTSMostSearchBizLogic", "useBiz pbListString %s", new Object[]{r2});
            } catch (IOException e) {
            }
        }
    }
}
