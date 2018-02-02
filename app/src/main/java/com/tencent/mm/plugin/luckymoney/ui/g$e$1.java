package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.luckymoney.b.ah;
import com.tencent.mm.plugin.luckymoney.ui.g.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.f;
import com.tencent.mm.sdk.platformtools.x;

class g$e$1 implements OnClickListener {
    final /* synthetic */ ah ojn;
    final /* synthetic */ e ojt;
    final /* synthetic */ Context val$context;

    g$e$1(e eVar, ah ahVar, Context context) {
        this.ojt = eVar;
        this.ojn = ahVar;
        this.val$context = context;
    }

    public final void onClick(View view) {
        g.pQN.h(11701, Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(this.ojn.odF));
        if (this.ojt.ojm != null) {
            f.eB(this.ojt.ojm.ojs, 1);
        }
        if (this.ojt.ojm != null && this.ojt.ojm.ojr) {
            g.pQN.h(13051, Integer.valueOf(this.ojt.ojm.ojs), Integer.valueOf(2), "", "", "", this.ojn.content, this.ojn.type, "", "", Integer.valueOf(this.ojt.ojm.resourceId));
        }
        if (this.ojn.type.equals("Native")) {
            x.i("MicroMsg.LuckyMoneyOperationViewMgr", "go native:" + this.ojn.content);
            if ("weixin://festival/gotoshake".equalsIgnoreCase(this.ojn.content)) {
                x.i("MicroMsg.LuckyMoneyOperationViewMgr", " go new year shake");
                return;
            }
            return;
        }
        com.tencent.mm.wallet_core.ui.e.l(this.val$context, this.ojn.content, true);
    }
}
