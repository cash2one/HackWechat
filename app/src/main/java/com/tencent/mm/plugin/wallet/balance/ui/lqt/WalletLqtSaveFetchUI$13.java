package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.vending.c.a;
import java.util.List;

class WalletLqtSaveFetchUI$13 implements a<Void, Void> {
    final /* synthetic */ List sBF;
    final /* synthetic */ WalletLqtSaveFetchUI sBv;

    WalletLqtSaveFetchUI$13(WalletLqtSaveFetchUI walletLqtSaveFetchUI, List list) {
        this.sBv = walletLqtSaveFetchUI;
        this.sBF = list;
    }

    public final /* synthetic */ Object call(Object obj) {
        for (Bankcard bankcard : WalletLqtSaveFetchUI.h(this.sBv)) {
            Object obj2;
            for (Bankcard bankcard2 : this.sBF) {
                if (bankcard.field_bindSerial.equals(bankcard2.field_bindSerial)) {
                    obj2 = 1;
                    continue;
                    break;
                }
            }
            obj2 = null;
            continue;
            if (obj2 == null) {
                WalletLqtSaveFetchUI.a(this.sBv, bankcard.field_bindSerial);
                break;
            }
        }
        WalletLqtSaveFetchUI.f(this.sBv);
        return zBS;
    }
}
