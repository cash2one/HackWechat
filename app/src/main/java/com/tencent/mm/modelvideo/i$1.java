package com.tencent.mm.modelvideo;

class i$1 implements Runnable {
    final /* synthetic */ i hUL;

    i$1(i iVar) {
        this.hUL = iVar;
    }

    public final void run() {
        if (this.hUL.hUJ != null) {
            this.hUL.hUJ.stop();
        }
        this.hUL.hUJ = null;
    }
}
