package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.wallet_core.c.t;

class m$6 implements OnClickListener {
    final /* synthetic */ m sVV;
    final /* synthetic */ Orders sVY;
    final /* synthetic */ Context val$context;

    m$6(m mVar, Context context, Orders orders) {
        this.sVV = mVar;
        this.val$context = context;
        this.sVY = orders;
    }

    public final void onClick(View view) {
        this.sVV.sVz.setVisibility(8);
        t.d(this.sVV.pCn == null ? 0 : this.sVV.pCn.fCV, this.sVV.pCn == null ? "" : this.sVV.pCn.fuH, 12, "");
        i.a(this.val$context, this.sVY, this.sVV.sEQ.sMT, new 1(this));
    }
}
