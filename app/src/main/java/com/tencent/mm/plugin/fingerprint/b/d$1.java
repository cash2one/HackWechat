package com.tencent.mm.plugin.fingerprint.b;

import android.text.TextUtils;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.plugin.fingerprint.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

class d$1 implements Runnable {
    final /* synthetic */ af kCy;
    final /* synthetic */ d mze;

    d$1(d dVar, af afVar) {
        this.mze = dVar;
        this.kCy = afVar;
    }

    public final void run() {
        if (!e.aKv()) {
            try {
                d.cD(ac.getContext());
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FingerPrintMgrImpl", e, "", new Object[0]);
                x.e("MicroMsg.FingerPrintMgrImpl", "init wechat ta secure world is occur exception e=" + e.getMessage());
                e.fk(false);
            }
        }
        if (!e.aKw()) {
            try {
                ClassLoader classLoader = a.class.getClassLoader();
                if (TextUtils.isEmpty(k.eM("teec"))) {
                    x.e("MicroMsg.FingerPrintMgrImpl", "can not LoadLibrary fingerprintauth.so, because can not find the libteec");
                    e.fl(false);
                } else {
                    x.i("MicroMsg.FingerPrintMgrImpl", "LoadLibrary fingerprintauth.so, find the libteec so");
                    k.b("fingerprintauth", classLoader);
                    e.fl(true);
                }
            } catch (UnsatisfiedLinkError e2) {
                x.e("MicroMsg.FingerPrintMgrImpl", "can not LoadLibrary fingerprintauth.so e:=" + e2.getMessage());
                e.fl(false);
            } catch (Throwable e3) {
                x.printErrStackTrace("MicroMsg.FingerPrintMgrImpl", e3, "", new Object[0]);
                x.e("MicroMsg.FingerPrintMgrImpl", "init rsa key is occur exception e=" + e3.getMessage());
                e.fl(false);
            }
        }
        this.kCy.post(new 1(this));
    }
}
