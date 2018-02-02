package com.tencent.mm.plugin.ext.c;

import com.tencent.mm.g.a.nl;
import com.tencent.mm.plugin.ext.c.d.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.x;

class e$1 extends bc<e$a> {
    final /* synthetic */ b mbo;
    final /* synthetic */ e mbp;

    e$1(e eVar, e$a com_tencent_mm_plugin_ext_c_e_a, b bVar) {
        this.mbp = eVar;
        this.mbo = bVar;
        super(5000, com_tencent_mm_plugin_ext_c_e_a, true);
    }

    protected final /* synthetic */ Object run() {
        return aGa();
    }

    private e$a aGa() {
        try {
            x.d("MicroMsg.ExtQrCodeHandler", "hy: start scan qrcode");
            if (this.mbo != null) {
                com.tencent.mm.sdk.b.b nlVar = new nl();
                nlVar.fFv.width = this.mbo.mbk;
                nlVar.fFv.height = this.mbo.mbl;
                nlVar.fFv.fFx = this.mbo.mbm;
                nlVar.fFv.fFy = this.mbo.fFy;
                nlVar.fFv.fFw = this.mbo.fFw;
                nlVar.fFv.fFz = new 1(this);
                a.xef.m(nlVar);
            } else {
                x.w("MicroMsg.ExtQrCodeHandler", "hy: qrcode data not retrieved");
                bX(null);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ExtQrCodeHandler", e, "hy: error when syncTaskScanQrCode", new Object[0]);
            bX(null);
        }
        return null;
    }
}
