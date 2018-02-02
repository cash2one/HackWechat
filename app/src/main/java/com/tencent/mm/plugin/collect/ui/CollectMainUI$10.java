package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.widget.g;
import java.util.List;

class CollectMainUI$10 implements OnClickListener {
    final /* synthetic */ CollectMainUI lnh;
    final /* synthetic */ List lnl;

    CollectMainUI$10(CollectMainUI collectMainUI, List list) {
        this.lnh = collectMainUI;
        this.lnl = list;
    }

    public final void onClick(View view) {
        g gVar = new g(this.lnh.mController.xIM, g.ztp, false);
        gVar.rKC = new 1(this);
        gVar.rKD = new 2(this);
        gVar.bUk();
    }
}
