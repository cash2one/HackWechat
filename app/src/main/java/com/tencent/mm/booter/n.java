package com.tencent.mm.booter;

import com.tencent.mm.ae.e;
import com.tencent.mm.az.k;
import com.tencent.mm.be.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public final class n {
    private static long gyK = 86400000;

    public static void run() {
        boolean z;
        ar.Hg();
        if (t.by(Long.valueOf(t.c((Long) c.CU().get(81944, null))).longValue()) * 1000 > gyK) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            e SD = d.SD();
            d.SE();
            if (!SD.hjs) {
                g.Dk();
                if (g.Dj().isSDCardAvailable()) {
                    SD.release();
                    SD.hjs = true;
                    g.CG().a(JsApiGetBackgroundAudioState.CTRL_INDEX, SD);
                    g.CG().a(new k(9), 0);
                }
            }
        }
    }
}
