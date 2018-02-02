package com.tencent.mm.modelcdntran;

class f$3 implements Runnable {
    final /* synthetic */ f hta;
    final /* synthetic */ j htb;

    f$3(f fVar, j jVar) {
        this.hta = fVar;
        this.htb = jVar;
    }

    public final void run() {
        this.hta.hss.add(this.htb.field_mediaId);
        this.hta.hst.put(this.htb.field_mediaId, this.htb);
        this.hta.bJ(false);
    }
}
