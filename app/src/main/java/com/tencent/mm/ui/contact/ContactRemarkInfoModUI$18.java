package com.tencent.mm.ui.contact;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ContactRemarkInfoModUI$18 implements OnMenuItemClickListener {
    final /* synthetic */ ContactRemarkInfoModUI ySf;

    ContactRemarkInfoModUI$18(ContactRemarkInfoModUI contactRemarkInfoModUI) {
        this.ySf = contactRemarkInfoModUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        ContactRemarkInfoModUI.q(this.ySf);
        this.ySf.aWs();
        return false;
    }
}
