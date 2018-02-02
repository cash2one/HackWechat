package com.tencent.mm.plugin.facedetect.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class FaceDetectConfirmUI$2 implements OnClickListener {
    final /* synthetic */ FaceDetectConfirmUI miL;

    FaceDetectConfirmUI$2(FaceDetectConfirmUI faceDetectConfirmUI) {
        this.miL = faceDetectConfirmUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(this.miL, FaceDetectPrepareUI.class);
        Bundle extras = this.miL.getIntent().getExtras();
        if (extras != null) {
            extras.putString("key_feedback_url", "http://support.qq.com/product/19936");
            intent.putExtras(extras);
            this.miL.startActivityForResult(intent, 1);
            return;
        }
        x.e("MicroMsg.FaceDetectConfirmUI", "alvinluo extras is null when start FaceDetectPrepareUI");
    }
}
