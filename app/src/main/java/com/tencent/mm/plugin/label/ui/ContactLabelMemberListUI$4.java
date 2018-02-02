package com.tencent.mm.plugin.label.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ContactLabelMemberListUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ ContactLabelMemberListUI nPB;

    ContactLabelMemberListUI$4(ContactLabelMemberListUI contactLabelMemberListUI) {
        this.nPB = contactLabelMemberListUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        Intent intent = new Intent();
        intent.setClass(this.nPB, ContactLabelEditUI.class);
        intent.putExtra("label_id", ContactLabelMemberListUI.c(this.nPB));
        intent.putExtra("label_name", ContactLabelMemberListUI.d(this.nPB));
        this.nPB.startActivityForResult(intent, 10001);
        return false;
    }
}
