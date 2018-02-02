package com.tencent.mm.ui.conversation;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.conversation.AppBrandServiceConversationUI.AppBrandServiceConversationFmUI;

class AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$5 implements OnMenuItemClickListener {
    final /* synthetic */ AppBrandServiceConversationFmUI yVG;

    AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$5(AppBrandServiceConversationFmUI appBrandServiceConversationFmUI) {
        this.yVG = appBrandServiceConversationFmUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.yVG.finish();
        return true;
    }
}
