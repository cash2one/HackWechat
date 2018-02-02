package com.tencent.mm.plugin.downloader.model;

class c$7 implements Runnable {
    final /* synthetic */ long lrL;
    final /* synthetic */ c lrO;

    c$7(c cVar, long j) {
        this.lrO = cVar;
        this.lrL = j;
    }

    public final void run() {
        for (o ck : c.aAb()) {
            ck.ck(this.lrL);
        }
    }
}
