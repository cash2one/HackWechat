package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.mm.ae.k;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.plugin.fingerprint.c.e;
import com.tencent.mm.plugin.fingerprint.c.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.a;
import com.tencent.mm.pluginsdk.wallet.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.n;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public final class h implements j {
    private String fxa = null;
    af mzj = new af(new 1(this));
    a mzn = null;
    private a mzo = null;
    WalletBaseUI mzp = null;
    private String mzq = null;
    private String mzr = null;

    public final void a(Context context, a aVar, String str) {
        this.mzp = (WalletBaseUI) context;
        this.mzn = aVar;
        this.mzr = str;
        Object rsaKey = FingerPrintAuth.getRsaKey(e.cE(ac.getContext()), e.getUserId(), q.yF());
        com.tencent.mm.plugin.soter.c.a.bCL();
        if (TextUtils.isEmpty(rsaKey)) {
            x.e("MicroMsg.HwFingerprintOpenDelegate", "FingerPrintAuth.getRsaKey() is null");
            new o(new a(this, (byte) 0)).aKE();
            return;
        }
        x.i("MicroMsg.HwFingerprintOpenDelegate", "do NetSceneTenpayGetOpenTouchCert");
        this.mzp.b(new e(rsaKey), false);
    }

    public final void clear() {
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        int i3 = 0;
        if (kVar instanceof e) {
            a aVar;
            if (i == 0 && i2 == 0) {
                x.i("MicroMsg.HwFingerprintOpenDelegate", "get FingerPrint cert success");
                e eVar = (e) kVar;
                this.mzq = eVar.mzq;
                this.fxa = eVar.fxa;
                aVar = this.mzn;
                str = "";
            } else {
                x.i("MicroMsg.HwFingerprintOpenDelegate", "get FingerPrint cert error");
                aVar = this.mzn;
                i3 = -1;
                if (bh.ov(str)) {
                    str = this.mzp.getString(i.uJi);
                }
            }
            aVar.ac(i3, str);
            return true;
        } else if (!(kVar instanceof f)) {
            return false;
        } else {
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.soter.c.a.bCM();
                com.tencent.mm.plugin.soter.c.a.c(0, 0, 0, "OK");
                this.mzo.ac(0, "");
            } else {
                this.mzo.ac(-2, "");
            }
            return true;
        }
    }

    public final void a(a aVar, String str, int i) {
        this.mzo = aVar;
        if (TextUtils.isEmpty(this.mzr)) {
            x.e("MicroMsg.HwFingerprintOpenDelegate", "get user pwd error");
            aVar.ac(-1, this.mzp.getString(i.uJi));
            return;
        }
        String userId = e.getUserId();
        String yF = q.yF();
        String cBr = n.cBr();
        String str2 = "";
        CharSequence charSequence = "";
        if (e.aKi()) {
            userId = FingerPrintAuth.genOpenFPEncrypt(e.cE(ac.getContext()), userId, yF, str, cBr, "", this.mzq, this.fxa, Build.MODEL);
            charSequence = FingerPrintAuth.genOpenFPSign(e.cE(ac.getContext()), e.getUserId(), q.yF(), userId);
        } else {
            userId = str2;
        }
        if (TextUtils.isEmpty(this.mzq)) {
            x.e("MicroMsg.HwFingerprintOpenDelegate", "The value of encrypted_device_info which return by FingerPrintAuth.genOpenFPEncrypt is null");
        } else if (TextUtils.isEmpty(charSequence)) {
            x.e("MicroMsg.HwFingerprintOpenDelegate", "The value of encrypto_open_sign which return by FingerPrintAuth.genOpenFPSign is null");
        }
        this.mzp.b(new f(userId, charSequence, this.mzr, i), false);
    }
}
