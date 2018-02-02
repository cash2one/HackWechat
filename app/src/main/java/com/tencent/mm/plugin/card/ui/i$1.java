package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.card.b.b;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.report.service.g;

class i$1 implements OnClickListener {
    final /* synthetic */ i kUC;

    i$1(i iVar) {
        this.kUC = iVar;
    }

    public final void onClick(View view) {
        b.a(this.kUC.kaY, false);
        am.auE().aun();
        this.kUC.awd();
        g.pQN.h(11324, new Object[]{"CardMsgCenterView", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(0), "", Integer.valueOf(0), ""});
    }
}
