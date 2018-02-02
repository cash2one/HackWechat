package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;

class WalletLqtDetailUI$9 implements OnClickListener {
    final /* synthetic */ WalletLqtDetailUI sAM;

    WalletLqtDetailUI$9(WalletLqtDetailUI walletLqtDetailUI) {
        this.sAM = walletLqtDetailUI;
    }

    public final void onClick(View view) {
        b qpVar = new qp();
        qpVar.fIi.userName = WalletLqtDetailUI.c(this.sAM).wGL.username;
        qpVar.fIi.fIk = bh.az(WalletLqtDetailUI.c(this.sAM).wGL.path, "");
        qpVar.fIi.scene = 1061;
        qpVar.fIi.fIl = 0;
        a.xef.m(qpVar);
    }
}
