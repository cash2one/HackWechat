package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import java.util.Comparator;

class WalletCardSelectUI$6 implements Comparator<ElementQuery> {
    final /* synthetic */ WalletCardSelectUI sSV;

    WalletCardSelectUI$6(WalletCardSelectUI walletCardSelectUI) {
        this.sSV = walletCardSelectUI;
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        return ((ElementQuery) obj).sIJ - ((ElementQuery) obj2).sIJ;
    }
}
