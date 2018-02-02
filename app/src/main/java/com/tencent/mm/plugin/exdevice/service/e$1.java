package com.tencent.mm.plugin.exdevice.service;

class e$1 implements Runnable {
    final /* synthetic */ String lKN;
    final /* synthetic */ boolean lKO;
    final /* synthetic */ e lQh;

    e$1(e eVar, String str, boolean z) {
        this.lQh = eVar;
        this.lKN = str;
        this.lKO = z;
    }

    public final void run() {
        if (u.aEM().lKw != null) {
            u.aEM().lKw.a(this.lKN, this.lKO, this.lQh);
        }
    }
}
