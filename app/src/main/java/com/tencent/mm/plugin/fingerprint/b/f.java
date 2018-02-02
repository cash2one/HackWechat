package com.tencent.mm.plugin.fingerprint.b;

import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.g.a.gv;
import com.tencent.mm.g.a.gv.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.n;

public final class f extends c<gv> implements e {
    private String fuH;
    private boolean mza;
    private gv mzh;
    private int mzi;
    af mzj;

    public f() {
        this.mzi = 0;
        this.fuH = "";
        this.mza = false;
        this.mzj = new af(Looper.getMainLooper());
        this.xen = gv.class.getName().hashCode();
    }

    private boolean a(gv gvVar) {
        if (g.Dh().Cy()) {
            x.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "GenFingerPrintRsaKeyEventListener callback");
            this.mza = false;
            if (!(gvVar instanceof gv)) {
                return false;
            }
            if (e.aKi()) {
                this.mzh = gvVar;
                g.Dk();
                g.Di().gPJ.a(385, this);
                boolean z = this.mzh.fwU.fwW;
                this.mzi = this.mzh.fwU.fwX;
                this.fuH = this.mzh.fwU.fwY;
                if (z) {
                    x.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth should gen rsa key!");
                    z = true;
                } else {
                    Object rsaKey = FingerPrintAuth.getRsaKey(e.cE(ac.getContext()), e.getUserId(), q.yF());
                    if (TextUtils.isEmpty(rsaKey)) {
                        x.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.getRsaKey() return null");
                        z = true;
                    } else {
                        x.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.getRsaKey() success!");
                        k eVar = new com.tencent.mm.plugin.fingerprint.c.e(rsaKey);
                        g.Dk();
                        g.Di().gPJ.a(eVar, 0);
                        z = false;
                    }
                }
                if (z) {
                    x.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth begin asyc gen rsa key!");
                    new o(new a(this, (byte) 0)).aKE();
                }
                return true;
            }
            x.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "device is not support FingerPrintAuth");
            b bVar = new b();
            bVar.fsH = false;
            this.mzh.fwV = bVar;
            this.mza = true;
            atN();
            return true;
        }
        x.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "GenFingerPrintRsaKeyEventListener account is not ready");
        return false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof com.tencent.mm.plugin.fingerprint.c.e) {
            b bVar = new b();
            bVar.fsH = false;
            x.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "NetSceneTenpayGetOpenTouchCert doscene return errcode " + i2 + " errmsg" + str);
            if (i == 0 && i2 == 0) {
                x.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "NetSceneTenpayGetOpenTouchCert doscene is success");
                com.tencent.mm.plugin.fingerprint.c.e eVar = (com.tencent.mm.plugin.fingerprint.c.e) kVar;
                String str2 = eVar.mzq;
                String str3 = eVar.fxa;
                String userId = e.getUserId();
                String yF = q.yF();
                String cBr = n.cBr();
                if (TextUtils.isEmpty(FingerPrintAuth.genOpenFPEncrypt(e.cE(ac.getContext()), userId, yF, String.valueOf(this.mzi), cBr, "", str2, str3, Build.MODEL))) {
                    x.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.genOpenFPEncrypt failed!");
                } else {
                    x.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.genOpenFPEncrypt success!");
                    bVar.fsH = true;
                }
                String genPayFPEncrypt = FingerPrintAuth.genPayFPEncrypt(e.cE(ac.getContext()), userId, yF, String.valueOf(this.mzi), cBr, this.fuH, Build.MODEL);
                userId = FingerPrintAuth.genOpenFPSign(e.cE(ac.getContext()), e.getUserId(), q.yF(), genPayFPEncrypt);
                bVar.fwZ = genPayFPEncrypt;
                bVar.fxa = userId;
            } else {
                x.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "NetSceneTenpayGetOpenTouchCert doscene is fail");
            }
            g.Dk();
            g.Di().gPJ.b(385, this);
            this.mzh.fwV = bVar;
            this.mza = true;
            atN();
        }
    }

    private void atN() {
        x.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "doCallback()");
        if (this.mzh.fqI != null) {
            this.mzh.fqI.run();
        }
        if (this.mza) {
            this.mzh = null;
        }
    }
}
