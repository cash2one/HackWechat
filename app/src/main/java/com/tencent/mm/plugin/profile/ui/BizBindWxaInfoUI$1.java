package com.tencent.mm.plugin.profile.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class BizBindWxaInfoUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ BizBindWxaInfoUI phn;

    BizBindWxaInfoUI$1(BizBindWxaInfoUI bizBindWxaInfoUI) {
        this.phn = bizBindWxaInfoUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.phn.finish();
        return false;
    }
}
