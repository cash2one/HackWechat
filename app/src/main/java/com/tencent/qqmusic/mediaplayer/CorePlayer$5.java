package com.tencent.qqmusic.mediaplayer;

class CorePlayer$5 implements Runnable {
    final /* synthetic */ CorePlayer this$0;

    CorePlayer$5(CorePlayer corePlayer) {
        this.this$0 = corePlayer;
    }

    public void run() {
        CorePlayer.access$1000(this.this$0).playerPaused(this.this$0);
    }
}
