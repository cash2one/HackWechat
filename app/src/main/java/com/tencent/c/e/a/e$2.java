package com.tencent.c.e.a;

import com.tencent.c.e.a.a.c;
import com.tencent.c.e.a.a.f;
import com.tencent.c.e.a.e.a;

class e$2 extends c {
    final /* synthetic */ e zTM;

    e$2(e eVar) {
        this.zTM = eVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void cDz() {
        synchronized (this.zTM) {
            if (!e.c(this.zTM)) {
            } else if (e.g(this.zTM) == null) {
            } else if (e.g(this.zTM).gu(e.a(this.zTM).zTD)) {
                long cDD = e.g(this.zTM).zUc.cDD();
                a d = e.d(this.zTM);
                int i = (int) (e.a(this.zTM).zTD / f.zTV);
                d.mCount = 1;
                d.mMaxCount = i;
                d.zTS = cDD;
                cDD = (cDD + f.zTV) - System.currentTimeMillis();
                if (cDD > 0) {
                    e.e(this.zTM).postDelayed(e.d(this.zTM), cDD);
                } else {
                    e.e(this.zTM).post(e.d(this.zTM));
                }
            }
        }
    }

    public final void cDA() {
        if (e.f(this.zTM) != null) {
            e.f(this.zTM);
        }
    }
}
