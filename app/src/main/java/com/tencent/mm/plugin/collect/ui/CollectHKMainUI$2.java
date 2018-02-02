package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.collect.b.m;
import com.tencent.mm.wallet_core.ui.e;

class CollectHKMainUI$2 implements OnClickListener {
    final /* synthetic */ m lmd;
    final /* synthetic */ CollectHKMainUI lmf;

    CollectHKMainUI$2(CollectHKMainUI collectHKMainUI, m mVar) {
        this.lmf = collectHKMainUI;
        this.lmd = mVar;
    }

    public final void onClick(View view) {
        e.l(this.lmf.mController.xIM, this.lmd.liQ, false);
    }
}
