package com.tencent.mm.plugin.sport.c;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sport.PluginSport;
import com.tencent.mm.protocal.c.age;
import com.tencent.mm.protocal.c.bmb;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

class l$1 implements e {
    final /* synthetic */ l rUh;

    l$1(l lVar) {
        this.rUh = lVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof d) {
            g.CG().b(1734, this.rUh.hnN);
            d dVar = (d) kVar;
            if (i == 0 && i2 == 0) {
                age com_tencent_mm_protocal_c_age = dVar.rTQ;
                Collections.sort(com_tencent_mm_protocal_c_age.wnE, new 1(this));
                Calendar instance = Calendar.getInstance();
                instance.setTimeInMillis(((long) ((bmb) com_tencent_mm_protocal_c_age.wnE.get(0)).cRJ) * 1000);
                instance.set(10, 0);
                instance.set(12, 0);
                instance.set(13, 0);
                long timeInMillis = instance.getTimeInMillis();
                ((PluginSport) g.k(PluginSport.class)).getSportStepStorage();
                m.D((long) dVar.rTP.vZj, (long) dVar.rTP.vZk);
                x.i("MicroMsg.Sport.SportStepManager", "delete step item after %s", this.rUh.rUg.format(new Date(timeInMillis)));
                List arrayList = new ArrayList();
                Iterator it = com_tencent_mm_protocal_c_age.wnE.iterator();
                while (it.hasNext()) {
                    bmb com_tencent_mm_protocal_c_bmb = (bmb) it.next();
                    com.tencent.mm.plugin.sport.b.e eVar = new com.tencent.mm.plugin.sport.b.e();
                    eVar.field_step = com_tencent_mm_protocal_c_bmb.jer;
                    eVar.field_timestamp = ((long) com_tencent_mm_protocal_c_bmb.cRJ) * 1000;
                    eVar.field_date = this.rUh.rUg.format(new Date(eVar.field_timestamp));
                    arrayList.add(eVar);
                }
                ((PluginSport) g.k(PluginSport.class)).getSportStepStorage();
                m.cb(arrayList);
                if (dVar.rTR != null) {
                    dVar.rTR.aFj();
                }
            }
        }
    }
}
