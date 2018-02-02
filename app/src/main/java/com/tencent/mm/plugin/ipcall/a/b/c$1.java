package com.tencent.mm.plugin.ipcall.a.b;

import com.tencent.mm.e.b.c.a;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.sdk.platformtools.x;

class c$1 implements a {
    final /* synthetic */ c nEB;

    c$1(c cVar) {
        this.nEB = cVar;
    }

    public final void q(byte[] bArr, int i) {
        int i2 = 0;
        synchronized (this.nEB.nEv) {
            int bGe;
            c cVar = this.nEB;
            if (cVar.nEw <= 10) {
                cVar.nEw = 92;
            }
            a aVar = i.aTA().nEk;
            if (aVar.nEe != null) {
                bGe = aVar.nEe.bGe();
            } else {
                bGe = 0;
            }
            cVar.nEw = ((bGe + 24) + (cVar.nEw * 3)) / 4;
            if (cVar.nEx) {
                x.i("MicroMsg.IPCallRecorder", "preprocessForEcho FirstRefEcho");
                aVar = i.aTA().nEk;
                if (aVar.nEe != null) {
                    i2 = aVar.nEe.bGb();
                }
                cVar.nEy = i2;
                if (cVar.nEy >= cVar.nEw) {
                    cVar.nEy -= cVar.nEw;
                }
                cVar.nEw = cVar.nEy;
                cVar.nEx = false;
            } else {
                cVar.nEw = 0;
            }
            if (i.aTB().nCz == 5) {
                if (this.nEB.nEz) {
                    x.i("MicroMsg.IPCallRecorder", "isFirstRecordCallback");
                    this.nEB.nEz = false;
                }
                i.aTy().nEG.recordCallback(bArr, i, this.nEB.nEw);
            }
        }
    }

    public final void aK(int i, int i2) {
    }
}
