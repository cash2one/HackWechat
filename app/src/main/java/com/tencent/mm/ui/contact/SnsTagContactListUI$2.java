package com.tencent.mm.ui.contact;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SnsTagContactListUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ SnsTagContactListUI yUU;

    SnsTagContactListUI$2(SnsTagContactListUI snsTagContactListUI) {
        this.yUU = snsTagContactListUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.yUU.finish();
        return true;
    }
}
