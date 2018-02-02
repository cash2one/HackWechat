package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.g;

public final class o {
    public static int syM = 123;
    public static int syN = 456;
    public int accountType;
    public String fuI;
    public b igh;
    private m syO = null;
    public n syP = null;
    public WalletLqtSaveFetchUI syQ = null;
    public String syR;
    public int syS;
    public int syT;
    public String syU;
    public Bankcard syV;

    static /* synthetic */ void a(o oVar, String str, Bankcard bankcard) {
        if (bankcard == null) {
            bankcard = oVar.syV;
        }
        oVar.igh = g.czQ();
        oVar.igh.czP();
        h.a(oVar.syQ, bankcard != null ? bankcard.field_bindSerial : "", str, "", oVar.accountType == 0 ? 45 : 52, syM);
    }

    public o(m mVar, n nVar, WalletLqtSaveFetchUI walletLqtSaveFetchUI) {
        this.syO = mVar;
        this.syP = nVar;
        this.syQ = walletLqtSaveFetchUI;
    }
}
