package com.tencent.mm.app;

import com.tencent.mm.app.WorkerProfile.10;
import com.tencent.mm.modelsimple.o;
import com.tencent.mm.z.ar;

class WorkerProfile$10$1 implements Runnable {
    final /* synthetic */ int fgA;
    final /* synthetic */ boolean fgB;
    final /* synthetic */ 10 fgC;

    WorkerProfile$10$1(10 10, int i, boolean z) {
        this.fgC = 10;
        this.fgA = i;
        this.fgB = z;
    }

    public final void run() {
        ar.CG().a(new o(this.fgA, this.fgB), 0);
    }
}
