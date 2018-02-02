package com.tencent.mm.ui.account;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class RegByMobileVoiceVerifySelectUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ RegByMobileVoiceVerifySelectUI xRl;

    RegByMobileVoiceVerifySelectUI$1(RegByMobileVoiceVerifySelectUI regByMobileVoiceVerifySelectUI) {
        this.xRl = regByMobileVoiceVerifySelectUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.xRl.aWs();
        this.xRl.finish();
        return true;
    }
}
