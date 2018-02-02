package com.tencent.mm.plugin.backup.c;

import com.tencent.mm.plugin.backup.f.f$a;
import com.tencent.mm.sdk.platformtools.x;

class c$12 implements f$a {
    final /* synthetic */ c klx;

    c$12(c cVar) {
        this.klx = cVar;
    }

    public final void mF(int i) {
        int i2 = b.aoR().aol().kiJ;
        x.i("MicroMsg.BackupMoveRecoverServer", "heartBeatTimeoutCallback, heartBeatState[%d], state[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        switch (i) {
            case 0:
                if (i2 == 4) {
                    b.aoR().aol().kiJ = 23;
                    this.klx.mz(23);
                    return;
                }
                return;
            case 1:
                if (i2 == 23) {
                    b.aoR().aol().kiJ = 4;
                    this.klx.mz(4);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
