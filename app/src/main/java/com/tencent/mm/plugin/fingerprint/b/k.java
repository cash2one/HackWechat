package com.tencent.mm.plugin.fingerprint.b;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.d.a.c.i;
import com.tencent.d.b.a.e;
import com.tencent.d.b.c.a;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.g.a.lf;
import com.tencent.mm.plugin.soter.d.b;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.pluginsdk.wallet.c;
import com.tencent.mm.pluginsdk.wallet.j;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLiveConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class k extends a {
    private l mzA = null;
    private a mzB = null;

    public final boolean aKd() {
        boolean z;
        if (q.gFY.gGh == 1) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.SoterAuthMgrImp", "hy: config support: %b, device support: %b", new Object[]{Boolean.valueOf(z), Boolean.valueOf(com.tencent.d.b.a.cFW())});
        return z && com.tencent.d.b.a.cFW();
    }

    public final boolean aKe() {
        return com.tencent.d.a.a.id(ac.getContext());
    }

    public final void aKf() {
        x.i("MicroMsg.SoterAuthMgrImp", "hy: soter init fp. Do nothing?? Prepare ASK??");
        e.fl(true);
        e.fk(true);
        b.a(false, false, null);
    }

    public final boolean aKh() {
        return false;
    }

    public final void cC(Context context) {
        x.i("MicroMsg.SoterAuthMgrImp", "hy: start startRigesterSysFP");
    }

    public final boolean aKi() {
        return aKd();
    }

    @TargetApi(16)
    public final int a(final c cVar, int i, boolean z) {
        if (z) {
            x.i("MicroMsg.SoterAuthMgrImp", "hy: req restart after fail, but no need");
        } else {
            com.tencent.d.b.c.b 1 = new 1(this, cVar);
            this.mzB = new a();
            com.tencent.d.b.a.a(new com.tencent.d.b.a.b<com.tencent.d.b.a.a>(this) {
                final /* synthetic */ k mzD;

                public final /* synthetic */ void a(e eVar) {
                    com.tencent.d.b.a.a aVar = (com.tencent.d.b.a.a) eVar;
                    x.i("MicroMsg.SoterAuthMgrImp", "alvinluo requestAuthAndSign onResult errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(aVar.errCode), aVar.fnL});
                    if (aVar.isSuccess()) {
                        s.sPp.sPr = (i) aVar.AcB;
                        if (cVar != null) {
                            cVar.aH(0, -1);
                            return;
                        }
                        return;
                    }
                    com.tencent.mm.plugin.soter.c.a.dM(3, aVar.errCode);
                    if (aVar.errCode == 13) {
                        x.i("MicroMsg.SoterAuthMgrImp", "hy: init error, maybe key invalid. remove former key and give suggestion");
                        com.tencent.d.a.a.bs(e.aKq(), true);
                        if (cVar != null) {
                            cVar.aH(TXLiveConstants.PLAY_EVT_PLAY_LOADING, -1);
                        }
                    } else if (aVar.errCode == 25) {
                        x.i("MicroMsg.SoterAuthMgrImp", "hy: too many trial");
                        if (cVar != null) {
                            cVar.aH(10308, -1);
                        }
                    } else if (aVar.errCode == 24) {
                        x.i("MicroMsg.SoterAuthMgrImp", "alvinluo user cancelled");
                        if (cVar != null) {
                            cVar.aH(MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN, -1);
                        }
                    } else if (aVar.errCode == 26) {
                        x.e("MicroMsg.SoterAuthMgrImp", "alvinluo add authenticate task failed");
                        if (cVar != null) {
                            cVar.aH(TXLiveConstants.PLAY_EVT_CHANGE_RESOLUTION, -1);
                        }
                    } else if (cVar != null) {
                        cVar.aH(TXLiveConstants.PLAY_EVT_PLAY_PROGRESS, -1);
                    }
                }
            }, new com.tencent.d.b.f.b.a().Ib(1).io(ac.getContext()).a(this.mzB).abA(s.sPp.mzI).a(1).AcZ);
        }
        return 0;
    }

    @SuppressLint({"NewApi"})
    public final void aKj() {
        x.i("MicroMsg.SoterAuthMgrImp", "hy: do nothing in system release");
    }

    @SuppressLint({"NewApi"})
    public final void aKk() {
        x.i("MicroMsg.SoterAuthMgrImp", "hy: do nothing in system release");
    }

    public final void a(lf lfVar, int i) {
        x.i("MicroMsg.SoterAuthMgrImp", "hy: soter onOpenFingerprintAuthSuccess");
        lfVar.fCx.fCB = aKA();
        lfVar.fCx.errCode = !bh.ov(lfVar.fCx.fCB) ? 0 : 1;
        lfVar.fCx.fCC = 2;
        lfVar.fCx.fwZ = "";
        lfVar.fCx.fxa = "";
        if (lfVar.fCw.fCA != null) {
            lfVar.fCw.fCA.run();
        }
    }

    private static String aKA() {
        i iVar = s.sPp.sPr;
        if (iVar != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("json", iVar.AcA);
                jSONObject.put("signature", iVar.signature);
                return jSONObject.toString();
            } catch (Throwable e) {
                x.e("MicroMsg.SoterAuthMgrImp", "hy: error when convert to json: %s", new Object[]{e.toString()});
                x.printErrStackTrace("MicroMsg.SoterAuthMgrImp", e, "", new Object[0]);
                return "";
            }
        }
        x.e("MicroMsg.SoterAuthMgrImp", "hy: signature result is null");
        return "";
    }

    public final void aKl() {
        if (com.tencent.d.a.a.abt(e.aKq())) {
            com.tencent.d.a.a.bs(e.aKq(), false);
        }
    }

    public final j aKc() {
        this.mzA = new l();
        return this.mzA;
    }

    public final Map<String, String> aKm() {
        Map<String, String> hashMap = new HashMap();
        com.tencent.mm.plugin.soter.c.c bCP = com.tencent.mm.plugin.soter.c.b.bCP();
        String str = bCP.rSm;
        String str2 = bCP.rSn;
        hashMap.put("cpu_id", str);
        hashMap.put("uid", str2);
        return hashMap;
    }

    public final com.tencent.mm.pluginsdk.wallet.k aKn() {
        return new m();
    }

    public final Map<String, String> aKo() {
        return aKm();
    }

    public final boolean aKp() {
        boolean cFL = com.tencent.d.a.a.cFL();
        boolean abt = com.tencent.d.a.a.abt(e.aKq());
        boolean abu = com.tencent.d.a.a.abu(e.aKq());
        x.v("MicroMsg.SoterAuthMgrImp", "hasAsk: %b, hasAuthKey: %b, isAuthKeyValid: %b", new Object[]{Boolean.valueOf(cFL), Boolean.valueOf(abt), Boolean.valueOf(abu)});
        if (!(com.tencent.d.a.a.cFL() && com.tencent.d.a.a.abt(e.aKq()) && com.tencent.d.a.a.abu(e.aKq()))) {
            x.i("MicroMsg.SoterAuthMgrImp", "hy: no ask or auth key");
            s.sPp.mzJ = true;
        }
        if (s.sPp.mzJ) {
            return false;
        }
        return true;
    }

    public final boolean a(boolean z, boolean z2, Bundle bundle) {
        x.i("MicroMsg.SoterAuthMgrImp", "hy: post pay. is fingerprint pay: %b, is pay ok: %b", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)});
        if (!z) {
            String string = bundle.getString("pwd");
            if (bh.ov(string)) {
                x.e("MicroMsg.SoterAuthMgrImp", "hy: no pwd. can not change auth key");
            } else if (s.sPp.mzJ) {
                x.i("MicroMsg.SoterAuthMgrImp", "hy: need change auth key. start gen auth key");
                com.tencent.d.b.a.a(new 3(this), true, 1, new com.tencent.mm.plugin.fingerprint.c.c(string), new com.tencent.mm.plugin.soter.b.e());
            }
        }
        return false;
    }

    public final boolean aJY() {
        return com.tencent.d.a.a.ie(ac.getContext());
    }

    public final void aKa() {
        if (this.mzB != null && VERSION.SDK_INT >= 16) {
            x.i("MicroMsg.SoterAuthMgrImp", "alvinluo cancel fingeprint canceller");
            this.mzB.nV(true);
            if (com.tencent.mm.plugin.soter.c.a.bCO()) {
                com.tencent.mm.plugin.soter.c.a.c(1, -1000223, -1, "user cancelled");
            }
        }
    }

    public final int type() {
        return 2;
    }
}
