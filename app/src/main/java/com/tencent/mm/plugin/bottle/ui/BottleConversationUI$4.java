package com.tencent.mm.plugin.bottle.ui;

import android.view.View;
import com.tencent.mm.ui.base.MMSlideDelView.c;

class BottleConversationUI$4 implements c {
    final /* synthetic */ BottleConversationUI kBS;

    BottleConversationUI$4(BottleConversationUI bottleConversationUI) {
        this.kBS = bottleConversationUI;
    }

    public final int ci(View view) {
        return BottleConversationUI.c(this.kBS).getPositionForView(view);
    }
}
