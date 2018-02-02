package com.tencent.mm.plugin.backup.c;

import com.tencent.mm.plugin.backup.f.f.a;
import com.tencent.mm.sdk.platformtools.x;

class d$3 implements a {
    final /* synthetic */ d klM;

    d$3(d dVar) {
        this.klM = dVar;
    }

    public final void mF(int i) {
        int i2 = b.aoR().aol().kiJ;
        x.i("MicroMsg.BackupMoveServer", "heartBeatTimeoutCallback, heartBeatState[%d], state[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        switch (i) {
            case 0:
                if (i2 == 4) {
                    b.aoR().aol().kiJ = 14;
                    this.klM.mz(14);
                    return;
                }
                return;
            case 1:
                if (i2 == 14) {
                    b.aoR().aol().kiJ = 4;
                    this.klM.mz(4);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
