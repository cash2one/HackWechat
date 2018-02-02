package com.tencent.mm.plugin.label.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ContactLabelMemberListUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ ContactLabelMemberListUI nPB;

    ContactLabelMemberListUI$3(ContactLabelMemberListUI contactLabelMemberListUI) {
        this.nPB = contactLabelMemberListUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.nPB.finish();
        return false;
    }
}
