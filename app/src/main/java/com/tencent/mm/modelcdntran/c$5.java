package com.tencent.mm.modelcdntran;

class c$5 implements Runnable {
    final /* synthetic */ int hsA;
    final /* synthetic */ i hsB;
    final /* synthetic */ c hsz;

    c$5(c cVar, int i, i iVar) {
        this.hsz = cVar;
        this.hsA = i;
        this.hsB = iVar;
    }

    public final void run() {
        if (this.hsA != -1) {
            this.hsz.hsv.put(this.hsB.field_mediaId, Integer.valueOf(this.hsA));
        }
        this.hsz.hss.add(this.hsB.field_mediaId);
        this.hsz.hst.put(this.hsB.field_mediaId, this.hsB);
        this.hsz.bJ(false);
    }

    public final String toString() {
        return super.toString() + "|addRecvTask";
    }
}
