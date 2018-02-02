package com.tencent.qqmusic.mediaplayer;

class CorePlayer$4 implements Runnable {
    final /* synthetic */ CorePlayer this$0;

    CorePlayer$4(CorePlayer corePlayer) {
        this.this$0 = corePlayer;
    }

    public void run() {
        CorePlayer.access$1000(this.this$0).playerPrepared(this.this$0);
    }
}
