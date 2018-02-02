package com.tencent.mm.az;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class c implements e {
    private static c hJn;
    private int hJm = 3;
    private boolean hjs = false;

    public static c QB() {
        if (hJn == null) {
            hJn = new c();
        }
        return hJn;
    }

    public final void update() {
        x.i("MicroMsg.ConfigListUpdater", "isUpdateing : " + this.hjs);
        x.i("MicroMsg.ConfigListUpdater", "isSDCardAvailable : " + g.Dj().isSDCardAvailable());
        if (!this.hjs && g.Dj().isSDCardAvailable()) {
            release();
            this.hjs = true;
            g.Di().gPJ.a(JsApiGetBackgroundAudioState.CTRL_INDEX, this);
            g.Di().gPJ.a(new k(7), 0);
        }
    }

    private void release() {
        this.hjs = false;
        g.Di().gPJ.b(JsApiGetBackgroundAudioState.CTRL_INDEX, this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == JsApiGetBackgroundAudioState.CTRL_INDEX) {
            x.i("MicroMsg.ConfigListUpdater", "getPackageList sceneEnd, %s, %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            if (i == 0 && i2 == 0) {
                g.Dj().CU().set(81938, Long.valueOf(bh.Wo()));
            } else {
                int i3 = this.hJm - 1;
                this.hJm = i3;
                if (i3 < 0) {
                    g.Dj().CU().set(81938, Long.valueOf(((bh.Wp() - 86400000) + 3600000) / 1000));
                    this.hJm = 3;
                }
            }
            release();
        }
    }
}
