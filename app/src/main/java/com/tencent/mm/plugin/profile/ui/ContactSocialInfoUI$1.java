package com.tencent.mm.plugin.profile.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ContactSocialInfoUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ ContactSocialInfoUI piH;

    ContactSocialInfoUI$1(ContactSocialInfoUI contactSocialInfoUI) {
        this.piH = contactSocialInfoUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.piH.finish();
        return true;
    }
}
