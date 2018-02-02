package com.tencent.mm.ui.contact;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SnsLabelContactListUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SnsLabelContactListUI yUM;

    SnsLabelContactListUI$1(SnsLabelContactListUI snsLabelContactListUI) {
        this.yUM = snsLabelContactListUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.yUM.finish();
        return true;
    }
}
