package com.tencent.rtmp;

import android.graphics.Bitmap;
import com.tencent.rtmp.TXLivePlayer.ITXSnapshotListener;

class TXLivePlayer$2 implements Runnable {
    final /* synthetic */ TXLivePlayer this$0;
    final /* synthetic */ Bitmap val$bmp;
    final /* synthetic */ ITXSnapshotListener val$listener;

    TXLivePlayer$2(TXLivePlayer tXLivePlayer, ITXSnapshotListener iTXSnapshotListener, Bitmap bitmap) {
        this.this$0 = tXLivePlayer;
        this.val$listener = iTXSnapshotListener;
        this.val$bmp = bitmap;
    }

    public void run() {
        if (this.val$listener != null) {
            this.val$listener.onSnapshot(this.val$bmp);
        }
        TXLivePlayer.access$002(this.this$0, false);
    }
}
