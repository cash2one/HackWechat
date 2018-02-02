package com.tencent.mm.permission;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.m;
import com.tencent.mm.az.j;
import com.tencent.mm.az.k;
import com.tencent.mm.az.r;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public final class a implements e {
    private static a ibH;
    private boolean ibI = false;
    private int mRetryTimes = 3;

    public static a VZ() {
        if (ibH == null) {
            ibH = new a();
        }
        return ibH;
    }

    public final void Wa() {
        if (ar.Hj()) {
            if (!this.ibI) {
                ar.Hg();
                if (c.isSDCardAvailable()) {
                    ar.Hg();
                    if (bh.Wp() - ((Long) c.CU().get(327944, Long.valueOf(0))).longValue() >= 86400000) {
                        release();
                        this.ibI = true;
                        ar.CG().a(new k(23), 0);
                        ar.CG().a(JsApiGetBackgroundAudioState.CTRL_INDEX, this);
                        ar.CG().a(JsApiSetBackgroundAudioState.CTRL_INDEX, this);
                        return;
                    }
                    return;
                }
            }
            x.e("MicroMsg.PermissionConfigUpdater", "not to update, isUpdating: %s", new Object[]{Boolean.valueOf(this.ibI)});
        }
    }

    private void release() {
        this.ibI = false;
        ar.CG().b(JsApiGetBackgroundAudioState.CTRL_INDEX, this);
        ar.CG().b(JsApiSetBackgroundAudioState.CTRL_INDEX, this);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
        if ((kVar instanceof m) && ((m) kVar).Kl() == 23) {
            int type = kVar.getType();
            if (JsApiGetBackgroundAudioState.CTRL_INDEX == type) {
                if (i == 0 && i2 == 0) {
                    QC();
                    com.tencent.mm.az.m[] ik = r.QH().ik(23);
                    if (ik == null || ik.length == 0) {
                        x.i("MicroMsg.PermissionConfigUpdater", "error no pkg found.");
                        release();
                        return;
                    }
                    com.tencent.mm.az.m mVar = ik[0];
                    x.i("MicroMsg.PermissionConfigUpdater", "permission, pkgId: %d, version: %d, status: %d, type: %d", new Object[]{Integer.valueOf(mVar.id), Integer.valueOf(mVar.version), Integer.valueOf(mVar.status), Integer.valueOf(mVar.fvM)});
                    if (5 != mVar.status) {
                        release();
                        return;
                    }
                    ar.CG().a(new j(mVar.id, 23), 0);
                    return;
                }
                type = this.mRetryTimes - 1;
                this.mRetryTimes = type;
                if (type <= 0) {
                    if (ar.Hj()) {
                        ar.Hg();
                        c.CU().set(327944, Long.valueOf((bh.Wp() - 86400000) + 3600000));
                    }
                    this.mRetryTimes = 3;
                }
                release();
                return;
            } else if (JsApiSetBackgroundAudioState.CTRL_INDEX == type) {
                if (i == 0 && i2 == 0) {
                    QC();
                }
                release();
                return;
            } else {
                return;
            }
        }
        x.d("MicroMsg.PermissionConfigUpdater", "another scene");
    }

    private static void QC() {
        if (ar.Hj()) {
            ar.Hg();
            c.CU().set(327944, Long.valueOf(bh.Wp()));
        }
    }
}
