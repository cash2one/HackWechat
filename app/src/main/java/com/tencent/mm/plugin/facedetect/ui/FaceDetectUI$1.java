package com.tencent.mm.plugin.facedetect.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class FaceDetectUI$1 implements OnClickListener {
    final /* synthetic */ FaceDetectUI mkq;

    FaceDetectUI$1(FaceDetectUI faceDetectUI) {
        this.mkq = faceDetectUI;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.FaceDetectUI", "hy: user cancelled with left button");
        FaceDetectUI.a(this.mkq);
    }
}
