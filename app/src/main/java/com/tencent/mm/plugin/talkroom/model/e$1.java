package com.tencent.mm.plugin.talkroom.model;

import com.tencent.mm.pluginsdk.q.l;

class e$1 implements Runnable {
    final /* synthetic */ String gIT;
    final /* synthetic */ String nSc;
    final /* synthetic */ String nSd;
    final /* synthetic */ l sbh;
    final /* synthetic */ e sbi;

    e$1(e eVar, l lVar, String str, String str2, String str3) {
        this.sbi = eVar;
        this.sbh = lVar;
        this.gIT = str;
        this.nSc = str2;
        this.nSd = str3;
    }

    public final void run() {
        this.sbh.F(this.gIT, this.nSc, this.nSd);
    }
}
