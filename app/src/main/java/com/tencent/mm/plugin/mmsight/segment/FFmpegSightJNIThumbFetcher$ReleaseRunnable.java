package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Bitmap;
import com.tencent.mm.memory.o;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;

class FFmpegSightJNIThumbFetcher$ReleaseRunnable implements Runnable {
    int mBufId;
    Bitmap mReusedBitmap;

    private FFmpegSightJNIThumbFetcher$ReleaseRunnable(Bitmap bitmap, int i) {
        this.mReusedBitmap = bitmap;
        this.mBufId = i;
    }

    public void run() {
        if (!(this.mReusedBitmap == null || this.mReusedBitmap.isRecycled())) {
            o.han.g(this.mReusedBitmap);
        }
        SightVideoJNI.freeObj(this.mBufId);
    }
}
