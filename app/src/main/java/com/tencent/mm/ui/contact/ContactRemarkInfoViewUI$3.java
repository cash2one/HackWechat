package com.tencent.mm.ui.contact;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ContactRemarkInfoViewUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ ContactRemarkInfoViewUI ySk;

    ContactRemarkInfoViewUI$3(ContactRemarkInfoViewUI contactRemarkInfoViewUI) {
        this.ySk = contactRemarkInfoViewUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.ySk.finish();
        return true;
    }
}
