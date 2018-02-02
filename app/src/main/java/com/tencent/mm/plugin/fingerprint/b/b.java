package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.bo;
import com.tencent.mm.g.a.bo$a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.c.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends c<bo> implements e {
    private bo myZ;
    private boolean mza;

    public b() {
        this.mza = false;
        this.xen = bo.class.getName().hashCode();
    }

    private boolean a(bo boVar) {
        if (g.Dh().Cy()) {
            this.mza = false;
            if (!(boVar instanceof bo)) {
                return false;
            }
            this.myZ = boVar;
            x.i("MicroMsg.CloseFingerPrintEventListener", "handle CloseFingerPrintEvent");
            g.Dk();
            g.Di().gPJ.a(385, this);
            k dVar = new d();
            g.Dk();
            g.Di().gPJ.a(dVar, 0);
            return true;
        }
        x.e("MicroMsg.CloseFingerPrintEventListener", "CloseFingerPrintEvent account is not ready");
        return false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof d) {
            bo$a com_tencent_mm_g_a_bo_a = new bo$a();
            x.i("MicroMsg.CloseFingerPrintEventListener", "NetSceneTenpayCloseTouchPay doscene return errcode " + i2 + " errmsg" + str);
            if (i == 0 && i2 == 0) {
                x.i("MicroMsg.CloseFingerPrintEventListener", "NetSceneTenpayCloseTouchPay doscene is success");
                com_tencent_mm_g_a_bo_a.retCode = 0;
            } else {
                x.i("MicroMsg.CloseFingerPrintEventListener", "NetSceneTenpayCloseTouchPay doscene is fail");
                com_tencent_mm_g_a_bo_a.retCode = i2;
            }
            g.Dk();
            g.Di().gPJ.b(385, this);
            this.myZ.fpI = com_tencent_mm_g_a_bo_a;
            this.mza = true;
            if (this.myZ.fqI != null) {
                this.myZ.fqI.run();
            }
            if (this.mza) {
                this.myZ = null;
            }
        }
    }
}
