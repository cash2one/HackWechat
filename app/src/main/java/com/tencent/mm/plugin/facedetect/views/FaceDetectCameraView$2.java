package com.tencent.mm.plugin.facedetect.views;

import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.sdk.platformtools.x;

class FaceDetectCameraView$2 implements Runnable {
    final /* synthetic */ FaceDetectCameraView mmc;
    final /* synthetic */ int mmd;
    final /* synthetic */ int mme;
    final /* synthetic */ int mmf;

    FaceDetectCameraView$2(FaceDetectCameraView faceDetectCameraView, int i, int i2, int i3) {
        this.mmc = faceDetectCameraView;
        this.mmd = i;
        this.mme = i2;
        this.mmf = i3;
    }

    public final void run() {
        int i = this.mmd - this.mme;
        x.i("MicroMsg.FaceDetectCameraView", "alvinluo restHeight: %d", new Object[]{Integer.valueOf(i)});
        if (i > 0) {
            i /= 2;
            LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mmf, this.mme);
            MarginLayoutParams marginLayoutParams = new MarginLayoutParams(this.mmc.getLayoutParams());
            layoutParams.setMargins(marginLayoutParams.leftMargin, i, marginLayoutParams.rightMargin, marginLayoutParams.height + i);
            x.v("MicroMsg.FaceDetectCameraView", "alvinluo margin left: %d, right: %d, top: %d, bottom: %d", new Object[]{Integer.valueOf(marginLayoutParams.leftMargin), Integer.valueOf(marginLayoutParams.rightMargin), Integer.valueOf(i), Integer.valueOf(i + marginLayoutParams.height)});
            this.mmc.setLayoutParams(layoutParams);
            this.mmc.invalidate();
        }
    }
}
