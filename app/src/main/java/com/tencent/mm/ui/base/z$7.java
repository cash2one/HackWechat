package com.tencent.mm.ui.base;

class z$7 implements Runnable {
    final /* synthetic */ z yhd;

    z$7(z zVar) {
        this.yhd = zVar;
    }

    public final void run() {
        if (!this.yhd.fJl) {
            this.yhd.cqe();
            if (this.yhd.ygM != null) {
                this.yhd.a(this.yhd.ygM);
            }
            if (this.yhd.ygN != null) {
                this.yhd.a(this.yhd.ygN);
            }
        }
    }
}
