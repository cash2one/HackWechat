package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.protocal.c.jn;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;

class RemittanceBusiResultUI$4 implements OnClickListener {
    final /* synthetic */ RemittanceBusiResultUI pNo;
    final /* synthetic */ jn pNq;

    RemittanceBusiResultUI$4(RemittanceBusiResultUI remittanceBusiResultUI, jn jnVar) {
        this.pNo = remittanceBusiResultUI;
        this.pNq = jnVar;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.RemittanceBusiResultUI", "app type: %s", new Object[]{Integer.valueOf(this.pNq.type)});
        if (this.pNq.type == 1) {
            RemittanceBusiResultUI.a(this.pNo);
            b qpVar = new qp();
            qpVar.fIi.userName = this.pNq.vPQ;
            qpVar.fIi.fIk = bh.az(this.pNq.vPR, "");
            qpVar.fIi.scene = 1034;
            qpVar.fIi.fIl = 0;
            a.xef.m(qpVar);
        } else if (this.pNq.type == 2) {
            RemittanceBusiResultUI.a(this.pNo);
            e.l(this.pNo.mController.xIM, this.pNq.url, true);
        } else {
            int i = this.pNq.type;
        }
    }
}
