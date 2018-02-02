package com.tencent.mm.plugin.base.stub;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WXEntryActivity$1 implements OnMenuItemClickListener {
    final /* synthetic */ WXEntryActivity kvo;

    WXEntryActivity$1(WXEntryActivity wXEntryActivity) {
        this.kvo = wXEntryActivity;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        WXEntryActivity.a(this.kvo);
        return false;
    }
}
