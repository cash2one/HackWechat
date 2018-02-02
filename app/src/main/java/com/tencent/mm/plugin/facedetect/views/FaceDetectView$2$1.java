package com.tencent.mm.plugin.facedetect.views;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.mm.plugin.facedetect.views.FaceDetectView.2;

class FaceDetectView$2$1 implements Runnable {
    final /* synthetic */ Bitmap mmL;
    final /* synthetic */ 2 mmM;

    FaceDetectView$2$1(2 2, Bitmap bitmap) {
        this.mmM = 2;
        this.mmL = bitmap;
    }

    public final void run() {
        FaceDetectView.i(this.mmM.mmK).setVisibility(0);
        FaceDetectView.i(this.mmM.mmK).setBackgroundDrawable(new BitmapDrawable(this.mmL));
    }
}
