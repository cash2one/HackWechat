package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.kernel.g;

class b$2 implements Runnable {
    final /* synthetic */ b iIN;

    public b$2(b bVar) {
        this.iIN = bVar;
    }

    public final void run() {
        if (g.Dh().Cy() && !a.aaG()) {
            b.a(this.iIN, 2, 7, 0, true, null);
        }
    }
}
