package com.tencent.mm.plugin.backup.c;

import com.tencent.mm.plugin.backup.f.i.a;
import com.tencent.mm.sdk.platformtools.x;

class d$4 implements a {
    final /* synthetic */ d klM;

    d$4(d dVar) {
        this.klM = dVar;
    }

    public final void apd() {
        this.klM.mz(b.aoR().aol().kiJ);
    }

    public final void mE(int i) {
    }

    public final void ape() {
        int i = b.aoR().aol().kiJ;
        x.e("MicroMsg.BackupMoveServer", "speedOverTime callback, state[%d]", new Object[]{Integer.valueOf(i)});
        if (i == 14 || i == 4) {
            this.klM.al(true);
            b.aoR().aoS().stop();
            b.aoR().aol().kiJ = -4;
            this.klM.mz(-4);
        }
    }
}
