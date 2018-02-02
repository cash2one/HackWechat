package com.tencent.mm.plugin.backup.c;

import com.tencent.mm.plugin.backup.f.i.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

class c$2 implements a {
    final /* synthetic */ c klx;

    c$2(c cVar) {
        this.klx = cVar;
    }

    public final void apd() {
        this.klx.mz(b.aoR().aol().kiJ);
    }

    public final void mE(int i) {
        if (i == 1) {
            g.pQN.h(11789, new Object[]{Integer.valueOf(8)});
        } else if (i == 0) {
            g.pQN.h(11789, new Object[]{Integer.valueOf(9)});
        }
    }

    public final void ape() {
        int i = b.aoR().aol().kiJ;
        x.e("MicroMsg.BackupMoveRecoverServer", "speedOverTime callback, state[%d]", new Object[]{Integer.valueOf(i)});
        if (i == 23 || i == 4) {
            this.klx.a(true, false, -4);
            g.pQN.a(485, 43, 1, false);
            this.klx.mD(4);
            b.aoR().aoS().stop();
        }
    }
}
