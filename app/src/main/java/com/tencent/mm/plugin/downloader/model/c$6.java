package com.tencent.mm.plugin.downloader.model;

class c$6 implements Runnable {
    final /* synthetic */ long lrL;
    final /* synthetic */ c lrO;

    c$6(c cVar, long j) {
        this.lrO = cVar;
        this.lrL = j;
    }

    public final void run() {
        for (o onTaskPaused : c.aAb()) {
            onTaskPaused.onTaskPaused(this.lrL);
        }
        if (c.aAc() != null) {
            c.aAc().onTaskPaused(this.lrL);
        }
    }
}
