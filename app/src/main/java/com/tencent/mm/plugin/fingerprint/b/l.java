package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import com.tencent.d.b.a.b;
import com.tencent.d.b.a.c;
import com.tencent.d.b.a.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.a;
import com.tencent.mm.pluginsdk.wallet.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.lang.ref.WeakReference;

public final class l implements j {
    WeakReference<WalletBaseUI> mzE = null;
    private a mzn = null;
    private a mzo = null;
    private String mzr = "";

    public final void a(Context context, a aVar, String str) {
        x.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: prepare");
        this.mzE = new WeakReference((WalletBaseUI) context);
        this.mzn = aVar;
        this.mzr = str;
        ((WalletBaseUI) this.mzE.get()).ji(1586);
        ((WalletBaseUI) this.mzE.get()).ji(1638);
        com.tencent.mm.plugin.soter.c.a.bCL();
        x.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: start gen auth key");
        com.tencent.d.b.a.a(new b<c>(this) {
            final /* synthetic */ l mzF;

            {
                this.mzF = r1;
            }

            public final /* synthetic */ void a(e eVar) {
                c cVar = (c) eVar;
                x.i("MicroMsg.SoterFingerprintOpenDelegate", "alvinluo prepare auth key errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(cVar.errCode), cVar.fnL});
                if (cVar.isSuccess()) {
                    x.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: update pay auth key success");
                    if (this.mzF.mzE == null || this.mzF.mzE.get() == null) {
                        this.mzF.ad(-1, "base ui is null");
                        return;
                    } else {
                        ((WalletBaseUI) this.mzF.mzE.get()).b(new com.tencent.mm.plugin.fingerprint.c.a(), false);
                        return;
                    }
                }
                com.tencent.mm.plugin.soter.c.a.dM(2, cVar.errCode);
                if (cVar.errCode == 12) {
                    x.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: failed upload: model is null or necessary elements null");
                    com.tencent.mm.plugin.soter.c.a.c(4, -1000223, -1, "gen auth key failed: unexpected! generated but cannot get");
                } else if (cVar.errCode == 5) {
                    com.tencent.mm.plugin.soter.c.a.c(4, -1000223, -1, "gen auth key failed");
                } else if (cVar.errCode == 10) {
                    x.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: update pay auth key failed. remove");
                    com.tencent.d.b.a.Ia(1);
                    com.tencent.mm.plugin.soter.c.a.c(5, 4, cVar.errCode, "upload auth key failed");
                } else if (cVar.errCode == 4 || cVar.errCode == 3) {
                    x.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: gen auth key failed");
                    com.tencent.mm.plugin.soter.c.a.c(2, -1000223, -1, "gen ask failed");
                } else if (cVar.errCode == 9) {
                    x.e("MicroMsg.SoterFingerprintOpenDelegate", "alvinluo upload ask failed");
                    com.tencent.mm.plugin.soter.c.a.c(3, 4, cVar.errCode, cVar.fnL);
                } else {
                    x.e("MicroMsg.SoterFingerprintOpenDelegate", "alvinluo unknown error when prepare auth key");
                    com.tencent.mm.plugin.soter.c.a.c(1000, -1000223, cVar.errCode, cVar.fnL);
                }
                this.mzF.ad(-1, cVar.fnL);
            }
        }, true, 1, new com.tencent.mm.plugin.fingerprint.c.c(this.mzr), new com.tencent.mm.plugin.soter.b.e());
    }

    public final void clear() {
        x.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: clear");
        if (!(this.mzE == null || this.mzE.get() == null)) {
            ((WalletBaseUI) this.mzE.get()).jj(1586);
            ((WalletBaseUI) this.mzE.get()).jj(1638);
        }
        this.mzn = null;
        s.sPp.reset();
        if (this.mzE != null && this.mzE.get() != null) {
            this.mzE.clear();
        }
    }

    final void ad(int i, String str) {
        if (this.mzn != null) {
            this.mzn.ac(i, str);
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: onSceneEnd: errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (bh.ov(str)) {
            str = ac.getContext().getString(i.uJi);
        }
        if (kVar instanceof com.tencent.mm.plugin.fingerprint.c.a) {
            if (i == 0 && i2 == 0) {
                x.i("MicroMsg.SoterFingerprintOpenDelegate", "get challenge success");
                if (bh.ov(((com.tencent.mm.plugin.fingerprint.c.a) kVar).mzI)) {
                    ad(-1, str);
                    return true;
                }
                ag.y(new Runnable(this) {
                    final /* synthetic */ l mzF;

                    {
                        this.mzF = r1;
                    }

                    public final void run() {
                        this.mzF.ad(0, "");
                    }
                });
            } else {
                x.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: failed get challenge");
                ad(i2, str);
                com.tencent.mm.plugin.soter.c.a.c(7, i, i2, "get challenge failed");
                return true;
            }
        }
        if (!(kVar instanceof com.tencent.mm.plugin.fingerprint.c.b)) {
            return false;
        }
        if (i2 == 0 && i == 0) {
            x.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: open success");
            com.tencent.mm.plugin.soter.c.a.bCM();
            com.tencent.mm.plugin.soter.c.a.c(0, 0, 0, "OK");
            ae(0, str);
        } else {
            x.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: open");
            com.tencent.mm.plugin.soter.c.a.c(8, i, i2, "open fp pay failed");
            ae(-1, str);
        }
        return true;
    }

    private void ae(int i, String str) {
        x.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: callback total");
        clear();
        this.mzo.ac(i, str);
        this.mzo = null;
    }

    public final void a(a aVar, String str, int i) {
        x.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: doOpenFP");
        this.mzo = aVar;
        com.tencent.d.a.c.i iVar = s.sPp.sPr;
        if (iVar == null) {
            x.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: signature is null");
            com.tencent.mm.plugin.soter.c.a.c(9, -1000223, -1, "signature is null");
            ad(-1, ac.getContext().getString(i.uJi));
        } else if (this.mzE != null && this.mzE.get() != null) {
            ((WalletBaseUI) this.mzE.get()).l(new com.tencent.mm.plugin.fingerprint.c.b(iVar.AcA, iVar.signature, this.mzr));
        }
    }
}
