package com.tencent.mm.plugin.facedetect.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.x;

class FaceDetectConfirmUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ FaceDetectConfirmUI miL;

    FaceDetectConfirmUI$1(FaceDetectConfirmUI faceDetectConfirmUI) {
        this.miL = faceDetectConfirmUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        x.i("MicroMsg.FaceDetectConfirmUI", "alvinluo cancel with back button");
        FaceDetectConfirmUI.a(this.miL);
        return false;
    }
}
