package com.tencent.mm.plugin.walletlock.b;

import android.content.Intent;
import com.tencent.mm.g.a.qu;
import com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI;
import com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends com.tencent.mm.sdk.b.c<qu> {
    public c() {
        this.xen = qu.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        qu quVar = (qu) bVar;
        if (quVar != null) {
            Intent intent = quVar.fIC.fIE;
            int intExtra = intent.getIntExtra("key_wallet_lock_type", -1);
            if (quVar.fIC.fAF != null) {
                x.i("MicroMsg.StartWalletLockUIListener", "alvinluo startWalletLockUI type: %d", new Object[]{Integer.valueOf(intExtra)});
                if (intExtra == 2) {
                    intent.setClass(quVar.fIC.fAF, FingerprintWalletLockUI.class);
                } else if (intExtra == 1) {
                    intent.setClass(quVar.fIC.fAF, GestureGuardLogicUI.class);
                }
                quVar.fIC.fAF.startActivityForResult(intent, quVar.fIC.fyV);
                quVar.fID.fsH = true;
            } else {
                quVar.fID.fsH = false;
            }
            x.i("MicroMsg.StartWalletLockUIListener", "alvinluo isSuccess: %b", new Object[]{Boolean.valueOf(quVar.fID.fsH)});
        }
        return false;
    }
}
