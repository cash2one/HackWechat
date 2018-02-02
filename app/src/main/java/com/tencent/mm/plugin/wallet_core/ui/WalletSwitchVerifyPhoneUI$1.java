package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import com.tencent.mm.plugin.wallet_core.ui.view.SwitchPhoneItemGroupView.a;
import com.tencent.mm.protocal.c.ew;
import com.tencent.mm.sdk.platformtools.x;

class WalletSwitchVerifyPhoneUI$1 implements a {
    final /* synthetic */ WalletSwitchVerifyPhoneUI sWv;

    WalletSwitchVerifyPhoneUI$1(WalletSwitchVerifyPhoneUI walletSwitchVerifyPhoneUI) {
        this.sWv = walletSwitchVerifyPhoneUI;
    }

    public final void cT(View view) {
        if (view.getTag() != null) {
            int intValue = ((Integer) view.getTag()).intValue();
            x.d("MicroMsg.WalletSwitchVerifyPhoneUI", "index: %d", new Object[]{Integer.valueOf(intValue)});
            if (intValue == -1) {
                x.i("MicroMsg.WalletSwitchVerifyPhoneUI", "do bind new card");
                WalletSwitchVerifyPhoneUI.a(this.sWv);
            } else if (intValue == -2) {
                x.i("MicroMsg.WalletSwitchVerifyPhoneUI", "do verify idcard tail");
                this.sWv.vf.putBoolean("key_forward_to_id_verify", true);
                com.tencent.mm.wallet_core.a.j(this.sWv, this.sWv.vf);
            } else {
                ew ewVar = (ew) WalletSwitchVerifyPhoneUI.b(this.sWv).get(intValue);
                this.sWv.vf.putBoolean("key_balance_change_phone_need_confirm_phone", false);
                x.i("MicroMsg.WalletSwitchVerifyPhoneUI", "select wx phone: %s", new Object[]{Boolean.valueOf(ewVar.vKD.equals("wx"))});
                this.sWv.cCd().k(ewVar);
            }
        }
    }
}
