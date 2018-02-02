package com.tencent.mm.plugin.bottle.ui;

import android.view.View;
import com.tencent.mm.ui.base.MMSlideDelView.f;

class BottleConversationUI$5 implements f {
    final /* synthetic */ BottleConversationUI kBS;

    BottleConversationUI$5(BottleConversationUI bottleConversationUI) {
        this.kBS = bottleConversationUI;
    }

    public final void t(View view, int i) {
        BottleConversationUI.c(this.kBS).performItemClick(view, i, 0);
    }
}
