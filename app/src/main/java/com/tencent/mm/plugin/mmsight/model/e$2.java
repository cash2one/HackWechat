package com.tencent.mm.plugin.mmsight.model;

import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import com.tencent.mm.sdk.platformtools.x;

class e$2 implements AutoFocusCallback {
    final /* synthetic */ e osA;

    e$2(e eVar) {
        this.osA = eVar;
    }

    public final void onAutoFocus(boolean z, Camera camera) {
        x.v("MicroMsg.MMSightCamera", "auto focus callback success %s, status: %s", new Object[]{Boolean.valueOf(z), e.s(this.osA)});
        e.osw = true;
    }
}
