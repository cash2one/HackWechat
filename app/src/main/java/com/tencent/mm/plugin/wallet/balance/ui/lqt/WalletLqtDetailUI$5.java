package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import com.tencent.mm.protocal.c.azo;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;

class WalletLqtDetailUI$5 implements a<Void, azo> {
    final /* synthetic */ WalletLqtDetailUI sAM;

    WalletLqtDetailUI$5(WalletLqtDetailUI walletLqtDetailUI) {
        this.sAM = walletLqtDetailUI;
    }

    public final /* synthetic */ Object call(Object obj) {
        azo com_tencent_mm_protocal_c_azo = (azo) obj;
        if (com_tencent_mm_protocal_c_azo != null) {
            x.i("MicroMsg.WalletLqtDetailUI", "fetch detail success, account_type: %s, is_hide_close_account_btn: %s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_azo.vXn), Boolean.valueOf(com_tencent_mm_protocal_c_azo.wGQ)});
            WalletLqtDetailUI.a(this.sAM, com_tencent_mm_protocal_c_azo);
            WalletLqtDetailUI.b(this.sAM);
        } else {
            x.i("MicroMsg.WalletLqtDetailUI", "fetch detail failed");
        }
        if (WalletLqtDetailUI.a(this.sAM) != null) {
            WalletLqtDetailUI.a(this.sAM).dismiss();
        }
        return zBS;
    }
}
