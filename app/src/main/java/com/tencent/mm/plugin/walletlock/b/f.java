package com.tencent.mm.plugin.walletlock.b;

import android.os.SystemClock;
import com.tencent.mm.g.a.sv;
import com.tencent.mm.plugin.walletlock.fingerprint.a.a;
import com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI;
import com.tencent.mm.plugin.walletlock.gesture.a.d;
import com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

public final class f {
    public c thj = new c();
    public c thk = new c<sv>(this) {
        final /* synthetic */ f thn;

        {
            this.thn = r2;
            this.xen = sv.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            sv svVar = (sv) bVar;
            x.i("MicroMsg.WalletLockInitTask", "alvinluo wallet lock protect request: %d, verfiyMaskOnCreate: %b, verfiyMaskOnResume: %b", new Object[]{Integer.valueOf(svVar.fLi.fLk), Boolean.valueOf(i.ths.bOn()), Boolean.valueOf(i.ths.bOo())});
            g gVar;
            Object obj;
            long bNF;
            switch (svVar.fLi.fLk) {
                case 0:
                    if (!(svVar.fLi.activity instanceof GestureGuardLogicUI) && !(svVar.fLi.activity instanceof FingerprintWalletLockUI)) {
                        gVar = g.tho;
                        if (svVar == null) {
                            obj = null;
                        } else if (i.ths.bOn()) {
                            x.d("MicroMsg.WalletLockManager", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
                            i.ths.b(new WeakReference(svVar.fLi.activity));
                            i.ths.kb(false);
                            obj = null;
                        } else {
                            x.i("MicroMsg.WalletLockManager", "alvinluo current wallet lock type: %d", new Object[]{Integer.valueOf(gVar.mType)});
                            if (gVar.mType == 2) {
                                bNF = a.bNF();
                            } else if (gVar.mType == 1) {
                                bNF = d.bNF();
                            } else {
                                obj = null;
                            }
                            x.i("MicroMsg.WalletLockManager", "alvinluo lastVerifyOkTime: %d, elapsedRealTime: %d, pastTime: %d, PREVENT_INPUT_PWD_SECONDS: %d", new Object[]{Long.valueOf(bNF), Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf((SystemClock.elapsedRealtime() - bNF) / 1000), Integer.valueOf(com.tencent.mm.plugin.walletlock.gesture.a.a.tfP)});
                            if (bNF == -1 || r2 >= ((long) com.tencent.mm.plugin.walletlock.gesture.a.a.tfP) || g.tho.bNz()) {
                                x.d("MicroMsg.WalletLockManager", "REQUEST_PROTECT_ME_ONCREATE indicates needs verify.");
                                obj = 1;
                            } else {
                                x.d("MicroMsg.WalletLockManager", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
                                i.ths.b(new WeakReference(svVar.fLi.activity));
                                obj = null;
                            }
                        }
                        if (obj == null) {
                            svVar.fLj.data = Integer.valueOf(16);
                            break;
                        }
                        svVar.fLj.data = Integer.valueOf(17);
                        break;
                    }
                    svVar.fLj.data = Integer.valueOf(16);
                    break;
                    break;
                case 1:
                    if (!(svVar.fLi.activity instanceof GestureGuardLogicUI) && !(svVar.fLi.activity instanceof FingerprintWalletLockUI)) {
                        gVar = g.tho;
                        if (svVar == null) {
                            obj = null;
                        } else if (i.ths.bOn()) {
                            x.d("MicroMsg.WalletLockManager", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
                            i.ths.kb(false);
                            i.ths.kc(false);
                            obj = null;
                        } else if (i.ths.bOo()) {
                            x.d("MicroMsg.WalletLockManager", "REQUEST_PROTECT_ME_ONRESUME indicates reenter.");
                            i.ths.kb(false);
                            i.ths.kc(false);
                            obj = null;
                        } else {
                            x.i("MicroMsg.WalletLockManager", "alvinluo current wallet lock type: %d", new Object[]{Integer.valueOf(gVar.mType)});
                            if (gVar.mType == 2) {
                                bNF = a.bNF();
                            } else if (gVar.mType == 1) {
                                bNF = d.bNF();
                            } else {
                                obj = null;
                            }
                            i.ths.b(new WeakReference(svVar.fLi.activity));
                            x.i("MicroMsg.WalletLockManager", "alvinluo lastVerifyOkTime: %d, elapsedRealTime: %d, pastTime: %d, %d", new Object[]{Long.valueOf(bNF), Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf((SystemClock.elapsedRealtime() - bNF) / 1000), Integer.valueOf(com.tencent.mm.plugin.walletlock.gesture.a.a.tfP)});
                            if (bNF == -1 || r2 >= ((long) com.tencent.mm.plugin.walletlock.gesture.a.a.tfP) || g.tho.bNz()) {
                                x.d("MicroMsg.WalletLockManager", "REQUEST_PROTECT_ME_ONRESUME indicates needs verify.");
                                obj = 1;
                            } else {
                                x.d("MicroMsg.WalletLockManager", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
                                obj = null;
                            }
                        }
                        if (obj == null) {
                            svVar.fLj.data = Integer.valueOf(16);
                            break;
                        }
                        svVar.fLj.data = Integer.valueOf(17);
                        break;
                    }
                    svVar.fLj.data = Integer.valueOf(16);
                    break;
                    break;
            }
            svVar.fLi.activity = null;
            x.i("MicroMsg.WalletLockInitTask", "alvinluo protect result: %s", new Object[]{svVar.fLj.data});
            return false;
        }
    };
    private c thl = new 2(this);
    public c thm = new 3(this);
}
