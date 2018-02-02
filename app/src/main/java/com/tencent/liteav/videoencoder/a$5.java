package com.tencent.liteav.videoencoder;

class a$5 implements Runnable {
    final /* synthetic */ a a;

    a$5(a aVar) {
        this.a = aVar;
    }

    public void run() {
        if (this.a.mInit) {
            a.b(this.a);
            a.d(this.a).a().removeCallbacksAndMessages(null);
        }
    }
}
