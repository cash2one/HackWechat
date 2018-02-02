package com.tencent.mm.plugin.voip.ui;

import com.tencent.mm.sdk.platformtools.bh;
import java.util.TimerTask;

class e$9 extends TimerTask {
    final /* synthetic */ e srL;

    e$9(e eVar) {
        this.srL = eVar;
    }

    public final void run() {
        this.srL.jKT.post(new Runnable(this) {
            final /* synthetic */ e$9 srM;

            {
                this.srM = r1;
            }

            public final void run() {
                e.s(this.srM.srL).setText(e.bp(bh.by(this.srM.srL.spP)));
                e.t(this.srM.srL);
            }
        });
    }
}
