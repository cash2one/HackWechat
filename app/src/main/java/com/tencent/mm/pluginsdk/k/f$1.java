package com.tencent.mm.pluginsdk.k;

import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import com.tencent.mm.sdk.platformtools.x;

class f$1 implements AutoFocusCallback {
    final /* synthetic */ f viK;

    f$1(f fVar) {
        this.viK = fVar;
    }

    public final void onAutoFocus(boolean z, Camera camera) {
        x.d("MicroMsg.YuvReocrder", "auto focus callback");
        f.a(this.viK);
    }
}
