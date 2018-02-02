package com.tencent.mm.plugin.ipcall.a.a;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public abstract class a implements e {
    protected int errCode = 0;
    protected int errType = 0;
    public c nCP;
    public a nDt;

    public abstract int LC();

    public abstract int[] aTJ();

    public abstract void aTK();

    public abstract void b(c cVar);

    public abstract void onDestroy();

    public void init() {
        for (int a : aTJ()) {
            ar.CG().a(a, this);
        }
        aTK();
    }

    public void destroy() {
        for (int b : aTJ()) {
            ar.CG().b(b, this);
        }
        this.nDt = null;
        onDestroy();
    }

    public void a(c cVar) {
        x.d("MicroMsg.BaseIPCallService", "start service, type: %d", new Object[]{Integer.valueOf(LC())});
        this.nCP = cVar;
        b(this.nCP);
    }

    public void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.BaseIPCallService", "onSceneEnd, errType: %d, errCode: %d, scene.getType: %d, serviceType: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(kVar.getType()), Integer.valueOf(LC())});
        this.errType = i;
        this.errCode = i2;
        if (i == 0 && i2 == 0) {
            if (this.nDt != null) {
                this.nDt.a(LC(), kVar, i, i2);
            }
        } else if (this.nDt != null) {
            this.nDt.b(LC(), kVar, i, i2);
        }
    }
}
