package com.tencent.mm.plugin.wallet_core.ui.ibg;

import android.os.Bundle;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.i;

public class WalletIbgOrderInfoOldUI extends WalletOrderInfoOldUI {
    public void onCreate(Bundle bundle) {
        this.sEs = WalletIbgOrderInfoUI.sEs;
        super.onCreate(bundle);
    }

    protected final Orders bMF() {
        return this.sEs;
    }

    public final void done() {
        x.i("MicroMsg.WalletIbgOrderInfoOldUI", "hy: result is not set manly. set to OK");
        for (String str : this.sTU) {
            if (!bh.ov(str)) {
                x.d("MicroMsg.WalletIbgOrderInfoOldUI", "hy: doing netscene subscribe...appName: %s", new Object[]{str});
                g.Dk();
                g.Di().gPJ.a(new i(str), 0);
            }
        }
        setResult(-1);
        finish();
    }
}
