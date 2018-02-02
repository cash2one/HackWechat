package com.tencent.mm.plugin.fingerprint.ui;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.e;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class FingerPrintEntranceUI extends WalletBaseUI {
    public void onCreate(Bundle bundle) {
        boolean z = true;
        super.onCreate(bundle);
        x.i("MicroMsg.FingerPrintEntranceUI", "onCreate");
        if (e.aKy()) {
            x.i("MicroMsg.FingerPrintEntranceUI", "will call showSetFingerPrintGuide()");
            x.i("MicroMsg.FingerPrintEntranceUI", "hy: has standard action starting to fingerprint setting");
            h.a((Context) this, getResources().getString(i.uOq), "", getResources().getString(((l) g.h(l.class)).aKh() ? i.uIb : i.dFU), getString(i.dEn), true, new 1(this), new 2(this));
            e.aKt();
        } else if (e.aKs()) {
            z = false;
        } else {
            x.i("MicroMsg.FingerPrintEntranceUI", "will showOpenFingerPrintPayGuide()");
            h.a((Context) this, getResources().getString(i.uOp), "", getResources().getString(i.uIa), getString(i.dEn), true, new 3(this), new 4(this));
            e.aKr();
        }
        if (!z) {
            x.e("MicroMsg.FingerPrintEntranceUI", "finish FingerPrintEntranceUI");
            finish();
        }
    }

    public void onResume() {
        super.onResume();
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return -1;
    }
}
