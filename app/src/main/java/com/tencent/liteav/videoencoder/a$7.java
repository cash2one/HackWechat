package com.tencent.liteav.videoencoder;

class a$7 implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ a b;

    a$7(a aVar, int i) {
        this.b = aVar;
        this.a = i;
    }

    public void run() {
        a.b(this.b, this.a);
    }
}
