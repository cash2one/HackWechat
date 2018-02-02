package com.tencent.mm.az;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class i implements e {
    public i() {
        g.Di().gPJ.a(JsApiGetBackgroundAudioState.CTRL_INDEX, this);
        g.Di().gPJ.a(JsApiSetBackgroundAudioState.CTRL_INDEX, this);
        g.Di().gPJ.a(new k(5), 0);
    }

    private void release() {
        g.Di().gPJ.b(JsApiGetBackgroundAudioState.CTRL_INDEX, this);
        g.Di().gPJ.b(JsApiSetBackgroundAudioState.CTRL_INDEX, this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if ((kVar instanceof m) && ((m) kVar).Kl() == 5) {
            int type = kVar.getType();
            if (type == JsApiGetBackgroundAudioState.CTRL_INDEX) {
                if (i == 0 && i2 == 0) {
                    QC();
                    m[] ik = r.QH().ik(5);
                    if (ik == null || ik.length == 0) {
                        x.i("MicroMsg.LangPackageUpdater", "error no pkg found.");
                        release();
                        return;
                    }
                    m mVar = ik[0];
                    x.i("MicroMsg.LangPackageUpdater", "dkregcode Pkg id:" + mVar.id + " version:" + mVar.version + " status:" + mVar.status + " type:" + mVar.fvM);
                    if (5 != mVar.status) {
                        release();
                        return;
                    }
                    g.Di().gPJ.a(new j(mVar.id, 5), 0);
                    return;
                }
                release();
                return;
            } else if (type == JsApiSetBackgroundAudioState.CTRL_INDEX) {
                if (i == 0 && i2 == 0) {
                    QC();
                }
                release();
                return;
            } else {
                return;
            }
        }
        x.d("MicroMsg.LangPackageUpdater", "another scene");
    }

    private static void QC() {
        g.Dj().CU().set(81939, Long.valueOf(bh.Wp()));
    }
}
