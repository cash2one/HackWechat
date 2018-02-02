package com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel;

import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class c {
    public long hhB = 0;
    private long kko = -1;
    boolean kkp = false;

    public final void begin() {
        x.d("MicroMsg.Recoverfaster", "begin");
        if (b.aqJ().aqK().gQj != null) {
            this.kko = b.aqJ().aqK().gQj.dz(Thread.currentThread().getId());
            this.kkp = true;
        }
        this.hhB = bh.Wp();
    }

    public final void end() {
        if (this.kkp && b.aqJ().aqK().gQj != null) {
            b.aqJ().aqK().gQj.fS(this.kko);
            this.kkp = false;
        }
    }
}
