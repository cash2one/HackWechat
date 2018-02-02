package com.tencent.mm.plugin.ipcall.a;

import com.tencent.mm.ae.e;
import com.tencent.mm.az.j;
import com.tencent.mm.az.k;
import com.tencent.mm.az.m;
import com.tencent.mm.az.r;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.z.ar;

public final class d implements e {
    private static d nCt = null;
    private boolean hjs = false;
    c nCu = new 1(this);
    private int retryCount = 0;

    private d() {
    }

    public static d aTn() {
        if (nCt == null) {
            nCt = new d();
        }
        return nCt;
    }

    public final void fQ(boolean z) {
        if (!ar.Hj()) {
            x.i("MicroMsg.IPCallCoutryConfigUpdater", "tryUpdate, acc not ready");
        } else if (this.hjs) {
            x.i("MicroMsg.IPCallCoutryConfigUpdater", "tryUpdate updating");
        } else {
            x.d("MicroMsg.IPCallCoutryConfigUpdater", "tryupdate, isForce: %b", new Object[]{Boolean.valueOf(z)});
            if (!z) {
                ar.Hg();
                long longValue = ((Long) com.tencent.mm.z.c.CU().get(a.xpc, Long.valueOf(0))).longValue();
                long currentTimeMillis = System.currentTimeMillis();
                if (longValue != 0 && Math.abs(currentTimeMillis - longValue) < 86400000) {
                    x.i("MicroMsg.IPCallCoutryConfigUpdater", "tryUpdate, not reach the update time limit");
                    return;
                }
            }
            x.i("MicroMsg.IPCallCoutryConfigUpdater", "try update now");
            this.hjs = true;
            ar.CG().a(JsApiGetBackgroundAudioState.CTRL_INDEX, this);
            ar.CG().a(JsApiSetBackgroundAudioState.CTRL_INDEX, this);
            aTo();
        }
    }

    private static void aTo() {
        boolean z;
        m[] ik = r.QH().ik(26);
        if (ik == null || ik.length <= 0) {
            z = false;
        } else {
            z = true;
        }
        ar.CG().a(new k(z), 0);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
        x.d("MicroMsg.IPCallCoutryConfigUpdater", "onSceneEnd, errType: %d, errCode: %d, isUpdating: %b", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(this.hjs)});
        if (this.hjs) {
            boolean z;
            if (i == 0 || i2 == 0) {
                z = true;
            } else {
                z = false;
            }
            x.d("MicroMsg.IPCallCoutryConfigUpdater", "onSceneEnd, isSuccess: %b", new Object[]{Boolean.valueOf(z)});
            if (kVar.getType() == JsApiGetBackgroundAudioState.CTRL_INDEX) {
                if (z) {
                    x.d("MicroMsg.IPCallCoutryConfigUpdater", "get package list success, start download");
                    m[] ik = r.QH().ik(26);
                    if (ik == null || ik.length == 0) {
                        x.d("MicroMsg.IPCallCoutryConfigUpdater", "do not exist package info");
                        aTp();
                        return;
                    }
                    x.d("MicroMsg.IPCallCoutryConfigUpdater", "infos.length: %d", new Object[]{Integer.valueOf(ik.length)});
                    m mVar = ik[0];
                    x.d("MicroMsg.IPCallCoutryConfigUpdater", "stored info type: %d, id: %d, version: %d, status: %d, name: %s", new Object[]{Integer.valueOf(mVar.fvM), Integer.valueOf(mVar.id), Integer.valueOf(mVar.version), Integer.valueOf(mVar.status), mVar.QD()});
                    if (mVar.status == 3) {
                        x.d("MicroMsg.IPCallCoutryConfigUpdater", "downloading this package, ignore");
                    } else if (mVar.status != 5) {
                        x.d("MicroMsg.IPCallCoutryConfigUpdater", "already download this package");
                        c.aTj().fP(true);
                        aTp();
                    } else {
                        ar.CG().a(new j(mVar.id, 26), 0);
                    }
                } else if (this.retryCount < 3) {
                    this.retryCount++;
                    aTo();
                    x.d("MicroMsg.IPCallCoutryConfigUpdater", "retry get package list, retryCount: %d", new Object[]{Integer.valueOf(this.retryCount)});
                } else {
                    x.e("MicroMsg.IPCallCoutryConfigUpdater", "reach retry limit");
                }
            } else if (kVar.getType() == JsApiSetBackgroundAudioState.CTRL_INDEX && z) {
                x.d("MicroMsg.IPCallCoutryConfigUpdater", "download package success");
                c.aTj().fP(true);
                aTp();
            }
        }
    }

    private void aTp() {
        this.hjs = false;
        this.retryCount = 0;
        long currentTimeMillis = System.currentTimeMillis();
        ar.Hg();
        com.tencent.mm.z.c.CU().a(a.xpc, Long.valueOf(currentTimeMillis));
    }
}
