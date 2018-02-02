package com.tencent.mm.plugin.facedetect.ui;

import android.os.Handler;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

class FaceDetectPrepareUI$a extends Handler {
    private WeakReference<FaceDetectPrepareUI> miW;

    private FaceDetectPrepareUI$a(FaceDetectPrepareUI faceDetectPrepareUI) {
        this.miW = null;
        this.miW = new WeakReference(faceDetectPrepareUI);
    }

    public final void handleMessage(Message message) {
        x.i("MicroMsg.FaceDetectPrepareUI", "alvinluo client msg.what: %d", new Object[]{Integer.valueOf(message.what)});
        if (this.miW != null && this.miW.get() != null) {
            switch (message.what) {
                case 0:
                    FaceDetectPrepareUI.a((FaceDetectPrepareUI) this.miW.get(), message);
                    return;
                case 1:
                    FaceDetectPrepareUI.b((FaceDetectPrepareUI) this.miW.get(), message);
                    return;
                default:
                    return;
            }
        }
    }
}
