package com.tencent.mm.plugin.card.a;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.card.model.u;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public final class m implements e {
    private long gLl = 0;
    public float gyA = -1000.0f;
    public float gyz = -85.0f;

    public final void u(float f, float f2) {
        this.gyz = f;
        this.gyA = f2;
        this.gLl = System.currentTimeMillis() / 1000;
    }

    public final void m(String str, String str2, int i) {
        if ((System.currentTimeMillis() / 1000) - this.gLl > 1800) {
            this.gyz = -85.0f;
            this.gyA = -1000.0f;
            x.i("MicroMsg.CardReportLBSManager", "checkDataValid time is out");
        }
        if (this.gyz == -85.0f) {
            x.i("MicroMsg.CardReportLBSManager", "checkDataValid lbsLatitude ==  LocationGeo.INVALID_LAT");
        }
        if (this.gyA == -1000.0f) {
            x.i("MicroMsg.CardReportLBSManager", "checkDataValid lbsLongitude ==  LocationGeo.INVALID_LNG");
        }
        ar.CG().a(1253, (e) this);
        ar.CG().a(new u(this.gyz, this.gyA, str, str2, i), 0);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.CardReportLBSManager", "rplbs onGYNetEnd, errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
        ar.CG().b(1253, (e) this);
    }
}
