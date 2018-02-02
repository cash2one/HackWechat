package com.tencent.mm.plugin.bottle.ui;

import android.view.MenuItem;
import com.tencent.mm.ui.base.p$d;

class BottleConversationUI$2 implements p$d {
    final /* synthetic */ BottleConversationUI kBS;

    BottleConversationUI$2(BottleConversationUI bottleConversationUI) {
        this.kBS = bottleConversationUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        BottleConversationUI.a(this.kBS, BottleConversationUI.e(this.kBS));
    }
}
