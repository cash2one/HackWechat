package com.tencent.mm.plugin.wallet.pay.ui;

import com.tencent.mm.g.a.gv;
import com.tencent.mm.g.a.gv.b;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements Runnable {
    final /* synthetic */ gv sEI;
    final /* synthetic */ a sEJ;

    a$1(a aVar, gv gvVar) {
        this.sEJ = aVar;
        this.sEI = gvVar;
    }

    public final void run() {
        x.i("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback");
        b bVar = this.sEI.fwV;
        if (bVar != null && bVar.fsH) {
            x.i("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback, result.isSuccess is true");
            this.sEJ.bJV();
            if (this.sEJ.sEH != null) {
                this.sEJ.sEH.c(bVar.fsH, bVar.fwZ, bVar.fxa);
            }
        } else if (bVar == null || bVar.fsH) {
            x.i("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback, result == null");
        } else {
            this.sEJ.bJV();
            if (this.sEJ.sEH != null) {
                this.sEJ.sEH.c(bVar.fsH, bVar.fwZ, bVar.fxa);
            }
            x.e("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback, result.isSuccess is false");
        }
    }
}
