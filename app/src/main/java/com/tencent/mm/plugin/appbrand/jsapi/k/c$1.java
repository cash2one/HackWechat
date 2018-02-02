package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.mm.plugin.appbrand.jsapi.f;

class c$1 implements Runnable {
    final /* synthetic */ c jqC;

    c$1(c cVar) {
        this.jqC = cVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        synchronized (c.a(this.jqC)) {
            if (c.a(this.jqC).isEmpty()) {
            } else {
                f fVar = (f) c.a(this.jqC).remove(0);
                int size = c.a(this.jqC).size();
            }
        }
    }
}
