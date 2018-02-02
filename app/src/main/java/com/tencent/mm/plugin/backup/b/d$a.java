package com.tencent.mm.plugin.backup.b;

import com.tencent.mm.plugin.backup.g.d;
import com.tencent.mm.sdk.platformtools.bh;

class d$a {
    private long beginTime;
    final /* synthetic */ d kkn;
    private long kko;
    boolean kkp;

    private d$a(d dVar) {
        this.kkn = dVar;
        this.kko = -1;
        this.kkp = false;
    }

    public final void begin() {
        if (d.aqe().aqf().gQj != null) {
            this.kko = d.aqe().aqf().gQj.dz(Thread.currentThread().getId());
            this.kkp = true;
            this.beginTime = bh.Wp();
        }
    }

    public final void end() {
        if (this.kkp && d.aqe().aqf().gQj != null) {
            d.aqe().aqf().gQj.fS(this.kko);
            this.kkp = false;
        }
    }

    public final void aoJ() {
        if (bh.bz(this.beginTime) > 500) {
            end();
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
            }
            begin();
            this.beginTime = bh.Wp();
        }
    }
}
