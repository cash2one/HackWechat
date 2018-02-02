package com.tencent.mm.plugin.profile.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SayHiWithSnsPermissionUI$7 implements OnMenuItemClickListener {
    final /* synthetic */ SayHiWithSnsPermissionUI plm;

    SayHiWithSnsPermissionUI$7(SayHiWithSnsPermissionUI sayHiWithSnsPermissionUI) {
        this.plm = sayHiWithSnsPermissionUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (SayHiWithSnsPermissionUI.j(this.plm)) {
            SayHiWithSnsPermissionUI.k(this.plm)[1] = 1;
        }
        this.plm.finish();
        return true;
    }
}
