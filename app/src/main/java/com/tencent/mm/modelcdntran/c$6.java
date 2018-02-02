package com.tencent.mm.modelcdntran;

class c$6 implements Runnable {
    final /* synthetic */ i hsB;
    final /* synthetic */ c hsz;

    c$6(c cVar, i iVar) {
        this.hsz = cVar;
        this.hsB = iVar;
    }

    public final void run() {
        this.hsz.hss.add(this.hsB.field_mediaId);
        this.hsz.hst.put(this.hsB.field_mediaId, this.hsB);
        this.hsz.bJ(false);
    }

    public final String toString() {
        return super.toString() + "|addSendTask";
    }
}
