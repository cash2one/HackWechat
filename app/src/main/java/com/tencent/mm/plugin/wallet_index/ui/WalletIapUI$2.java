package com.tencent.mm.plugin.wallet_index.ui;

import android.content.Intent;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_index.b.a.c;
import com.tencent.mm.plugin.wallet_index.c.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.p;

class WalletIapUI$2 implements d {
    final /* synthetic */ WalletIapUI tbh;

    WalletIapUI$2(WalletIapUI walletIapUI) {
        this.tbh = walletIapUI;
    }

    public final void a(a aVar, c cVar) {
        x.i("MicroMsg.WalletIapUI", "Pay Purchase finished: " + aVar + ", purchase: " + cVar);
        if (WalletIapUI.a(this.tbh) instanceof a) {
            if (cVar != null) {
                p.c(cVar.tad, cVar.lyH, cVar.tak, aVar.nAh, aVar.mMessage);
            } else {
                a aVar2 = (a) WalletIapUI.a(this.tbh);
                p.c(aVar2.taG, aVar2.lyH, aVar2.tak, aVar.nAh, aVar.mMessage);
            }
        }
        Intent intent;
        if (aVar.isFailure()) {
            x.i("MicroMsg.WalletIapUI", "back to preview UI, reason: purchase finish , errCode: " + aVar.nAh + " , errMsg: " + aVar.mMessage);
            intent = new Intent();
            intent.putExtra("key_err_code", aVar.nAh);
            intent.putExtra("key_err_msg", aVar.mMessage);
            intent.putExtra("key_launch_ts", a.taC);
            intent.putExtra("key_gw_error_code", aVar.tal);
            this.tbh.setResult(-1, intent);
            this.tbh.finish();
        } else if (aVar.bNl()) {
            x.i("MicroMsg.WalletIapUI", "start to restore the purchase!");
            WalletIapUI.a(this.tbh).c(this.tbh, false);
        } else if (cVar != null) {
            x.i("MicroMsg.WalletIapUI", "verify purchase! productId:" + cVar.lyH + ",billNo:" + cVar.tah);
            g.Dk();
            g.Di().gPJ.a(WalletIapUI.b(this.tbh).a(cVar, false), 0);
        } else {
            intent = new Intent();
            a.aL(6, "");
            intent.putExtra("key_err_code", aVar.nAh);
            intent.putExtra("key_err_msg", aVar.mMessage);
            intent.putExtra("key_launch_ts", a.taC);
            intent.putExtra("key_gw_error_code", aVar.tal);
            this.tbh.setResult(-1, intent);
            this.tbh.finish();
        }
    }
}
