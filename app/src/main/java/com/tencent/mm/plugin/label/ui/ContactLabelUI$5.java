package com.tencent.mm.plugin.label.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ContactLabelUI$5 implements OnMenuItemClickListener {
    final /* synthetic */ ContactLabelUI nPX;

    ContactLabelUI$5(ContactLabelUI contactLabelUI) {
        this.nPX = contactLabelUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        ContactLabelUI.a(this.nPX);
        return false;
    }
}
