package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.modelsns.e;
import com.tencent.mm.plugin.sns.ui.h.a;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.dp;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;
import java.util.Map;

class g$1 implements a {
    final /* synthetic */ g rqw;

    g$1(g gVar) {
        this.rqw = gVar;
    }

    public final void a(List<aqr> list, Map<Integer, Integer> map, Map<Integer, Integer> map2, int i, int i2, dp dpVar) {
        x.d("MicroMsg.ArtistAdapter", "onFinishFixPos");
        g gVar = this.rqw;
        if (list != null && list.size() > 0) {
            int intValue;
            try {
                gVar.rqv.a((dp) new dp().aF(dpVar.toByteArray()));
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ArtistAdapter", e, "", new Object[0]);
            }
            x.d("MicroMsg.ArtistAdapter", "copy list info");
            int size = list.size();
            gVar.list.clear();
            gVar.rqp.clear();
            gVar.rqq.clear();
            for (int i3 = 0; i3 < size; i3++) {
                aqr com_tencent_mm_protocal_c_aqr = (aqr) list.get(i3);
                gVar.list.add(e.a(com_tencent_mm_protocal_c_aqr.nGJ, com_tencent_mm_protocal_c_aqr.ktN, com_tencent_mm_protocal_c_aqr.nfX, com_tencent_mm_protocal_c_aqr.wxE, com_tencent_mm_protocal_c_aqr.wxD, com_tencent_mm_protocal_c_aqr.wxF, com_tencent_mm_protocal_c_aqr.nfe));
            }
            for (Integer intValue2 : map.keySet()) {
                intValue = intValue2.intValue();
                gVar.rqp.put(Integer.valueOf(intValue), Integer.valueOf(((Integer) map.get(Integer.valueOf(intValue))).intValue()));
            }
            for (Integer intValue22 : map2.keySet()) {
                intValue = intValue22.intValue();
                gVar.rqq.put(Integer.valueOf(intValue), Integer.valueOf(((Integer) map2.get(Integer.valueOf(intValue))).intValue()));
            }
            list.clear();
            map.clear();
            map2.clear();
            gVar.rqs = i;
            gVar.rqr = i2;
            x.d("MicroMsg.ArtistAdapter", "reallyCount " + i + " icount " + i2);
            gVar.notifyDataSetChanged();
        }
    }

    public final void byU() {
        g gVar = this.rqw;
        if (gVar.rqv != null) {
            gVar.rqv.byV();
        }
    }
}
