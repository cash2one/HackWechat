package com.tencent.mm.plugin.product.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class MallGalleryUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ MallGalleryUI pfu;

    MallGalleryUI$3(MallGalleryUI mallGalleryUI) {
        this.pfu = mallGalleryUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.pfu.finish();
        return false;
    }
}
