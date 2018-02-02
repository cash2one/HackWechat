package com.tencent.mm.plugin.facedetect.ui;

import android.os.Bundle;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.facedetect.a.h;
import com.tencent.mm.plugin.facedetect.b.d;
import com.tencent.mm.sdk.platformtools.x;

class FaceDetectPrepareUI$9 implements d {
    final /* synthetic */ FaceDetectPrepareUI mjQ;
    private double mjU = 0.0d;

    FaceDetectPrepareUI$9(FaceDetectPrepareUI faceDetectPrepareUI) {
        this.mjQ = faceDetectPrepareUI;
    }

    public final void l(double d) {
        x.i("MicroMsg.FaceDetectPrepareUI", "hy: reg on process : %f", new Object[]{Double.valueOf(d)});
        this.mjU = 100.0d * d;
    }

    public final void a(int i, int i2, int i3, String str) {
        x.i("MicroMsg.FaceDetectPrepareUI", "onError scene: %d, errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        FaceDetectPrepareUI.a(this.mjQ, i2, i3, str, this.mjQ.getString(h.meA));
    }

    public final void a(int i, int i2, String str, Bundle bundle) {
        x.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onUploadEnd");
        int pB = FaceDetectPrepareUI.pB(0);
        if (pB != 0) {
            this.mjQ.g(pB, 0, str, bundle);
        }
        if (FaceDetectPrepareUI.c(this.mjQ) != null) {
            FaceDetectPrepareUI.c(this.mjQ).d(pB, 0, str, bundle);
        }
    }

    public final void h(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onVerifyEnd sceneType: %d, errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str});
        int pB = FaceDetectPrepareUI.pB(i);
        if (!(pB == 0 && i2 == 0)) {
            this.mjQ.g(pB, i2, str, null);
        }
        if (FaceDetectPrepareUI.c(this.mjQ) != null) {
            FaceDetectPrepareUI.c(this.mjQ).h(pB, i2, str, kVar);
        }
    }
}
