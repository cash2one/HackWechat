package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ContactSearchResultUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ ContactSearchResultUI rYq;

    ContactSearchResultUI$1(ContactSearchResultUI contactSearchResultUI) {
        this.rYq = contactSearchResultUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.rYq.finish();
        return true;
    }
}
