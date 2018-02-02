package com.tencent.liteav.network;

import com.tencent.liteav.network.f.2;

class f$2$4 implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ String b;
    final /* synthetic */ 2 c;

    f$2$4(2 2, int i, String str) {
        this.c = 2;
        this.a = i;
        this.b = str;
    }

    public void run() {
        if (this.c.f != null) {
            this.c.f.a(this.a, this.b, null);
        }
    }
}
