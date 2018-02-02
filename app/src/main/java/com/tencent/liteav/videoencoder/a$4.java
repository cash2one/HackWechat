package com.tencent.liteav.videoencoder;

class a$4 implements Runnable {
    final /* synthetic */ boolean[] a;
    final /* synthetic */ TXSVideoEncoderParam b;
    final /* synthetic */ a c;

    a$4(a aVar, boolean[] zArr, TXSVideoEncoderParam tXSVideoEncoderParam) {
        this.c = aVar;
        this.a = zArr;
        this.b = tXSVideoEncoderParam;
    }

    public void run() {
        if (this.c.mInit) {
            a.b(this.c);
        }
        this.a[0] = a.a(this.c, this.b);
    }
}
