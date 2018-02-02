package com.tencent.mm.plugin.appbrand.jsapi.base;

import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.p.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.z.u$b;

class a$2 implements e {
    final /* synthetic */ p jdJ;
    final /* synthetic */ u$b jeN;
    final /* synthetic */ a jhh;
    final /* synthetic */ int jhi;

    a$2(a aVar, p pVar, int i, u$b com_tencent_mm_z_u_b) {
        this.jhh = aVar;
        this.jdJ = pVar;
        this.jhi = i;
        this.jeN = com_tencent_mm_z_u_b;
    }

    public final void onDestroy() {
        this.jdJ.b(this);
        ag.y(new Runnable(this) {
            final /* synthetic */ a$2 jhj;

            {
                this.jhj = r1;
            }

            public final void run() {
                this.jhj.jdJ.aeF().lk(this.jhj.jhi);
            }
        });
        this.jdJ.aeF().lp(this.jhi);
        this.jeN.recycle();
        System.gc();
    }
}
