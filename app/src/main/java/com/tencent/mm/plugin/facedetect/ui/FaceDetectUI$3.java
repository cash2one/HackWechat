package com.tencent.mm.plugin.facedetect.ui;

import android.graphics.RectF;
import com.tencent.mm.plugin.facedetect.views.FaceDetectDecorView;
import com.tencent.mm.plugin.facedetect.views.FaceDetectView;
import com.tencent.mm.plugin.facedetect.views.FaceScanRect$b;

class FaceDetectUI$3 implements FaceScanRect$b {
    final /* synthetic */ FaceDetectUI mkq;

    FaceDetectUI$3(FaceDetectUI faceDetectUI) {
        this.mkq = faceDetectUI;
    }

    public final void aHq() {
        FaceDetectView c = FaceDetectUI.c(this.mkq);
        RectF rectF = new RectF((float) FaceDetectUI.b(this.mkq).getLeft(), (float) FaceDetectUI.b(this.mkq).getTop(), (float) FaceDetectUI.b(this.mkq).getRight(), (float) FaceDetectUI.b(this.mkq).getBottom());
        FaceDetectDecorView faceDetectDecorView = c.mmt;
        faceDetectDecorView.mmo = true;
        faceDetectDecorView.mmp = true;
        faceDetectDecorView.mmq = rectF;
        faceDetectDecorView.invalidate();
    }
}
