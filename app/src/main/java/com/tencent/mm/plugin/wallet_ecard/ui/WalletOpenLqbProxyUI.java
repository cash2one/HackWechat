package com.tencent.mm.plugin.wallet_ecard.ui;

import android.os.Bundle;
import com.tencent.mm.ae.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(3)
public class WalletOpenLqbProxyUI extends WalletBaseUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        uD(4);
        c cCc = cCc();
        if (cCc != null) {
            int i = this.vf.getInt(com.tencent.mm.plugin.wallet_ecard.a.a.sYX, 0);
            String string = this.vf.getString(com.tencent.mm.plugin.wallet_ecard.a.a.sZd);
            x.i("MicroMsg.WalletOpenLqbProxyUI", "WalletOpenLqbProxyUI onCreate, openScene: %s, extraData: %s", new Object[]{Integer.valueOf(i), string});
            if (i == 3) {
                cCd().k(new Object[]{Integer.valueOf(i), string});
                return;
            }
            cCc.b(this, this.vf);
            finish();
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return -1;
    }
}
