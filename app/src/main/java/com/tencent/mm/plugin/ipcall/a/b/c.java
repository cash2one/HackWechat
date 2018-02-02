package com.tencent.mm.plugin.ipcall.a.b;

import com.tencent.mm.sdk.platformtools.x;

public final class c {
    public boolean fAs;
    public boolean kTc;
    com.tencent.mm.e.b.c.a nEA;
    public com.tencent.mm.e.b.c nEu;
    public final Object nEv;
    int nEw;
    boolean nEx;
    int nEy;
    boolean nEz;

    private class a implements Runnable {
        final /* synthetic */ c nEB;
        private com.tencent.mm.e.b.c nEC = null;

        public a(c cVar, com.tencent.mm.e.b.c cVar2) {
            this.nEB = cVar;
            this.nEC = cVar2;
        }

        public final void run() {
            x.d("MicroMsg.IPCallRecorder", "do stopRecord");
            if (this.nEC != null) {
                this.nEC.vi();
                this.nEC = null;
                c cVar = this.nEB;
                cVar.nEw = 92;
                cVar.nEx = true;
                cVar.nEy = 0;
            }
        }
    }

    public c() {
        this.nEu = null;
        this.nEv = new Object();
        this.fAs = false;
        this.kTc = false;
        this.nEw = 92;
        this.nEx = true;
        this.nEy = 0;
        this.nEz = true;
        this.nEA = new 1(this);
        this.fAs = false;
    }

    public final void setMute(boolean z) {
        x.i("MicroMsg.IPCallRecorder", "setMute: %b", new Object[]{Boolean.valueOf(z)});
        if (this.fAs && this.nEu != null) {
            this.nEu.aQ(z);
        }
        this.kTc = z;
    }
}
