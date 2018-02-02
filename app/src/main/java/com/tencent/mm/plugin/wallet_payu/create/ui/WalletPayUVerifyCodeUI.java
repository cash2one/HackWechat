package com.tencent.mm.plugin.wallet_payu.create.ui;

import android.os.Bundle;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;

@a(3)
public class WalletPayUVerifyCodeUI extends WalletVerifyCodeUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.sWH.zJL = 60;
    }

    protected final void bMU() {
        super.bMU();
    }

    protected final void bMV() {
        super.bMV();
    }

    public final void bMT() {
        this.sWG = 180000;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if ((kVar instanceof com.tencent.mm.plugin.wallet_payu.a.a) && !((com.tencent.mm.plugin.wallet_payu.a.a) kVar).qjU) {
            x.w("MicroMsg.WalletPayUVerifyCodeUI", "hy: confirm code not verified");
        }
        return false;
    }

    protected final boolean bKa() {
        return true;
    }
}
