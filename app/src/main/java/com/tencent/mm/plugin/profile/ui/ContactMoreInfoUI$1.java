package com.tencent.mm.plugin.profile.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ContactMoreInfoUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ ContactMoreInfoUI pis;

    ContactMoreInfoUI$1(ContactMoreInfoUI contactMoreInfoUI) {
        this.pis = contactMoreInfoUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.pis.finish();
        return true;
    }
}
