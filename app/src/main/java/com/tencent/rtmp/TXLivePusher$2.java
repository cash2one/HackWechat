package com.tencent.rtmp;

import android.graphics.Bitmap;
import com.tencent.rtmp.TXLivePusher.ITXSnapshotListener;

class TXLivePusher$2 implements Runnable {
    final /* synthetic */ TXLivePusher this$0;
    final /* synthetic */ Bitmap val$bmp;
    final /* synthetic */ ITXSnapshotListener val$listener;

    TXLivePusher$2(TXLivePusher tXLivePusher, ITXSnapshotListener iTXSnapshotListener, Bitmap bitmap) {
        this.this$0 = tXLivePusher;
        this.val$listener = iTXSnapshotListener;
        this.val$bmp = bitmap;
    }

    public void run() {
        if (this.val$listener != null) {
            this.val$listener.onSnapshot(this.val$bmp);
        }
        TXLivePusher.access$102(this.this$0, false);
    }
}
