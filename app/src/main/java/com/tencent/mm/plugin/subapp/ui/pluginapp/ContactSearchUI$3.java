package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ContactSearchUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ ContactSearchUI rYw;

    ContactSearchUI$3(ContactSearchUI contactSearchUI) {
        this.rYw = contactSearchUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        ContactSearchUI.b(this.rYw);
        return false;
    }
}
