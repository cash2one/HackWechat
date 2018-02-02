package com.tencent.mm.plugin.sight.encode.ui;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class SightVideoTextureView$3 implements Runnable {
    final /* synthetic */ SightVideoTextureView qxT;

    SightVideoTextureView$3(SightVideoTextureView sightVideoTextureView) {
        this.qxT = sightVideoTextureView;
    }

    public final void run() {
        try {
            this.qxT.btO();
            SightVideoTextureView.e(this.qxT).stop();
            SightVideoTextureView.e(this.qxT).release();
            if (SightVideoTextureView.f(this.qxT) != null && SightVideoTextureView.f(this.qxT).isValid()) {
                SightVideoTextureView.f(this.qxT).release();
                SightVideoTextureView.a(this.qxT, null);
            }
        } catch (Throwable e) {
            x.w("MicroMsg.SightVideoTextureView", "stop play video error: %s, %s", e.getMessage(), bh.i(e));
        }
        SightVideoTextureView.a(this.qxT, null);
    }

    public final String toString() {
        return super.toString() + "|stopPlayVideo";
    }
}
