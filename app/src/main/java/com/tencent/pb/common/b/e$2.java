package com.tencent.pb.common.b;

class e$2 implements Runnable {
    final /* synthetic */ e zMn;
    final /* synthetic */ d zMo;

    e$2(e eVar, d dVar) {
        this.zMn = eVar;
        this.zMo = dVar;
    }

    public final void run() {
        e.a(this.zMn).remove(this.zMo);
        this.zMn.a(2, -1, "doScene failed", this.zMo);
    }
}
