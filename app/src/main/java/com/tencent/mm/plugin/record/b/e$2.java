package com.tencent.mm.plugin.record.b;

import com.tencent.mm.plugin.record.a.c;

class e$2 implements Runnable {
    final /* synthetic */ c pFn;
    final /* synthetic */ e pFo;

    e$2(e eVar, c cVar) {
        this.pFo = eVar;
        this.pFn = cVar;
    }

    public final void run() {
        e.a(this.pFo).remove(this.pFn);
    }
}
