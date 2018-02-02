package com.tencent.mm.plugin.label.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ContactLabelEditUI$7 implements OnMenuItemClickListener {
    final /* synthetic */ ContactLabelEditUI nOY;

    ContactLabelEditUI$7(ContactLabelEditUI contactLabelEditUI) {
        this.nOY = contactLabelEditUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.nOY.onBackPressed();
        return true;
    }
}
