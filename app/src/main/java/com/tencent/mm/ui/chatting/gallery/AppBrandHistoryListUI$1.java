package com.tencent.mm.ui.chatting.gallery;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class AppBrandHistoryListUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ AppBrandHistoryListUI yCQ;

    AppBrandHistoryListUI$1(AppBrandHistoryListUI appBrandHistoryListUI) {
        this.yCQ = appBrandHistoryListUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.yCQ.finish();
        return true;
    }
}
