package com.tencent.mm.plugin.favorite.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class FavImgGalleryUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ FavImgGalleryUI msr;

    FavImgGalleryUI$4(FavImgGalleryUI favImgGalleryUI) {
        this.msr = favImgGalleryUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.msr.finish();
        return true;
    }
}
