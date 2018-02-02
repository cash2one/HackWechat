package com.tencent.mm.plugin.subapp.ui.friend;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class FMessageConversationUI$8 implements OnMenuItemClickListener {
    final /* synthetic */ FMessageConversationUI rXh;

    FMessageConversationUI$8(FMessageConversationUI fMessageConversationUI) {
        this.rXh = fMessageConversationUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.rXh.finish();
        return true;
    }
}
