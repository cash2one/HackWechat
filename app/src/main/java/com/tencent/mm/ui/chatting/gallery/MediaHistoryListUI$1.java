package com.tencent.mm.ui.chatting.gallery;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class MediaHistoryListUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ MediaHistoryListUI yGS;

    MediaHistoryListUI$1(MediaHistoryListUI mediaHistoryListUI) {
        this.yGS = mediaHistoryListUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.yGS.finish();
        return true;
    }
}
