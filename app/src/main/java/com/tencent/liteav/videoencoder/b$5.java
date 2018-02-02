package com.tencent.liteav.videoencoder;

class b$5 implements Runnable {
    final /* synthetic */ b a;

    b$5(b bVar) {
        this.a = bVar;
    }

    public void run() {
        if (b.d(this.a) != null) {
            b.d(this.a).setBitrate(b.f(this.a));
        }
    }
}
