package com.tencent.liteav.videoencoder;

class b$4 implements Runnable {
    final /* synthetic */ b a;

    b$4(b bVar) {
        this.a = bVar;
    }

    public void run() {
        if (b.d(this.a) != null) {
            b.d(this.a).setListener(b.e(this.a));
        }
    }
}
