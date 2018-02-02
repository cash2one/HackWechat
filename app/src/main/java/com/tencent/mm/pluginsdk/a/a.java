package com.tencent.mm.pluginsdk.a;

import android.os.Bundle;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.modelsimple.v$a;
import com.tencent.mm.protocal.c.bin;
import com.tencent.mm.protocal.c.bmg;
import com.tencent.mm.protocal.i.d;
import com.tencent.mm.protocal.i.e;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.Iterator;

public final class a {
    public static v$a a(v vVar) {
        Bundle bundle = new Bundle();
        bundle.putInt("kscene_type", 73);
        return a(vVar, bundle);
    }

    private static v$a a(v vVar, Bundle bundle) {
        if (vVar == null) {
            return null;
        }
        if (((e) vVar.hnp.Hp()).vAZ.wRq == null) {
            return null;
        }
        bin com_tencent_mm_protocal_c_bin = ((e) vVar.hnp.Hp()).vAZ.wRq.vJk;
        if (!(com_tencent_mm_protocal_c_bin == null || com_tencent_mm_protocal_c_bin.wLY == null || com_tencent_mm_protocal_c_bin.wLY.size() <= 0)) {
            v$a com_tencent_mm_modelsimple_v_a = new v$a();
            Iterator it = com_tencent_mm_protocal_c_bin.wLY.iterator();
            while (it.hasNext()) {
                bmg com_tencent_mm_protocal_c_bmg = (bmg) it.next();
                if (com_tencent_mm_protocal_c_bmg.pQj == 19) {
                    com_tencent_mm_modelsimple_v_a.frP = com_tencent_mm_protocal_c_bmg.wPM;
                } else if (com_tencent_mm_protocal_c_bmg.pQj == 20) {
                    com_tencent_mm_modelsimple_v_a.hNH = com_tencent_mm_protocal_c_bmg.wPM;
                } else if (com_tencent_mm_protocal_c_bmg.pQj == 21) {
                    com_tencent_mm_modelsimple_v_a.fyY = com_tencent_mm_protocal_c_bmg.wPM;
                }
            }
            com_tencent_mm_modelsimple_v_a.hNI = bundle;
            com_tencent_mm_modelsimple_v_a.type = 0;
            if (!bh.ov(com_tencent_mm_modelsimple_v_a.frP)) {
                com_tencent_mm_modelsimple_v_a.username = ((d) vVar.hnp.Kb()).vAW.wwY.ksU;
                return com_tencent_mm_modelsimple_v_a;
            }
        }
        return null;
    }
}
