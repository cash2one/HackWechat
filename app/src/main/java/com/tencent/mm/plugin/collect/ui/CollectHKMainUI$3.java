package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.collect.b.m;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.wallet_core.ui.e;

class CollectHKMainUI$3 implements OnClickListener {
    final /* synthetic */ m lmd;
    final /* synthetic */ CollectHKMainUI lmf;

    CollectHKMainUI$3(CollectHKMainUI collectHKMainUI, m mVar) {
        this.lmf = collectHKMainUI;
        this.lmd = mVar;
    }

    public final void onClick(View view) {
        if (!bh.ov(this.lmd.liU)) {
            e.l(this.lmf.mController.xIM, this.lmd.liU, true);
        }
    }
}
