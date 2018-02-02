package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;

class WalletOrderInfoOldUI$a$2 implements OnClickListener {
    final /* synthetic */ a sUL;
    final /* synthetic */ Commodity sUM;

    WalletOrderInfoOldUI$a$2(a aVar, Commodity commodity) {
        this.sUL = aVar;
        this.sUM = commodity;
    }

    public final void onClick(View view) {
        b qpVar = new qp();
        qpVar.fIi.userName = this.sUM.sOr.sAb;
        qpVar.fIi.fIk = bh.az(this.sUM.sOr.sAc, "");
        qpVar.fIi.scene = 1034;
        qpVar.fIi.fIl = 0;
        com.tencent.mm.sdk.b.a.xef.m(qpVar);
        g.pQN.h(14118, new Object[]{this.sUL.sUK.oWp, this.sUL.sUK.bJQ(), Integer.valueOf(1)});
    }
}
