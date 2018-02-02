package com.tencent.mm.aq;

import com.tencent.mm.ae.k;

class i$3 implements Runnable {
    final /* synthetic */ k flZ;
    final /* synthetic */ i hBd;

    i$3(i iVar, k kVar) {
        this.hBd = iVar;
        this.flZ = kVar;
    }

    public final void run() {
        if (this.flZ.getType() == 110 && (this.flZ instanceof l)) {
            i.c(this.hBd);
            i.Pi().remove(Integer.valueOf((int) ((l) this.flZ).hBk));
            if (i.d(this.hBd) > 0) {
                i.e(this.hBd);
            } else {
                i.f(this.hBd);
            }
        }
    }

    public final String toString() {
        return super.toString() + "|onSceneEnd";
    }
}
