package com.tencent.mm.ui.account;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class RegByMobileVoiceVerifyUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ RegByMobileVoiceVerifyUI xRp;

    RegByMobileVoiceVerifyUI$1(RegByMobileVoiceVerifyUI regByMobileVoiceVerifyUI) {
        this.xRp = regByMobileVoiceVerifyUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.xRp.aWs();
        this.xRp.finish();
        return true;
    }
}
