package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ContactRemarkInfoViewUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ ContactRemarkInfoViewUI ySk;

    ContactRemarkInfoViewUI$2(ContactRemarkInfoViewUI contactRemarkInfoViewUI) {
        this.ySk = contactRemarkInfoViewUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        Intent intent = new Intent();
        intent.setClass(this.ySk.mController.xIM, ContactRemarkInfoModUI.class);
        intent.putExtra("Contact_Scene", ContactRemarkInfoViewUI.c(this.ySk));
        intent.putExtra("Contact_User", ContactRemarkInfoViewUI.d(this.ySk).field_username);
        this.ySk.startActivity(intent);
        return false;
    }
}
