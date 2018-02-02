package com.tencent.mm.plugin.walletlock.b;

import android.os.SystemClock;
import com.tencent.mm.g.a.sv;
import com.tencent.mm.plugin.walletlock.gesture.a.a;
import com.tencent.mm.plugin.walletlock.gesture.a.b;
import com.tencent.mm.plugin.walletlock.gesture.a.d;
import com.tencent.mm.plugin.walletlock.gesture.a.e;
import com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

class f$2 extends c<sv> {
    final /* synthetic */ f thn;

    f$2(f fVar) {
        this.thn = fVar;
        this.xen = sv.class.getName().hashCode();
    }

    private static boolean a(sv svVar) {
        x.v("MicroMsg.WalletLockInitTask", "alvinluo gestureprotectListener request: %d, verfiyMaskOnCreate: %b, verfiyMaskOnResume: %b", Integer.valueOf(svVar.fLi.fLk), Boolean.valueOf(i.ths.bOn()), Boolean.valueOf(i.ths.bOo()));
        long bNF;
        long elapsedRealtime;
        switch (svVar.fLi.fLk) {
            case 0:
                if (!(svVar.fLi.activity instanceof GestureGuardLogicUI)) {
                    if (!i.ths.bOn()) {
                        bNF = d.bNF();
                        elapsedRealtime = (SystemClock.elapsedRealtime() - bNF) / 1000;
                        if (bNF != -1 && elapsedRealtime < ((long) a.tfP) && (!b.bNO() || !b.bNN())) {
                            x.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
                            svVar.fLj.data = Integer.valueOf(16);
                            i.ths.b(new WeakReference(svVar.fLi.activity));
                            break;
                        }
                        x.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONCREATE indicates needs verify.");
                        svVar.fLj.data = Integer.valueOf(17);
                        break;
                    }
                    x.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
                    svVar.fLj.data = Integer.valueOf(16);
                    i.ths.b(new WeakReference(svVar.fLi.activity));
                    i.ths.kb(false);
                    break;
                }
                x.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
                svVar.fLj.data = Integer.valueOf(16);
                break;
                break;
            case 1:
                if (!(svVar.fLi.activity instanceof GestureGuardLogicUI)) {
                    if (!i.ths.bOn()) {
                        if (!i.ths.bOo()) {
                            bNF = d.bNF();
                            elapsedRealtime = (SystemClock.elapsedRealtime() - bNF) / 1000;
                            if ((bNF == -1 || elapsedRealtime >= ((long) a.tfP) || b.bNO()) && b.bNN()) {
                                x.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates needs verify.");
                                svVar.fLj.data = Integer.valueOf(17);
                            } else {
                                x.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
                                svVar.fLj.data = Integer.valueOf(16);
                            }
                            i.ths.b(new WeakReference(svVar.fLi.activity));
                            break;
                        }
                        x.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates reenter.");
                        i.ths.kb(false);
                        i.ths.kc(false);
                        svVar.fLj.data = Integer.valueOf(18);
                        break;
                    }
                    x.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
                    i.ths.kb(false);
                    i.ths.kc(false);
                    svVar.fLj.data = Integer.valueOf(16);
                    break;
                }
                x.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
                svVar.fLj.data = Integer.valueOf(16);
                break;
                break;
            case 2:
                svVar.fLj.data = Boolean.valueOf(e.bNN());
                break;
            case 3:
                svVar.fLj.data = Boolean.valueOf(b.bNO());
                break;
            case 4:
                i.ths.bOp();
                break;
        }
        svVar.fLi.activity = null;
        return false;
    }
}
