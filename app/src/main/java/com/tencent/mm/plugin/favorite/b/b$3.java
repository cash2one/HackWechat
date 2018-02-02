package com.tencent.mm.plugin.favorite.b;

class b$3 implements Runnable {
    final /* synthetic */ b mrg;
    final /* synthetic */ String mri;

    b$3(b bVar, String str) {
        this.mrg = bVar;
        this.mri = str;
    }

    public final void run() {
        this.mrg.mrb.add(this.mri);
    }
}
