package com.tencent.mm.plugin.appbrand;

class f$4 implements Runnable {
    final /* synthetic */ f irv;
    final /* synthetic */ e irw;

    f$4(f fVar, e eVar) {
        this.irv = fVar;
        this.irw = eVar;
    }

    public final void run() {
        f fVar = this.irv;
        e eVar = this.irw;
        if (eVar != null) {
            eVar.cleanup();
            fVar.iqD.removeView(eVar.iqD);
            fVar.irq.remove(eVar.mAppId);
            fVar.irp.remove(eVar);
        }
    }
}
