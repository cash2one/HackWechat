package com.tencent.mm.plugin.appbrand.game;

class j$2 implements Runnable {
    final /* synthetic */ j iXz;

    j$2(j jVar) {
        this.iXz = jVar;
    }

    public final void run() {
        if (j.a(this.iXz) != null && !j.a(this.iXz).iWU) {
            j.a(this.iXz).iWU = true;
            this.iXz.adV();
        }
    }
}
