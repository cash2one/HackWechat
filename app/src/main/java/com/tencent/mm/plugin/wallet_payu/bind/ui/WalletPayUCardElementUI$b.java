package com.tencent.mm.plugin.wallet_payu.bind.ui;

import com.tencent.mm.plugin.wallet_payu.bind.model.NetScenePayUElementQuery;
import com.tencent.mm.plugin.wallet_payu.bind.model.NetScenePayUElementQuery.PayUBankcardElement;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.sdk.platformtools.bh;

protected class WalletPayUCardElementUI$b {
    final /* synthetic */ WalletPayUCardElementUI tbR;
    boolean tbS;
    boolean tbT;
    boolean tbU;

    protected WalletPayUCardElementUI$b(WalletPayUCardElementUI walletPayUCardElementUI) {
        this.tbR = walletPayUCardElementUI;
    }

    protected final void bNr() {
        this.tbS = WalletPayUCardElementUI.c(this.tbR).XO();
        this.tbT = WalletPayUCardElementUI.b(this.tbR).XO();
        this.tbU = WalletPayUCardElementUI.a(this.tbR).XO();
        if (!WalletPayUCardElementUI.e(this.tbR) || this.tbU) {
            WalletPayUCardElementUI.f(this.tbR).setVisibility(4);
        } else {
            WalletPayUCardElementUI.f(this.tbR).setVisibility(0);
            WalletPayUCardElementUI.f(this.tbR).setText(a$i.uQg);
        }
        boolean z;
        if (!WalletPayUCardElementUI.g(this.tbR)) {
            z = false;
        } else if (!this.tbS) {
            WalletPayUCardElementUI.h(this.tbR).setVisibility(0);
            WalletPayUCardElementUI.h(this.tbR).setTextColor(this.tbR.getResources().getColor(c.btB));
            WalletPayUCardElementUI.h(this.tbR).setText(a$i.uQb);
            z = false;
        } else if (!WalletPayUCardElementUI.d(this.tbR).containsKey(WalletPayUCardElementUI.c(this.tbR).getText()) || WalletPayUCardElementUI.i(this.tbR).contains(WalletPayUCardElementUI.c(this.tbR).getText())) {
            this.tbR.b(new NetScenePayUElementQuery(WalletPayUCardElementUI.c(this.tbR).getText()), false);
            WalletPayUCardElementUI.i(this.tbR).add(WalletPayUCardElementUI.c(this.tbR).getText());
            WalletPayUCardElementUI.h(this.tbR).setVisibility(0);
            WalletPayUCardElementUI.h(this.tbR).setTextColor(this.tbR.getResources().getColor(c.bsO));
            WalletPayUCardElementUI.h(this.tbR).setText(this.tbR.getString(a$i.uPS));
            z = true;
        } else {
            PayUBankcardElement payUBankcardElement = (PayUBankcardElement) WalletPayUCardElementUI.d(this.tbR).get(WalletPayUCardElementUI.c(this.tbR).getText());
            WalletPayUCardElementUI.h(this.tbR).setVisibility(0);
            if (bh.ov(payUBankcardElement.tbA)) {
                WalletPayUCardElementUI.h(this.tbR).setTextColor(this.tbR.getResources().getColor(c.btB));
                WalletPayUCardElementUI.h(this.tbR).setText(payUBankcardElement.tbB);
                this.tbS = false;
                z = false;
            } else {
                WalletPayUCardElementUI.h(this.tbR).setTextColor(this.tbR.getResources().getColor(c.bsO));
                WalletPayUCardElementUI.h(this.tbR).setText(payUBankcardElement.tbB);
                z = false;
            }
        }
        if (this.tbS && this.tbT && this.tbU && !r0) {
            WalletPayUCardElementUI.j(this.tbR).setEnabled(true);
        } else {
            WalletPayUCardElementUI.j(this.tbR).setEnabled(false);
        }
    }
}
