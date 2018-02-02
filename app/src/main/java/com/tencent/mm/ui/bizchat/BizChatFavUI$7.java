package com.tencent.mm.ui.bizchat;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class BizChatFavUI$7 implements OnMenuItemClickListener {
    final /* synthetic */ BizChatFavUI ynN;

    BizChatFavUI$7(BizChatFavUI bizChatFavUI) {
        this.ynN = bizChatFavUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.ynN.finish();
        return true;
    }
}
