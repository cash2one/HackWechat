package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import com.tencent.mm.ui.base.MMSlideDelView.c;

class SnsMsgUI$10 implements c {
    final /* synthetic */ SnsMsgUI rDE;

    SnsMsgUI$10(SnsMsgUI snsMsgUI) {
        this.rDE = snsMsgUI;
    }

    public final int ci(View view) {
        return SnsMsgUI.b(this.rDE).getPositionForView(view);
    }
}
