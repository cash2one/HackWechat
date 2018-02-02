package com.tencent.d.b.f;

class f$3 implements Runnable {
    final /* synthetic */ f Adn;
    final /* synthetic */ int tvI;

    public f$3(f fVar, int i) {
        this.Adn = fVar;
        this.tvI = i;
    }

    public final void run() {
        synchronized (f.a(this.Adn)) {
            d dVar = (d) f.BQ().get(this.tvI);
            if (!(dVar == null || !(dVar instanceof a) || ((a) dVar).isCancelled())) {
                ((a) dVar).cGf();
            }
        }
    }
}
