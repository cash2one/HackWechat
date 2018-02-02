package com.tencent.mm.plugin.dbbackup;

import com.tencent.mm.plugin.dbbackup.d.9;
import com.tencent.mm.storage.t;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class d$9$1 implements b {
    final /* synthetic */ boolean lpn;
    final /* synthetic */ 9 lqw;

    d$9$1(9 9, boolean z) {
        this.lqw = 9;
        this.lpn = z;
    }

    public final void ou(int i) {
        d.d(this.lqw.lqk, false);
        ar.Hg();
        t CU = c.CU();
        d.c(this.lqw.lqk, System.currentTimeMillis());
        if (i == 0) {
            CU.setLong(237569, d.l(this.lqw.lqk));
            if (this.lpn) {
                d.n(this.lqw.lqk);
            } else {
                d.a(this.lqw.lqk, 0);
            }
            CU.setInt(237570, d.m(this.lqw.lqk));
        } else if (i != 1) {
            CU.setLong(237569, d.l(this.lqw.lqk));
            if (this.lpn) {
                d.a(this.lqw.lqk, 10);
                CU.setInt(237570, d.m(this.lqw.lqk));
            }
        } else {
            return;
        }
        CU.lH(false);
    }
}
