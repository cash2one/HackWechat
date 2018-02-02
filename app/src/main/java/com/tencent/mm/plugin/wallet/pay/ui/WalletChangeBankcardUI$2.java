package com.tencent.mm.plugin.wallet.pay.ui;

import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.Comparator;

class WalletChangeBankcardUI$2 implements Comparator<Bankcard> {
    final /* synthetic */ WalletChangeBankcardUI sEU;

    WalletChangeBankcardUI$2(WalletChangeBankcardUI walletChangeBankcardUI) {
        this.sEU = walletChangeBankcardUI;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        Bankcard bankcard = (Bankcard) obj;
        Bankcard bankcard2 = (Bankcard) obj2;
        if (bankcard.bKP()) {
            return -1;
        }
        if (bankcard.bKQ()) {
            return bankcard2.bKP() ? 1 : -1;
        } else {
            if (bh.Vx(bankcard.field_forbidWord) >= bh.Vx(bankcard2.field_forbidWord)) {
                return bh.Vx(bankcard.field_forbidWord) > bh.Vx(bankcard2.field_forbidWord) ? 1 : 0;
            } else {
                return -1;
            }
        }
    }
}
