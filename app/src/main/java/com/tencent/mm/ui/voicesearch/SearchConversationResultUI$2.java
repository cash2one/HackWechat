package com.tencent.mm.ui.voicesearch;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SearchConversationResultUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ SearchConversationResultUI zqx;

    SearchConversationResultUI$2(SearchConversationResultUI searchConversationResultUI) {
        this.zqx = searchConversationResultUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.zqx.finish();
        return true;
    }
}
