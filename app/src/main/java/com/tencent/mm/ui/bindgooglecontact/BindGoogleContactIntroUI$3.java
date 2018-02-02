package com.tencent.mm.ui.bindgooglecontact;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class BindGoogleContactIntroUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ BindGoogleContactIntroUI ykv;

    BindGoogleContactIntroUI$3(BindGoogleContactIntroUI bindGoogleContactIntroUI) {
        this.ykv = bindGoogleContactIntroUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.ykv.finish();
        return true;
    }
}
