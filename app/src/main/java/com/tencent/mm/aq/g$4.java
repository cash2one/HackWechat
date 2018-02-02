package com.tencent.mm.aq;

class g$4 implements Runnable {
    final /* synthetic */ float fiZ;
    final /* synthetic */ g hAJ;
    final /* synthetic */ String hAK;
    final /* synthetic */ boolean hAL;
    final /* synthetic */ int hAM;

    g$4(g gVar, String str, float f, boolean z, int i) {
        this.hAJ = gVar;
        this.hAK = str;
        this.fiZ = f;
        this.hAL = z;
        this.hAM = i;
    }

    public final void run() {
        this.hAJ.a(this.hAK, true, this.fiZ, true, false, this.hAL, this.hAM);
        g.a(this.hAJ).post(new Runnable(this) {
            final /* synthetic */ g$4 hAN;

            {
                this.hAN = r1;
            }

            public final void run() {
                g.a(this.hAN.hAJ, this.hAN.hAK);
            }
        });
    }

    public final String toString() {
        return super.toString() + "|loadImginBackground";
    }
}
