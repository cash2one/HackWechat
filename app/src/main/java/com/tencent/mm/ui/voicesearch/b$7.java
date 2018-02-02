package com.tencent.mm.ui.voicesearch;

import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.z.ar;

class b$7 implements Runnable {
    final /* synthetic */ b zqE;
    final /* synthetic */ String zqF;

    b$7(b bVar, String str) {
        this.zqE = bVar;
        this.zqF = str;
    }

    public final void run() {
        if (b.b(this.zqE).isHidden()) {
            b.b(this.zqE).Aq();
            if (b.c(this.zqE)) {
                ar.CG().a(new ac(this.zqF, 3), 0);
                b.d(this.zqE);
                return;
            }
            return;
        }
        b.b(this.zqE).Ap();
    }
}
