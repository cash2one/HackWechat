package com.tencent.mm.plugin.downloader.model;

class c$1 implements Runnable {
    final /* synthetic */ String gBF;
    final /* synthetic */ long lrL;
    final /* synthetic */ c lrO;

    c$1(c cVar, long j, String str) {
        this.lrO = cVar;
        this.lrL = j;
        this.gBF = str;
    }

    public final void run() {
        for (o onTaskStarted : c.aAb()) {
            onTaskStarted.onTaskStarted(this.lrL, this.gBF);
        }
        if (c.aAc() != null) {
            c.aAc().onTaskStarted(this.lrL, this.gBF);
        }
    }
}
