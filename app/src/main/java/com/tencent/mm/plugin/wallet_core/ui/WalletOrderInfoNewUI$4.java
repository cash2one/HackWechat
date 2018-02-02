package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class WalletOrderInfoNewUI$4 implements OnClickListener {
    final /* synthetic */ WalletOrderInfoNewUI sUp;
    final /* synthetic */ Commodity sUq;

    WalletOrderInfoNewUI$4(WalletOrderInfoNewUI walletOrderInfoNewUI, Commodity commodity) {
        this.sUp = walletOrderInfoNewUI;
        this.sUq = commodity;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.WalletOrderInfoNewUI", "click tiny app, userName: %s, path: %s, version: %s", new Object[]{WalletOrderInfoNewUI.l(this.sUp), WalletOrderInfoNewUI.m(this.sUp), Integer.valueOf(WalletOrderInfoNewUI.q(this.sUp))});
        b qpVar = new qp();
        qpVar.fIi.userName = WalletOrderInfoNewUI.l(this.sUp);
        qpVar.fIi.fIk = bh.az(WalletOrderInfoNewUI.m(this.sUp), "");
        qpVar.fIi.scene = 1034;
        qpVar.fIi.fIl = 0;
        if (WalletOrderInfoNewUI.q(this.sUp) > 0) {
            qpVar.fIi.fIm = WalletOrderInfoNewUI.q(this.sUp);
        }
        qpVar.fIi.context = this.sUp;
        a.xef.m(qpVar);
        WalletOrderInfoNewUI walletOrderInfoNewUI = this.sUp;
        boolean z = !bh.ov(this.sUq.sOr.sNC) && this.sUq.sOr.sOK > 0;
        WalletOrderInfoNewUI.a(walletOrderInfoNewUI, z);
        if (WalletOrderInfoNewUI.n(this.sUp)) {
            g.pQN.h(14118, new Object[]{WalletOrderInfoNewUI.o(this.sUp), this.sUp.bJQ(), Integer.valueOf(3)});
        } else {
            g.pQN.h(14118, new Object[]{WalletOrderInfoNewUI.o(this.sUp), this.sUp.bJQ(), Integer.valueOf(1)});
        }
    }
}
