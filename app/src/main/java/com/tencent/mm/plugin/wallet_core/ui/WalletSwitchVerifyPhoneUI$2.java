package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.protocal.c.ew;
import java.util.Comparator;

class WalletSwitchVerifyPhoneUI$2 implements Comparator<ew> {
    final /* synthetic */ WalletSwitchVerifyPhoneUI sWv;

    WalletSwitchVerifyPhoneUI$2(WalletSwitchVerifyPhoneUI walletSwitchVerifyPhoneUI) {
        this.sWv = walletSwitchVerifyPhoneUI;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        ew ewVar = (ew) obj;
        ew ewVar2 = (ew) obj2;
        if (ewVar.vKD.equals("wx") && ewVar2.vKD.equals("cft")) {
            return -1;
        }
        return (ewVar.vKD.equals("cft") && ewVar2.vKD.equals("wx")) ? 1 : 0;
    }
}
