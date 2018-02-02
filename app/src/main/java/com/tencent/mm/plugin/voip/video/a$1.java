package com.tencent.mm.plugin.voip.video;

import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements AutoFocusCallback {
    final /* synthetic */ a sto;

    a$1(a aVar) {
        this.sto = aVar;
    }

    public final void onAutoFocus(boolean z, Camera camera) {
        x.d("MicroMsg.Voip.CaptureRender", "onAutoFocus, success:%b", new Object[]{Boolean.valueOf(z)});
        this.sto.sti = true;
    }
}
