package com.tencent.liteav.beauty;

class b$5 implements Runnable {
    final /* synthetic */ float[] a;
    final /* synthetic */ b b;

    b$5(b bVar, float[] fArr) {
        this.b = bVar;
        this.a = fArr;
    }

    public void run() {
        b.a(this.b, this.a);
    }
}
