package com.tencent.mm.ui.chatting.gallery;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class MediaHistoryGalleryUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ MediaHistoryGalleryUI yGO;

    MediaHistoryGalleryUI$3(MediaHistoryGalleryUI mediaHistoryGalleryUI) {
        this.yGO = mediaHistoryGalleryUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.yGO.finish();
        return true;
    }
}
