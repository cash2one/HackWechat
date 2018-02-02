package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.mm.plugin.ipcall.a.d.g;
import com.tencent.mm.z.ar;

public final class b {
    private static b nGw;
    private g nGx;

    public static b aUc() {
        if (nGw == null) {
            nGw = new b();
        }
        return nGw;
    }

    public final void gb(boolean z) {
        ar.CG().c(this.nGx);
        this.nGx = null;
        if (z) {
            this.nGx = new g(1);
        } else {
            this.nGx = new g(0);
        }
        ar.CG().a(this.nGx, 0);
    }
}
