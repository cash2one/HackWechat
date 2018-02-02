package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.Toast;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.h.c;
import com.tencent.mm.sdk.platformtools.x;

class WalletOrderInfoOldUI$11 implements OnLongClickListener {
    final /* synthetic */ WalletOrderInfoOldUI sUK;

    WalletOrderInfoOldUI$11(WalletOrderInfoOldUI walletOrderInfoOldUI) {
        this.sUK = walletOrderInfoOldUI;
    }

    public final boolean onLongClick(View view) {
        if (view.getId() == f.uzl || view.getId() == f.uzJ) {
            try {
                String str = (String) view.getTag();
                Toast.makeText(this.sUK, i.uTl, 0).show();
                c.a(this.sUK.mController.xIM, str, str);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WalletOrderInfoOldUI", e, "", new Object[0]);
            }
        }
        return true;
    }
}
