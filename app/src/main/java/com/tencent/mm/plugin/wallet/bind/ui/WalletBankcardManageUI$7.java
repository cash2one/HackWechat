package com.tencent.mm.plugin.wallet.bind.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.plugin.wallet_core.model.f;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;

class WalletBankcardManageUI$7 implements OnClickListener {
    final /* synthetic */ WalletBankcardManageUI sCF;
    final /* synthetic */ f sCH;

    WalletBankcardManageUI$7(WalletBankcardManageUI walletBankcardManageUI, f fVar) {
        this.sCF = walletBankcardManageUI;
        this.sCH = fVar;
    }

    public final void onClick(View view) {
        b qpVar = new qp();
        qpVar.fIi.userName = this.sCH.sLC;
        qpVar.fIi.fIk = bh.az(this.sCH.sLD, "");
        qpVar.fIi.scene = 1071;
        qpVar.fIi.fIl = 0;
        a.xef.m(qpVar);
    }
}
