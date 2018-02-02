package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.mm.plugin.ipcall.a.a.a;
import com.tencent.mm.plugin.ipcall.a.a.c;
import com.tencent.mm.plugin.ipcall.a.d.n;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public final class h extends a {
    public int nGA = 1;
    public boolean nGB = false;

    public final int[] aTJ() {
        return new int[]{723};
    }

    public final int LC() {
        return 4;
    }

    public final void aTK() {
    }

    public final void onDestroy() {
    }

    public final void b(c cVar) {
        if (cVar != null) {
            x.d("MicroMsg.IPCallShutDownService", "call shutdown scene, roomId: %d, inviteId: %d", new Object[]{Integer.valueOf(cVar.nDx), Integer.valueOf(cVar.nDA)});
            ar.CG().a(new n(cVar.nDx, cVar.nDy, cVar.nDz, this.nGA), 0);
        }
    }
}
