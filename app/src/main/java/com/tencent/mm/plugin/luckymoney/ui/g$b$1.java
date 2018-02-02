package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.luckymoney.b.ah;
import com.tencent.mm.plugin.luckymoney.ui.g.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.wallet_core.ui.e;

class g$b$1 implements OnClickListener {
    final /* synthetic */ ah ojn;
    final /* synthetic */ b ojp;
    final /* synthetic */ Context val$context;

    g$b$1(b bVar, ah ahVar, Context context) {
        this.ojp = bVar;
        this.ojn = ahVar;
        this.val$context = context;
    }

    public final void onClick(View view) {
        g.pQN.h(11701, new Object[]{Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(this.ojn.odF)});
        if (this.ojn.odG != 1) {
            ((com.tencent.mm.pluginsdk.g) com.tencent.mm.kernel.g.h(com.tencent.mm.pluginsdk.g.class)).a(this.val$context, this.ojn.content, new 1(this)).show();
        } else {
            e.S(this.val$context, this.ojn.content);
        }
    }
}
