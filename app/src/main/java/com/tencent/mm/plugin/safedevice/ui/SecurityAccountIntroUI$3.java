package com.tencent.mm.plugin.safedevice.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SecurityAccountIntroUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ SecurityAccountIntroUI pRR;

    SecurityAccountIntroUI$3(SecurityAccountIntroUI securityAccountIntroUI) {
        this.pRR = securityAccountIntroUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        SecurityAccountIntroUI.e(this.pRR);
        return true;
    }
}
