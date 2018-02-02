package com.tencent.mm.plugin.facedetect.ui;

import android.graphics.RectF;
import com.tencent.mm.plugin.facedetect.model.f;
import com.tencent.mm.plugin.facedetect.model.g;
import com.tencent.mm.plugin.facedetect.model.h;
import com.tencent.mm.plugin.facedetect.views.FaceDetectDecorView;
import com.tencent.mm.plugin.facedetect.views.FaceDetectView;
import com.tencent.mm.sdk.platformtools.x;

class FaceDetectUI$6 implements Runnable {
    final /* synthetic */ FaceDetectUI mkq;

    FaceDetectUI$6(FaceDetectUI faceDetectUI) {
        this.mkq = faceDetectUI;
    }

    public final void run() {
        int[] iArr = null;
        x.i("MicroMsg.FaceDetectUI", "alvinluo dismiss cover and start capture");
        FaceDetectUI.h(this.mkq).aHr();
        FaceDetectUI.h(this.mkq).aHs();
        FaceDetectUI faceDetectUI = this.mkq;
        if (h.mgm == null) {
            h.mgm = new h();
        }
        faceDetectUI.mkb = h.mgm;
        h hVar = faceDetectUI.mkb;
        hVar.lHX = 0;
        hVar.mgk = null;
        hVar.mgl = -1;
        hVar = faceDetectUI.mkb;
        g gVar = f.mgf.mgg.mil;
        if (gVar.mgj == null) {
            x.e("MicroMsg.FaceDetectNativeManager", "hy: get all motion not init");
        } else {
            iArr = gVar.mgj.engineGetAllMotions();
        }
        hVar.mgk = iArr;
        hVar.mgl = hVar.mgk == null ? 0 : hVar.mgk.length;
        faceDetectUI.lMx = true;
        FaceDetectView faceDetectView = faceDetectUI.mkh;
        RectF rectF = new RectF((float) faceDetectUI.mki.getLeft(), (float) faceDetectUI.mki.getTop(), (float) faceDetectUI.mki.getRight(), (float) faceDetectUI.mki.getBottom());
        FaceDetectDecorView faceDetectDecorView = faceDetectView.mmt;
        String str = "MicroMsg.FaceDetectDecorView";
        String str2 = "hy: trigger showCover cover: %s, old: %s";
        Object[] objArr = new Object[2];
        objArr[0] = rectF.toString();
        objArr[1] = faceDetectDecorView.mmq == null ? "null" : faceDetectDecorView.mmq.toString();
        x.i(str, str2, objArr);
        faceDetectDecorView.mmo = true;
        if (faceDetectDecorView.mmq == null || !faceDetectDecorView.mmq.equals(rectF)) {
            faceDetectDecorView.mmq = rectF;
            x.i("MicroMsg.FaceDetectDecorView", "alvinluo invalidate %s", faceDetectDecorView.mmq.toString());
            faceDetectDecorView.invalidate();
        }
        faceDetectUI.aHn();
    }
}
