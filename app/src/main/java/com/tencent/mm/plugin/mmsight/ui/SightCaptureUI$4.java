package com.tencent.mm.plugin.mmsight.ui;

import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.mmsight.model.e;
import com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView.a;

class SightCaptureUI$4 implements a {
    final /* synthetic */ SightCaptureUI oDb;

    SightCaptureUI$4(SightCaptureUI sightCaptureUI) {
        this.oDb = sightCaptureUI;
    }

    public final void D(float f, float f2) {
        if (SightCaptureUI.e(this.oDb) != 0 && SightCaptureUI.e(this.oDb) != 3 && SightCaptureUI.e(this.oDb) != 4 && SightCaptureUI.w(this.oDb) != null) {
            e h = SightCaptureUI.h(this.oDb);
            int width = SightCaptureUI.w(this.oDb).getWidth();
            int height = SightCaptureUI.w(this.oDb).getHeight();
            if (!d.fN(14)) {
                h.osy.removeMessages(4354);
                h.osy.osI = f;
                h.osy.nJk = f2;
                h.osy.osJ = width;
                h.osy.osK = height;
                h.osy.sendMessageDelayed(h.osy.obtainMessage(4354, h.gEB), 400);
            }
            SightCaptureUI sightCaptureUI = this.oDb;
            if (sightCaptureUI.oCt != null) {
                LayoutParams layoutParams = (LayoutParams) sightCaptureUI.oCt.getLayoutParams();
                layoutParams.leftMargin = ((int) f) - (sightCaptureUI.oCt.mWidth / 2);
                layoutParams.topMargin = ((int) f2) - (sightCaptureUI.oCt.mHeight / 2);
                sightCaptureUI.oCt.setLayoutParams(layoutParams);
                CameraFrontSightView cameraFrontSightView = sightCaptureUI.oCt;
                cameraFrontSightView.setVisibility(0);
                cameraFrontSightView.oAD = true;
                cameraFrontSightView.oAE = false;
                cameraFrontSightView.oAF = false;
                cameraFrontSightView.oAG = false;
                cameraFrontSightView.oAH = System.currentTimeMillis();
                cameraFrontSightView.invalidate();
            }
        }
    }

    public final void bbr() {
        if (SightCaptureUI.e(this.oDb) != 0 && SightCaptureUI.x(this.oDb) > 1) {
            SightCaptureUI.h(this.oDb).osy.removeMessages(4354);
            SightCaptureUI.r(this.oDb);
        }
    }

    public final void Yp() {
        if (SightCaptureUI.e(this.oDb) != 0 && SightCaptureUI.h(this.oDb) != null) {
            SightCaptureUI.h(this.oDb).b(true, false, 1);
        }
    }

    public final void Yq() {
        if (SightCaptureUI.e(this.oDb) != 0 && SightCaptureUI.h(this.oDb) != null) {
            SightCaptureUI.h(this.oDb).b(false, false, 1);
        }
    }
}
