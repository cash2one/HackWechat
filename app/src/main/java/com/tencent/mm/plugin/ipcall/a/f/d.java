package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.mm.plugin.ipcall.a.a.a;
import com.tencent.mm.plugin.ipcall.a.a.c;
import com.tencent.mm.plugin.ipcall.a.d.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public final class d extends a {
    public final int[] aTJ() {
        return new int[]{991};
    }

    public final int LC() {
        return 1;
    }

    public final void aTK() {
    }

    public final void onDestroy() {
    }

    public final void b(c cVar) {
        if (cVar != null) {
            if (cVar.nDA == 0) {
                cVar.nDA = (int) System.currentTimeMillis();
            }
            ar.CG().a(new i(cVar.fGJ, cVar.nDZ, cVar.nDA, cVar.nDB, cVar.nDC), 0);
            x.d("MicroMsg.IPCallInviteService", "start invite, toUsername: %s, toPhoneNumber: %s, inviteid: %d", new Object[]{cVar.fGJ, cVar.nDZ, Integer.valueOf(cVar.nDA)});
        }
    }
}
