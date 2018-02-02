package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.mm.plugin.ipcall.a.a.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public final class a extends com.tencent.mm.plugin.ipcall.a.a.a {
    public final int[] aTJ() {
        return new int[]{843};
    }

    public final int LC() {
        return 3;
    }

    public final void aTK() {
    }

    public final void onDestroy() {
    }

    public final void b(c cVar) {
        if (cVar != null) {
            x.d("MicroMsg.IPCallCancelService", "call cancel scene, roomId: %d, inviteId: %d", new Object[]{Integer.valueOf(cVar.nDx), Integer.valueOf(cVar.nDA)});
            ar.CG().a(new com.tencent.mm.plugin.ipcall.a.d.a(cVar.nDx, cVar.nDy, cVar.fGJ, cVar.nDZ, cVar.nDA, cVar.nDz), 0);
        }
    }
}
