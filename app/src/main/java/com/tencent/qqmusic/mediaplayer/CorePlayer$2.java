package com.tencent.qqmusic.mediaplayer;

import com.tencent.qqmusic.mediaplayer.MediaHTTPManager.OnConnectionListener;

class CorePlayer$2 implements OnConnectionListener {
    final /* synthetic */ CorePlayer this$0;

    CorePlayer$2(CorePlayer corePlayer) {
        this.this$0 = corePlayer;
    }

    public void onConnected(long j, String str) {
        this.this$0.setFileLength(j);
    }

    public void onError(int i, int i2) {
        synchronized (CorePlayer.access$900(this.this$0)) {
            CorePlayer.access$900(this.this$0).notifyAll();
        }
        CorePlayer.access$700(this.this$0, i, i2);
    }
}
