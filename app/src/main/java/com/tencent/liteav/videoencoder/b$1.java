package com.tencent.liteav.videoencoder;

import com.tencent.liteav.basic.d.b;

class b$1 implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ boolean[] c;
    final /* synthetic */ b d;

    b$1(b bVar, int i, int i2, boolean[] zArr) {
        this.d = bVar;
        this.a = i;
        this.b = i2;
        this.c = zArr;
    }

    public void run() {
        boolean z;
        b.a(this.d, b.a(null, null, null, this.a, this.b));
        boolean[] zArr = this.c;
        if (b.a(this.d) != null) {
            z = true;
        } else {
            z = false;
        }
        zArr[0] = z;
    }
}
