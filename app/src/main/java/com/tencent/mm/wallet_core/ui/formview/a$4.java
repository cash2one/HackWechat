package com.tencent.mm.wallet_core.ui.formview;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.wallet_core.ui.formview.a.c;

class a$4 extends c {
    a$4() {
        super((byte) 0);
    }

    public final boolean bmH() {
        return true;
    }

    public final String e(WalletFormView walletFormView, String str) {
        return bh.az((String) walletFormView.getTag(), "").replace("/", "");
    }
}
