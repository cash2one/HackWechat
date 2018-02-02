package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet_core.ui.l;

class CollectMainUI$16 implements OnClickListener {
    final /* synthetic */ CollectMainUI lnh;
    final /* synthetic */ l lnn;
    final /* synthetic */ l lno;

    CollectMainUI$16(CollectMainUI collectMainUI, l lVar, l lVar2) {
        this.lnh = collectMainUI;
        this.lnn = lVar;
        this.lno = lVar2;
    }

    public final void onClick(View view) {
        if (CollectMainUI.d(this.lnh).getText().toString().equals(CollectMainUI.f(this.lnh))) {
            this.lnn.onClick(view);
        } else {
            this.lno.onClick(view);
        }
    }
}
