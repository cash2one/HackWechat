package com.tencent.liteav.audio;

class TXCLiveBGMPlayer$2 implements Runnable {
    final /* synthetic */ f a;
    final /* synthetic */ int b;
    final /* synthetic */ TXCLiveBGMPlayer c;

    TXCLiveBGMPlayer$2(TXCLiveBGMPlayer tXCLiveBGMPlayer, f fVar, int i) {
        this.c = tXCLiveBGMPlayer;
        this.a = fVar;
        this.b = i;
    }

    public void run() {
        if (this.a != null) {
            this.a.a(this.b);
        }
    }
}
