package com.tencent.mm.plugin.facedetect.ui;

import com.tencent.mm.plugin.facedetect.a.h;
import com.tencent.mm.plugin.facedetect.b.c;
import com.tencent.mm.sdk.platformtools.x;

class FaceDetectPrepareUI$8 implements c {
    final /* synthetic */ FaceDetectPrepareUI mjQ;

    FaceDetectPrepareUI$8(FaceDetectPrepareUI faceDetectPrepareUI) {
        this.mjQ = faceDetectPrepareUI;
    }

    public final void e(long j, byte[] bArr) {
        x.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onGetConfigSuccess, bioId: %d, isCancel: %b", new Object[]{Long.valueOf(j), Boolean.valueOf(FaceDetectPrepareUI.b(this.mjQ))});
        if (!FaceDetectPrepareUI.b(this.mjQ)) {
            FaceDetectPrepareUI.a(this.mjQ, j);
            FaceDetectPrepareUI.a(this.mjQ, bArr);
            FaceDetectPrepareUI.a(this.mjQ, j, bArr);
        }
    }

    public final void Y(int i, String str) {
        x.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onGetConfigFailed, errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(90015), str});
        FaceDetectPrepareUI.a(this.mjQ, FaceDetectPrepareUI.pB(i), 90015, str, this.mjQ.getString(h.mdY));
    }
}
