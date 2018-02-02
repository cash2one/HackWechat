package com.tencent.mm.plugin.facedetect.views;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

class FaceDetectCameraView$a extends af {
    private WeakReference<FaceDetectCameraView> zH;

    private FaceDetectCameraView$a(FaceDetectCameraView faceDetectCameraView) {
        super(Looper.getMainLooper());
        this.zH = new WeakReference(faceDetectCameraView);
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.zH == null || this.zH.get() == null) {
            x.e("MicroMsg.FaceDetectCameraView", "hy: no referenced view. exit");
        } else if (message.what == 1) {
            FaceCharacteristicsResult faceCharacteristicsResult = (FaceCharacteristicsResult) message.obj;
            if (FaceCharacteristicsResult.ps(faceCharacteristicsResult.errCode)) {
                if (FaceDetectCameraView.a((FaceDetectCameraView) this.zH.get()) != null) {
                    FaceDetectCameraView.a((FaceDetectCameraView) this.zH.get()).d(faceCharacteristicsResult);
                }
            } else if (FaceCharacteristicsResult.pr(faceCharacteristicsResult.errCode)) {
                if (FaceDetectCameraView.a((FaceDetectCameraView) this.zH.get()) != null) {
                    FaceDetectCameraView.a((FaceDetectCameraView) this.zH.get()).b(faceCharacteristicsResult.errCode, faceCharacteristicsResult.fnL);
                }
            } else if (FaceDetectCameraView.a((FaceDetectCameraView) this.zH.get()) != null) {
                FaceDetectCameraView.a((FaceDetectCameraView) this.zH.get()).c(faceCharacteristicsResult);
            }
        }
    }
}
