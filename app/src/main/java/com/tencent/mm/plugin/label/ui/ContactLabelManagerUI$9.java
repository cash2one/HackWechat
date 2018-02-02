package com.tencent.mm.plugin.label.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ContactLabelManagerUI$9 implements OnMenuItemClickListener {
    final /* synthetic */ ContactLabelManagerUI nPj;

    ContactLabelManagerUI$9(ContactLabelManagerUI contactLabelManagerUI) {
        this.nPj = contactLabelManagerUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        ContactLabelManagerUI.b(this.nPj);
        return false;
    }
}
