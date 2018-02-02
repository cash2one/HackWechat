package com.tencent.mm.ui.chatting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ResourcesExceedUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ ResourcesExceedUI yxt;

    ResourcesExceedUI$1(ResourcesExceedUI resourcesExceedUI) {
        this.yxt = resourcesExceedUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.yxt.finish();
        return true;
    }
}
