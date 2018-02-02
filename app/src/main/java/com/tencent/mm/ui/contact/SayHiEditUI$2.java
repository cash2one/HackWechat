package com.tencent.mm.ui.contact;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SayHiEditUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ SayHiEditUI yUe;

    SayHiEditUI$2(SayHiEditUI sayHiEditUI) {
        this.yUe = sayHiEditUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.yUe.finish();
        return true;
    }
}
