package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import com.tencent.mm.ui.base.MMSlideDelView.f;

class SnsMsgUI$11 implements f {
    final /* synthetic */ SnsMsgUI rDE;

    SnsMsgUI$11(SnsMsgUI snsMsgUI) {
        this.rDE = snsMsgUI;
    }

    public final void t(View view, int i) {
        SnsMsgUI.b(this.rDE).performItemClick(view, i, 0);
    }
}
