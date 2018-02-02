package com.tencent.liteav.videoencoder;

import com.tencent.liteav.basic.e.b;
import com.tencent.liteav.basic.util.a;
import java.lang.ref.WeakReference;
import java.util.TimerTask;

class b$a extends TimerTask {
    private WeakReference<b> a;

    public b$a(b bVar) {
        this.a = new WeakReference(bVar);
    }

    public void run() {
        if (this.a != null) {
            b bVar = (b) this.a.get();
            if (bVar == null) {
                return;
            }
            if (b.h(bVar) < b.i(bVar)) {
                int[] a = a.a();
                b.j(bVar);
                b.a(bVar, b.k(bVar) + ((float) (a[0] / 10)));
                b.b(bVar, ((float) (a[1] / 10)) + b.l(bVar));
                b.c(bVar, b.m(bVar) + ((float) ((bVar.b() * 100) / ((long) b.c(bVar).fps))));
                return;
            }
            if (b.a().a(b.k(bVar) / ((float) b.i(bVar)), b.l(bVar) / ((float) b.i(bVar)), b.m(bVar) / ((float) b.i(bVar))) && b.a().c() != 0) {
                b.n(bVar);
            }
            b.o(bVar);
        }
    }
}
