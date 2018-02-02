package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.luckymoney.b.ah;
import com.tencent.mm.plugin.luckymoney.ui.g.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.f;
import com.tencent.mm.wallet_core.ui.e;

class g$a$1 implements OnClickListener {
    final /* synthetic */ ah ojn;
    final /* synthetic */ a ojo;
    final /* synthetic */ Context val$context;

    g$a$1(a aVar, ah ahVar, Context context) {
        this.ojo = aVar;
        this.ojn = ahVar;
        this.val$context = context;
    }

    public final void onClick(View view) {
        g.pQN.h(11701, new Object[]{Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(this.ojn.odF)});
        if (this.ojo.ojm != null) {
            f.eB(this.ojo.ojm.ojs, 1);
        }
        e.l(this.val$context, this.ojn.content, true);
    }
}
