package com.tencent.mm.plugin.mmsight.ui;

import android.graphics.SurfaceTexture;
import com.tencent.mm.plugin.video.b;
import com.tencent.mm.sdk.platformtools.x;

class SightCaptureUI$7 implements b {
    final /* synthetic */ SightCaptureUI oDb;

    SightCaptureUI$7(SightCaptureUI sightCaptureUI) {
        this.oDb = sightCaptureUI;
    }

    public final void d(SurfaceTexture surfaceTexture) {
        x.i("MicroMsg.SightCaptureUI", "callback onSurfaceTextureAvailable set local surface: %s", new Object[]{surfaceTexture});
        SightCaptureUI.a(this.oDb, surfaceTexture);
        if (SightCaptureUI.I(this.oDb)) {
            SightCaptureUI.g(this.oDb, 1);
        } else {
            SightCaptureUI.g(this.oDb, 8);
        }
    }
}
