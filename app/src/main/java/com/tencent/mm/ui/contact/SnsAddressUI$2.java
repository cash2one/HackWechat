package com.tencent.mm.ui.contact;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SnsAddressUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ SnsAddressUI yUF;

    SnsAddressUI$2(SnsAddressUI snsAddressUI) {
        this.yUF = snsAddressUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.yUF.finish();
        if (!this.yUF.getIntent().getBooleanExtra("stay_in_wechat", true)) {
            this.yUF.moveTaskToBack(true);
        }
        return true;
    }
}
