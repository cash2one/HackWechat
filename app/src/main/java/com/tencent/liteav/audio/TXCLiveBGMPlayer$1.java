package com.tencent.liteav.audio;

class TXCLiveBGMPlayer$1 implements Runnable {
    final /* synthetic */ f a;
    final /* synthetic */ TXCLiveBGMPlayer b;

    TXCLiveBGMPlayer$1(TXCLiveBGMPlayer tXCLiveBGMPlayer, f fVar) {
        this.b = tXCLiveBGMPlayer;
        this.a = fVar;
    }

    public void run() {
        if (this.a != null) {
            this.a.a();
        }
    }
}
