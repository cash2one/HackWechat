package com.tencent.mm.plugin.g.a.c;

final class a$b implements Runnable {
    private long kwW = 0;
    private long kwX = 0;
    final /* synthetic */ a kzR;

    public a$b(a aVar, long j, long j2) {
        this.kzR = aVar;
        this.kwW = j;
        this.kwX = j2;
    }

    public final void run() {
        a aVar = this.kzR;
        b bVar = new b(this.kwW);
        long j = bVar.mSessionId;
        b bVar2 = (b) aVar.kwL.remove(Long.valueOf(j));
        if (bVar2 != null) {
            bVar2.disconnect();
        }
        aVar.kwL.put(Long.valueOf(j), bVar);
        if (this.kzR.kzP != null) {
            this.kzR.kzP.b(j, this.kwW, this.kwX);
        }
    }
}
