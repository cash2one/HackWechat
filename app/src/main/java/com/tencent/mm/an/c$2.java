package com.tencent.mm.an;

import com.tencent.mm.z.ak.b.a;

class c$2 implements Runnable {
    final /* synthetic */ c hyF;
    final /* synthetic */ String hyG;
    final /* synthetic */ boolean hyH = false;

    c$2(c cVar, String str, boolean z) {
        this.hyF = cVar;
        this.hyG = str;
    }

    public final void run() {
        if (this.hyF.hyx.containsKey(this.hyG)) {
            a aVar = (a) this.hyF.hyx.get(this.hyG);
            if (aVar != null) {
                aVar.v(this.hyG, this.hyH);
            }
            this.hyF.hyx.remove(this.hyG);
        }
    }
}
