package com.tencent.mm.ui.bizchat;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class BizChatroomInfoUI$8 implements OnMenuItemClickListener {
    final /* synthetic */ BizChatroomInfoUI yoK;

    BizChatroomInfoUI$8(BizChatroomInfoUI bizChatroomInfoUI) {
        this.yoK = bizChatroomInfoUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.yoK.finish();
        return true;
    }
}
