package com.tencent.mm.plugin.address.model;

import com.tencent.mm.ae.e;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.f;
import com.tencent.mm.g.a.mf;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.plugin.address.d.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public final class k extends c<mf> implements e {
    private mf ilW;
    private d ilX;

    public k() {
        this.xen = mf.class.getName().hashCode();
    }

    private boolean a(mf mfVar) {
        if (mfVar instanceof mf) {
            this.ilW = mfVar;
            ar.CG().a(417, this);
            ar.CG().a(new e(this.ilW.fDT.url, this.ilW.fDT.appId, 1), 0);
        }
        return true;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
        x.d("MicroMsg.RcptGetAddrEventListener", "onSceneEnd errType[%s], errCode[%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (!(kVar instanceof e)) {
            return;
        }
        if (i2 == 0) {
            u(i2, true);
        } else {
            u(i2, false);
        }
    }

    private void u(int i, boolean z) {
        x.d("MicroMsg.RcptGetAddrEventListener", "setResult errCode[%s], isAccept[%s]", new Object[]{Integer.valueOf(i), Boolean.valueOf(z)});
        this.ilW.fDU.errCode = i;
        if (i != 0) {
            this.ilW.fDU.fDV = false;
        } else if (z) {
            r0 = this.ilX;
            if (r0 != null) {
                r0.field_brandFlag |= 8;
                f.g(r0);
            }
            this.ilW.fDU.fDV = true;
            a.XE();
            com.tencent.mm.plugin.address.d.a aVar = a.XG().ima;
            if (aVar.imi.size() > 0) {
                b bVar = (b) aVar.imi.getFirst();
                this.ilW.fDU.fDW = bVar.imr;
                this.ilW.fDU.userName = bVar.imp;
                this.ilW.fDU.fDX = bVar.imq;
                this.ilW.fDU.fDY = bVar.imn;
                this.ilW.fDU.fDZ = bVar.imk;
                this.ilW.fDU.fEa = bVar.iml;
                this.ilW.fDU.fEb = bVar.imm;
                this.ilW.fDU.fEc = bVar.imo;
            }
        } else {
            r0 = this.ilX;
            if (r0 != null) {
                r0.field_brandFlag &= -9;
                f.g(r0);
            }
            this.ilW.fDU.fDV = false;
        }
        if (this.ilW.fqI != null) {
            this.ilW.fqI.run();
        }
        ar.CG().b(417, this);
    }
}
