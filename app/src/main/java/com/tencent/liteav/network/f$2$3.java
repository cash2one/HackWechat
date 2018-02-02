package com.tencent.liteav.network;

import com.tencent.liteav.network.f.2;
import java.util.Vector;

class f$2$3 implements Runnable {
    final /* synthetic */ Vector a;
    final /* synthetic */ 2 b;

    f$2$3(2 2, Vector vector) {
        this.b = 2;
        this.a = vector;
    }

    public void run() {
        if (this.b.f != null) {
            this.b.f.a(0, "Success", this.a);
        }
    }
}
