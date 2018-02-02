package com.tencent.mm.plugin.facedetect.ui;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.facedetect.model.n;
import com.tencent.mm.sdk.platformtools.ag;

class FaceDetectPrepareUI$5 implements Runnable {
    final /* synthetic */ FaceDetectPrepareUI mjQ;

    FaceDetectPrepareUI$5(FaceDetectPrepareUI faceDetectPrepareUI) {
        this.mjQ = faceDetectPrepareUI;
    }

    public final void run() {
        final Bitmap zK = n.zK(FaceDetectPrepareUI.e(this.mjQ));
        ag.y(new Runnable(this) {
            final /* synthetic */ FaceDetectPrepareUI$5 mjT;

            public final void run() {
                FaceDetectPrepareUI.f(this.mjT.mjQ).w(zK);
            }
        });
    }
}
