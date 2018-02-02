package com.tencent.mm.plugin.downloader.model;

class c$2 implements Runnable {
    final /* synthetic */ String gBF;
    final /* synthetic */ long lrL;
    final /* synthetic */ c lrO;

    c$2(c cVar, long j, String str) {
        this.lrO = cVar;
        this.lrL = j;
        this.gBF = str;
    }

    public final void run() {
        for (o k : c.aAb()) {
            k.k(this.lrL, this.gBF);
        }
        if (c.aAc() != null) {
            c.aAc().k(this.lrL, this.gBF);
        }
    }
}
