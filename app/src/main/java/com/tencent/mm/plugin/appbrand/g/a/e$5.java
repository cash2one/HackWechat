package com.tencent.mm.plugin.appbrand.g.a;

import com.tencent.mm.plugin.appbrand.g.a.e.a;
import java.util.TimerTask;

class e$5 extends TimerTask {
    final /* synthetic */ f jwa;
    final /* synthetic */ e jwe;
    final /* synthetic */ a jwf;

    e$5(e eVar, f fVar, a aVar) {
        this.jwe = eVar;
        this.jwa = fVar;
        this.jwf = aVar;
    }

    public final void run() {
        this.jwa.jwo.p(new Runnable(this) {
            final /* synthetic */ e$5 jwg;

            {
                this.jwg = r1;
            }

            public final void run() {
                this.jwg.jwf.dc(true);
            }
        });
    }
}
