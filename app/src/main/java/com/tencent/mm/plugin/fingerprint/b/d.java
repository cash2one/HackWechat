package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.c.a.a;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.g.a.lf;
import com.tencent.mm.g.a.lf.b;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.plugin.wallet_core.model.ae;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.pluginsdk.wallet.c;
import com.tencent.mm.pluginsdk.wallet.j;
import com.tencent.mm.pluginsdk.wallet.k;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.n;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.Map;

public final class d extends a {
    private a mzb = null;
    private a mzc = new a(this, (byte) 0);
    private c mzd = null;

    public final boolean aKd() {
        boolean z;
        boolean z2;
        int[] rO = a.rO();
        if (rO != null) {
            for (int i : rO) {
                if (1 == i) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (q.gFY.gGh == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        x.i("MicroMsg.FingerPrintMgrImpl", "hy: is hardware support: %b, is config support : %b", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)});
        if (z && z2) {
            return true;
        }
        return false;
    }

    public final boolean aKe() {
        this.mzb = a.rM();
        int[] rN = rN();
        if (rN == null || rN.length <= 0) {
            x.e("MicroMsg.FingerPrintMgrImpl", "ids is null");
        }
        aKj();
        return rN != null && rN.length > 0;
    }

    private int[] rN() {
        if (this.mzb != null) {
            return this.mzb.rN();
        }
        x.i("MicroMsg.FingerPrintMgrImpl", "getIds auth == null");
        return null;
    }

    public final void cC(Context context) {
        if (context != null) {
            Intent intent = new Intent();
            intent.setAction("com.android.settings.fingerprint.FingerprintSettings");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            context.startActivity(intent);
        }
    }

    public final void aKf() {
        x.i("MicroMsg.FingerPrintMgrImpl", "initFP");
        if (aKd()) {
            ae bLQ = o.bLq().bLQ();
            if (bLQ == null || bLQ.bLF()) {
                af afVar = new af(Looper.myLooper());
                x.i("MicroMsg.FingerPrintMgrImpl", "device is support fingerprintAuth");
                e.post(new 1(this, afVar), getClass().getName());
                return;
            }
            x.e("MicroMsg.FingerPrintMgrImpl", "isSupportTouchPay is false");
            return;
        }
        x.e("MicroMsg.FingerPrintMgrImpl", "device is not support fingerprintAuth");
    }

    public static void aKg() {
        x.i("MicroMsg.FingerPrintMgrImpl", "initRsaKey");
        if (!e.aKi()) {
            x.e("MicroMsg.FingerPrintMgrImpl", "device is not support");
        } else if (o.bLq().bLJ() || o.bLq().bLN()) {
            x.e("MicroMsg.FingerPrintMgrImpl", "user had not reg wxpay or is isSimpleReg");
        } else {
            try {
                String userId = e.getUserId();
                x.i("MicroMsg.FingerPrintMgrImpl", "initRsaKey userId:" + userId);
                CharSequence rsaKey = FingerPrintAuth.getRsaKey(e.cE(ac.getContext()), userId, q.yF());
                if (TextUtils.isEmpty(rsaKey)) {
                    x.e("MicroMsg.FingerPrintMgrImpl", "FingerPrintAuth.getRsaKey() is null");
                    rsaKey = FingerPrintAuth.genRsaKey(e.cE(ac.getContext()), e.getUserId(), q.yF());
                }
                if (TextUtils.isEmpty(rsaKey)) {
                    x.e("MicroMsg.FingerPrintMgrImpl", "FingerPrintAuth.genRsaKey() return null");
                } else {
                    x.e("MicroMsg.FingerPrintMgrImpl", "initRsaKey success!");
                }
            } catch (UnsatisfiedLinkError e) {
                x.e("MicroMsg.FingerPrintMgrImpl", "can not LoadLibrary fingerprintauth.so e:=" + e.getMessage());
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.FingerPrintMgrImpl", e2, "", new Object[0]);
                x.e("MicroMsg.FingerPrintMgrImpl", "can not LoadLibrary fingerprintauth.so e:=" + e2.getMessage());
            }
        }
    }

    public final boolean aKh() {
        return true;
    }

    public static void cD(Context context) {
        x.i("MicroMsg.FingerPrintMgrImpl", "initTASecureWorld");
        if (!c.aJZ()) {
            x.e("MicroMsg.FingerPrintMgrImpl", "device is not support");
        } else if (e.cF(context) != 0) {
            e.fk(false);
            x.e("MicroMsg.FingerPrintMgrImpl", "copyTAFromAssets failed!");
        } else {
            e.fk(true);
            x.e("MicroMsg.FingerPrintMgrImpl", "copyTAFromAssets success!");
        }
    }

    public final boolean aKi() {
        return e.aKi();
    }

    public final int a(c cVar, int i, boolean z) {
        if (this.mzb == null) {
            this.mzb = a.rM();
        }
        if (this.mzb == null) {
            return -1;
        }
        this.mzd = cVar;
        this.mzb = a.rM();
        return this.mzb.a(this.mzc, 0, rN());
    }

    public final void aKj() {
        this.mzd = null;
        if (this.mzb != null) {
            try {
                a aVar = this.mzb;
                if (aVar.bga != null) {
                    aVar.bga.removeMessages(8);
                }
                try {
                    aVar.bfY.b(aVar.bfZ);
                    aVar.bfY.asBinder().unlinkToDeath(aVar.bge, 0);
                } catch (RemoteException e) {
                }
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.FingerPrintMgrImpl", e2, "", new Object[0]);
                x.i("MicroMsg.FingerPrintMgrImpl", "auth systemRelease occur exception e:" + e2.getMessage());
            }
            this.mzb = null;
            return;
        }
        x.i("MicroMsg.FingerPrintMgrImpl", "systemRelease auth == null");
    }

    public final void aKk() {
        if (this.mzb != null) {
            try {
                this.mzb.abort();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FingerPrintMgrImpl", e, "", new Object[0]);
                x.i("MicroMsg.FingerPrintMgrImpl", "auth systemAbort occur exception e:" + e.getMessage());
            }
        }
    }

    public final void a(lf lfVar, int i) {
        Object genPayFPEncrypt = FingerPrintAuth.genPayFPEncrypt(e.cE(ac.getContext()), e.getUserId(), q.yF(), String.valueOf(i), n.cBr(), lfVar != null ? lfVar.fCw.fwY : "", Build.MODEL);
        Object genOpenFPSign = FingerPrintAuth.genOpenFPSign(e.cE(ac.getContext()), e.getUserId(), q.yF(), genPayFPEncrypt);
        if (TextUtils.isEmpty(genPayFPEncrypt)) {
            x.i("MicroMsg.FingerPrintMgrImpl", "fail gen encrypted_pay_info!");
        } else {
            x.i("MicroMsg.FingerPrintMgrImpl", "success gen encrypted_pay_info!");
        }
        if (TextUtils.isEmpty(genOpenFPSign)) {
            x.i("MicroMsg.FingerPrintMgrImpl", "fail gen encrypted_pay_sign!");
        } else {
            x.i("MicroMsg.FingerPrintMgrImpl", "success gen encrypted_pay_sign!");
        }
        x.i("MicroMsg.FingerPrintMgrImpl", "callback FingerPrintAuthEvent onSuccess()");
        if (lfVar != null && lfVar.fCw.fCA != null) {
            b bVar = new b();
            bVar.fCC = 1;
            bVar.errCode = 0;
            bVar.fwZ = genPayFPEncrypt;
            bVar.fxa = genOpenFPSign;
            bVar.fwX = i;
            lfVar.fCx = bVar;
            lfVar.fCw.fCA.run();
        }
    }

    public final void aKl() {
        x.e("MicroMsg.FingerPrintMgrImpl", "hy: param incorrect");
    }

    public final j aKc() {
        return new h();
    }

    public final Map<String, String> aKm() {
        return null;
    }

    public final k aKn() {
        return null;
    }

    public final Map<String, String> aKo() {
        return null;
    }

    public final boolean aKp() {
        return true;
    }

    public final boolean a(boolean z, boolean z2, Bundle bundle) {
        return false;
    }

    public final void aKa() {
        aKk();
        aKj();
    }

    public final int type() {
        return 1;
    }
}
