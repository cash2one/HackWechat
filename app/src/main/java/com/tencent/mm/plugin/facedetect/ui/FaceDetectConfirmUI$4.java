package com.tencent.mm.plugin.facedetect.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.k;

class FaceDetectConfirmUI$4 implements OnClickListener {
    final /* synthetic */ FaceDetectConfirmUI miL;

    FaceDetectConfirmUI$4(FaceDetectConfirmUI faceDetectConfirmUI) {
        this.miL = faceDetectConfirmUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent();
        intent.putExtra("err_code", k.pv(90022));
        intent.putExtra("err_msg", "get confirm info error");
        FaceDetectReporter.aGK().a(FaceDetectConfirmUI.b(this.miL), false, 3, 2, 90022);
        FaceDetectReporter.aGK().mgU = System.currentTimeMillis();
        FaceDetectReporter.aGK().bi(FaceDetectConfirmUI.c(this.miL), FaceDetectConfirmUI.b(this.miL));
        FaceDetectConfirmUI.a(this.miL, intent);
        this.miL.finish();
    }
}
