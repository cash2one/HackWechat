package com.tencent.mm.plugin.game.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.g;

class d$1 implements OnClickListener {
    final /* synthetic */ boolean nlk;
    final /* synthetic */ d nll;

    d$1(d dVar, boolean z) {
        this.nll = dVar;
        this.nlk = z;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        g.pQN.h(14217, new Object[]{this.nll.nbT.field_appId, Integer.valueOf(5), "", this.nll.nbT.fQE, Integer.valueOf(2)});
        d.a(this.nll, this.nlk);
        dialogInterface.dismiss();
    }
}
