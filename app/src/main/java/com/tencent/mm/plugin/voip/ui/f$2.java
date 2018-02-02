package com.tencent.mm.plugin.voip.ui;

import com.tencent.mm.sdk.platformtools.bh;
import java.util.TimerTask;

class f$2 extends TimerTask {
    final /* synthetic */ f ssq;

    f$2(f fVar) {
        this.ssq = fVar;
    }

    public final void run() {
        this.ssq.jKT.post(new Runnable(this) {
            final /* synthetic */ f$2 ssr;

            {
                this.ssr = r1;
            }

            public final void run() {
                f.g(this.ssr.ssq).setText(f.bp(bh.by(this.ssr.ssq.spP)));
            }
        });
    }
}
