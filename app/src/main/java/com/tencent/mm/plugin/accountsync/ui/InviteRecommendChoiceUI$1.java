package com.tencent.mm.plugin.accountsync.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class InviteRecommendChoiceUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ InviteRecommendChoiceUI ilC;

    InviteRecommendChoiceUI$1(InviteRecommendChoiceUI inviteRecommendChoiceUI) {
        this.ilC = inviteRecommendChoiceUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.ilC.aWs();
        this.ilC.finish();
        return true;
    }
}
