package com.tencent.mm.plugin.sns.model;

class b$7 implements Runnable {
    final /* synthetic */ b qSG;
    final /* synthetic */ String qSL;

    b$7(b bVar, String str) {
        this.qSG = bVar;
        this.qSL = str;
    }

    public final void run() {
        b.a(this.qSG, this.qSL);
        this.qSG.JW(this.qSL);
    }
}
