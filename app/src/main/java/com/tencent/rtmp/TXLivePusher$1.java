package com.tencent.rtmp;

import android.graphics.Bitmap;
import com.tencent.liteav.renderer.d.a;

class TXLivePusher$1 implements a {
    final /* synthetic */ TXLivePusher this$0;
    final /* synthetic */ TXLivePusher$ITXSnapshotListener val$listener;

    TXLivePusher$1(TXLivePusher tXLivePusher, TXLivePusher$ITXSnapshotListener tXLivePusher$ITXSnapshotListener) {
        this.this$0 = tXLivePusher;
        this.val$listener = tXLivePusher$ITXSnapshotListener;
    }

    public void onTakePhotoComplete(Bitmap bitmap) {
        TXLivePusher.access$000(this.this$0, this.val$listener, bitmap);
    }
}
