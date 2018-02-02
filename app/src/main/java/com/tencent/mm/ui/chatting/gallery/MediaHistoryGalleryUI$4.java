package com.tencent.mm.ui.chatting.gallery;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class MediaHistoryGalleryUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ MediaHistoryGalleryUI yGO;

    MediaHistoryGalleryUI$4(MediaHistoryGalleryUI mediaHistoryGalleryUI) {
        this.yGO = mediaHistoryGalleryUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.yGO.cuj();
        return true;
    }
}
