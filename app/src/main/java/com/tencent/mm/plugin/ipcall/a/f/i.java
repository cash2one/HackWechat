package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.mm.plugin.ipcall.a.a.b;
import com.tencent.mm.plugin.ipcall.a.a.c;
import com.tencent.mm.plugin.ipcall.a.d.o;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public final class i extends b {
    private o nGC = null;
    private int nGD = 0;

    public final int[] aTJ() {
        return new int[]{819};
    }

    public final void onStop() {
        if (this.nGC != null) {
            ar.CG().c(this.nGC);
        }
    }

    public final int LC() {
        return 2;
    }

    public final void aTK() {
    }

    public final void onDestroy() {
    }

    public final void b(c cVar) {
        boolean z = true;
        String str = "MicroMsg.IPCallSyncService";
        String str2 = "serviceImpl, info==null: %b";
        Object[] objArr = new Object[1];
        if (cVar != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.d(str, str2, objArr);
        if (this.nCP != null) {
            this.nGD = this.nCP.nDH;
            this.nGC = new o(this.nCP.nDx, this.nCP.nDy, this.nCP.aTO(), this.nCP.nDz, false);
            ar.CG().a(this.nGC, 0);
        }
    }

    public final int aTL() {
        return this.nGD;
    }

    public final void aTM() {
        x.d("MicroMsg.IPCallSyncService", "onLoopSuccess");
    }

    public final void aTN() {
        x.d("MicroMsg.IPCallSyncService", "onLoopFailed");
    }
}
