package com.tencent.mm.plugin.wear.model;

import com.tencent.mm.g.a.lc;
import com.tencent.mm.plugin.wear.model.e.5;
import com.tencent.mm.plugin.wear.model.f.i;
import com.tencent.mm.protocal.c.byj;
import java.util.ArrayList;

class e$5$1 implements Runnable {
    final /* synthetic */ lc tim;
    final /* synthetic */ 5 tin;

    e$5$1(5 5, lc lcVar) {
        this.tin = 5;
        this.tim = lcVar;
    }

    public final void run() {
        a.bOt().thJ.NI(this.tim.fCt.talker);
        f NH = a.bOt().thJ.NH(this.tim.fCt.talker);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(NH.id));
        a.bOt().thN.a(new i(arrayList));
        if (this.tim.fCt.talker.equals("gh_43f2581f6fd6")) {
            byj com_tencent_mm_protocal_c_byj = a.bOt().thH.thY.tiP;
            if (com_tencent_mm_protocal_c_byj != null) {
                Object obj = (com_tencent_mm_protocal_c_byj != null && a.bOt().thK.thR && b.NG(com_tencent_mm_protocal_c_byj.wYz)) ? 1 : null;
                if (obj != null) {
                    a.bOt();
                    b.a(com_tencent_mm_protocal_c_byj);
                    return;
                }
                a.bOt().thK.connect();
            }
        }
    }
}
