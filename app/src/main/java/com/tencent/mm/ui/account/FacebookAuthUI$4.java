package com.tencent.mm.ui.account;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class FacebookAuthUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ FacebookAuthUI xNS;

    FacebookAuthUI$4(FacebookAuthUI facebookAuthUI) {
        this.xNS = facebookAuthUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        Intent intent = this.xNS.getIntent();
        intent.putExtra("bind_facebook_succ", FacebookAuthUI.b(this.xNS));
        this.xNS.setResult(-1, intent);
        this.xNS.finish();
        return true;
    }
}
