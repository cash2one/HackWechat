package com.tencent.mm.plugin.facedetect.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.facedetect.ui.FaceDetectPrepareUI.c;

class FaceDetectPrepareUI$14 implements OnClickListener {
    final /* synthetic */ int fma;
    final /* synthetic */ int fmb;
    final /* synthetic */ String hnj;
    final /* synthetic */ FaceDetectPrepareUI mjQ;
    final /* synthetic */ boolean mjZ;
    final /* synthetic */ c mka;

    FaceDetectPrepareUI$14(FaceDetectPrepareUI faceDetectPrepareUI, boolean z, c cVar, int i, int i2, String str) {
        this.mjQ = faceDetectPrepareUI;
        this.mjZ = z;
        this.mka = cVar;
        this.fma = i;
        this.fmb = i2;
        this.hnj = str;
    }

    public final void onClick(View view) {
        if (!this.mjZ) {
            if (this.mka != null) {
                this.mka.i(this.fma, this.fmb, this.hnj);
            }
            this.mjQ.b(this.fma, this.fmb, this.hnj, null);
        } else if (FaceDetectPrepareUI.c(this.mjQ) != null) {
            FaceDetectPrepareUI.c(this.mjQ).aGl();
        }
    }
}
