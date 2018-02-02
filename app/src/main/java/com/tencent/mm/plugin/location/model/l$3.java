package com.tencent.mm.plugin.location.model;

import com.tencent.mm.g.a.nx;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class l$3 extends c<nx> {
    final /* synthetic */ l nRF;

    l$3(l lVar) {
        this.nRF = lVar;
        this.xen = nx.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        nx nxVar = (nx) bVar;
        x.d("MicroMsg.SubCoreLocation", "trackEvent state " + nxVar.fFQ.ahf);
        if (nxVar.fFQ.ahf) {
            if (l.aVu().aVz() && l.aVu().nRS) {
                l.aVu().aVA();
            }
        } else if (l.aVu().aVz()) {
            o aVu = l.aVu();
            x.d("MicorMsg.TrackRefreshManager", "pause refresh");
            aVu.nRS = true;
            if (aVu.hpO != null) {
                aVu.hpO.c(aVu.gyF);
            }
            if (aVu.nRJ != null) {
                aVu.nRJ.b(aVu.nRY);
            }
        }
        return false;
    }
}
