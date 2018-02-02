package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.g.a.bo;
import com.tencent.mm.g.a.lf;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;

public abstract class a implements l {
    public final void cB(Context context) {
        x.i("MicroMsg.BaseFingerprintImp", "showFingerPrintEntrance");
        if (e.aKu() && !aJX()) {
            x.e("MicroMsg.BaseFingerprintImp", "the fingerprint is open ready, but system has none Finger print ids!");
            x.i("MicroMsg.BaseFingerprintImp", "closeFP");
            b boVar = new bo();
            boVar.fqI = new 1(this, boVar);
            com.tencent.mm.sdk.b.a.xef.a(boVar, context.getMainLooper());
        } else if (q.gFY.gGh != 1) {
            x.e("MicroMsg.BaseFingerprintImp", "hy: device info not support");
        } else if (e.aKu() || !(e.aKx() || e.aKy())) {
            x.e("MicroMsg.BaseFingerprintImp", "mgr == null or not support FP or has show guide or show HWManager!");
        }
    }

    public final boolean aJW() {
        return e.aKu();
    }

    public final boolean aJX() {
        com.tencent.mm.plugin.fingerprint.a.aJS();
        com.tencent.mm.plugin.fingerprint.a.aJT();
        return c.aKb();
    }

    public boolean aJY() {
        return false;
    }

    public final void a(lf lfVar, int i, String str) {
        x.i("MicroMsg.BaseFingerprintImp", "hy: onOpenFingerprintAuthFailed");
        if (lfVar != null && lfVar.fCw.fCA != null) {
            lfVar.fCx = new lf.b();
            lfVar.fCx.errCode = i;
            lfVar.fCx.fwZ = "";
            lfVar.fCx.fxa = "";
            lfVar.fCx.fnL = str;
            lfVar.fCx.fCC = type();
            lfVar.fCw.fCA.run();
        }
    }

    public final void fi(boolean z) {
        x.i("MicroMsg.BaseFingerprintImp", "hy: set isOpenFp: %b", new Object[]{Boolean.valueOf(z)});
        e.fj(z);
    }
}
