package com.tencent.mm.plugin.walletlock.fingerprint.a;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.soter.d.b;
import com.tencent.mm.plugin.walletlock.b.g;
import com.tencent.mm.plugin.walletlock.b.h;
import com.tencent.mm.plugin.walletlock.fingerprint.a.d.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class c implements e, d {
    private String mzL = null;
    boolean pou = false;
    a tfv = null;
    private a tfw = null;
    private boolean tfx = false;

    public final void a(a aVar, Bundle bundle) {
        this.mzL = bundle.getString("key_pay_passwd");
        this.tfx = bundle.getBoolean("key_fp_lock_offline_mode");
        x.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo prepare pwd: %s, isOfflineMode: %b", new Object[]{this.mzL, Boolean.valueOf(this.tfx)});
        this.tfv = aVar;
        this.pou = false;
        g.tho.thp = null;
        g.tho.thq = null;
        com.tencent.mm.kernel.g.CG().a(1967, this);
        com.tencent.mm.kernel.g.CG().a(1548, this);
        if (this.tfx) {
            g.tho.thp = String.valueOf(System.currentTimeMillis());
            jV(false);
            return;
        }
        SharedPreferences cft = ac.cft();
        if (cft != null) {
            String string = cft.getString("cpu_id", null);
            String string2 = cft.getString("uid", null);
            x.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo cpuId: %s, uid: %s", new Object[]{string, string2});
            if (bh.ov(string) || bh.ov(string2)) {
                b.a(true, true, new 2(this, cft));
            } else {
                eD(string, string2);
            }
        } else if (this.tfv != null) {
            this.tfv.ac(2, "system error");
        }
    }

    private void jV(boolean z) {
        x.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo prepareAuthKey isNeedChangeAuthKey: %b", new Object[]{Boolean.valueOf(z)});
        com.tencent.d.b.a.a(new com.tencent.d.b.a.b<com.tencent.d.b.a.c>(this) {
            final /* synthetic */ c tfy;

            {
                this.tfy = r1;
            }

            public final /* synthetic */ void a(com.tencent.d.b.a.e eVar) {
                com.tencent.d.b.a.c cVar = (com.tencent.d.b.a.c) eVar;
                x.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo prepareAuthKey onResult errCode: %d, errMsg: %s, isCancelled: %b", new Object[]{Integer.valueOf(cVar.errCode), cVar.fnL, Boolean.valueOf(this.tfy.pou)});
                if (!this.tfy.pou) {
                    if (cVar.isSuccess()) {
                        x.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo update wallet lock auth key success");
                        if (this.tfy.tfv != null) {
                            this.tfy.tfv.ac(0, "prepare auth key ok");
                            return;
                        }
                        return;
                    }
                    x.e("MicroMsg.FingerprintLockOpenDelegate", "alvinluo error when prepare auth key");
                    h.ed(2, cVar.errCode);
                    if (this.tfy.tfv != null) {
                        this.tfy.tfv.ac(2, cVar.fnL);
                    }
                }
            }
        }, z, 3, this.tfx ? null : new g(this.mzL), new com.tencent.mm.plugin.soter.b.e());
    }

    static void eD(String str, String str2) {
        com.tencent.mm.kernel.g.CG().a(new e(str, str2), 0);
    }

    public final void a(a aVar, String str, String str2, String str3) {
        x.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo do open fingerprint lock");
        this.tfw = aVar;
        com.tencent.mm.kernel.g.CG().a(new f(str2, str3, str), 0);
    }

    public final void release() {
        x.d("MicroMsg.FingerprintLockOpenDelegate", "alvinluo release open delegate");
        this.tfv = null;
        this.tfw = null;
        this.pou = true;
        com.tencent.mm.kernel.g.CG().b(1967, this);
        com.tencent.mm.kernel.g.CG().b(1548, this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo fingerprint wallet lock open delegate errType: %d, errCode: %d, errMsg: %s, cgi type: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(kVar.getType())});
        if (!this.pou) {
            if (kVar instanceof e) {
                if (i == 0 && i2 == 0) {
                    e eVar = (e) kVar;
                    g.tho.thp = eVar.mzI;
                    jV(eVar.tfA);
                } else if (this.tfv != null) {
                    this.tfv.ac(7, "get challenge failed");
                }
            } else if (!(kVar instanceof f)) {
            } else {
                if (i == 0 && i2 == 0) {
                    h.ka(true);
                    if (this.tfw != null) {
                        this.tfw.ac(0, "open touch lock ok");
                        return;
                    }
                    return;
                }
                h.ka(false);
                if (this.tfw != null) {
                    this.tfw.ac(6, "open touch lock failed");
                }
            }
        }
    }
}
