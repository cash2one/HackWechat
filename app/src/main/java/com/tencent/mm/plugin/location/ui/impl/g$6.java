package com.tencent.mm.plugin.location.ui.impl;

import com.tencent.mm.plugin.location.model.d;
import com.tencent.mm.plugin.location.ui.i.a;
import com.tencent.mm.plugin.location.ui.m;
import com.tencent.mm.protocal.c.brr;
import com.tencent.mm.sdk.platformtools.bh;

class g$6 implements a {
    final /* synthetic */ g nYb;

    g$6(g gVar) {
        this.nYb = gVar;
    }

    public final void DJ(String str) {
        TrackPoint trackPoint = (TrackPoint) this.nYb.nVU.nTd.getViewByItag(str);
        if (trackPoint != null) {
            d dVar;
            trackPoint.bringToFront();
            this.nYb.nVU.nTd.invalidate();
            m mVar = this.nYb.nXO;
            if (!bh.ov(str)) {
                if (mVar.nRM == null || !str.equals(mVar.nRM.vIy)) {
                    if (mVar.nUT != null && mVar.nUT.size() > 0) {
                        for (brr com_tencent_mm_protocal_c_brr : mVar.nUT) {
                            if (com_tencent_mm_protocal_c_brr.vIy.equals(str)) {
                                dVar = new d(com_tencent_mm_protocal_c_brr.wTo.vNO, com_tencent_mm_protocal_c_brr.wTo.vNP);
                                break;
                            }
                        }
                    }
                }
                dVar = new d(mVar.nRM.wTo.vNO, mVar.nRM.wTo.vNP);
                if (dVar != null) {
                    this.nYb.nVU.nTd.getIController().animateTo(dVar.nQx, dVar.nQy);
                }
            }
            dVar = null;
            if (dVar != null) {
                this.nYb.nVU.nTd.getIController().animateTo(dVar.nQx, dVar.nQy);
            }
        }
    }
}
