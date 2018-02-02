package com.tencent.liteav.videoencoder;

import com.tencent.liteav.basic.d.b;
import com.tencent.liteav.basic.d.c;

class b$3 implements Runnable {
    final /* synthetic */ c a;
    final /* synthetic */ b b;
    final /* synthetic */ b c;

    b$3(b bVar, c cVar, b bVar2) {
        this.c = bVar;
        this.a = cVar;
        this.b = bVar2;
    }

    public void run() {
        if (this.a != null) {
            this.a.d();
        }
        if (this.b != null) {
            this.b.c();
        }
    }
}
