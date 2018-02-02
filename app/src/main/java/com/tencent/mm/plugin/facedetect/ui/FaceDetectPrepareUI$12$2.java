package com.tencent.mm.plugin.facedetect.ui;

import android.graphics.Bitmap;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.facedetect.ui.FaceDetectPrepareUI.12;
import com.tencent.mm.plugin.facedetect.ui.a.b;

class FaceDetectPrepareUI$12$2 implements Runnable {
    final /* synthetic */ 12 mjW;
    final /* synthetic */ OnClickListener mjX;
    final /* synthetic */ Bitmap mjY;

    FaceDetectPrepareUI$12$2(12 12, OnClickListener onClickListener, Bitmap bitmap) {
        this.mjW = 12;
        this.mjX = onClickListener;
        this.mjY = bitmap;
    }

    public final void run() {
        b a = a.a(this.mjW.mjQ, this.mjX);
        a.mjj = this.mjY;
        this.mjW.mjQ.a(false, false, a);
    }
}
