package com.tencent.mm.plugin.sight.encode.ui;

import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import com.tencent.mm.plugin.sight.encode.ui.e.a;
import com.tencent.mm.sdk.platformtools.x;

class e$a$1 implements AutoFocusCallback {
    e$a$1() {
    }

    public final void onAutoFocus(boolean z, Camera camera) {
        x.v("MicroMsg.SightCamera", "auto focus callback");
        a.osw = true;
    }
}
