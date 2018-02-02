package com.tencent.mm.plugin.backup.c;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.backup.d.a;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.protocal.c.eq;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class e$2 implements e {
    final /* synthetic */ e klV;

    e$2(e eVar) {
        this.klV = eVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        b.b(704, this.klV.klT);
        x.i("MicroMsg.CheckNetworkGenQrCodeHandler", "backup move receive createQrcode response.[%d,%d,%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0) {
            com.tencent.mm.plugin.backup.d.b bVar = (com.tencent.mm.plugin.backup.d.b) kVar;
            eq eqVar = (eq) bVar.gJQ.hmh.hmo;
            b.aoR().kiB = "";
            b.aoR().kiC = eqVar.vJY;
            b.aoR().kiD = eqVar.vJZ;
            b.aoR().kkO = eqVar.vJT;
            eqVar = (eq) bVar.gJQ.hmh.hmo;
            byte[] bArr = eqVar == null ? null : eqVar.vJV == null ? null : eqVar.vJV.wJD.oz;
            if (bArr != null) {
                this.klV.kiE.kiJ = 51;
                this.klV.klR.k(51, bArr);
                return;
            }
            return;
        }
        x.e("MicroMsg.CheckNetworkGenQrCodeHandler", "create qrcode failed, errMsg:" + str);
        x.i("MicroMsg.CheckNetworkGenQrCodeHandler", "err: %d, %d, %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i2 == -100) {
            ar.CG().a(1000, this.klV.klU);
            ar.CG().a(new a(this.klV.klN, this.klV.klO, b.aoR().kkO), 0);
            return;
        }
        this.klV.kiE.kiJ = -11;
        this.klV.klR.k(-11, null);
    }
}
