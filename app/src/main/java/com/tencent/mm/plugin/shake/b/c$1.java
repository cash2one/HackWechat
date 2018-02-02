package com.tencent.mm.plugin.shake.b;

import com.tencent.mm.z.ar;

class c$1 implements Runnable {
    final /* synthetic */ c qnJ;

    c$1(c cVar) {
        this.qnJ = cVar;
    }

    public final void run() {
        if (!(this.qnJ.qnH == null || this.qnJ.qnI == null)) {
            this.qnJ.qnH.removeCallbacks(this.qnJ.qnI);
        }
        if (this.qnJ.qnF != null) {
            ar.CG().c(this.qnJ.qnF);
        }
        if (!(this.qnJ.qnE == null || this.qnJ.qnE.fKk == null)) {
            this.qnJ.qnF = new a(this.qnJ.qnE.fKk);
        }
        if (this.qnJ.qnF != null) {
            ar.CG().a(this.qnJ.qnF, 0);
        }
    }
}
