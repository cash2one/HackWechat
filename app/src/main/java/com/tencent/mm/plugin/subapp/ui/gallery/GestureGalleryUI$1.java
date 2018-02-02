package com.tencent.mm.plugin.subapp.ui.gallery;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class GestureGalleryUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ GestureGalleryUI rXs;

    GestureGalleryUI$1(GestureGalleryUI gestureGalleryUI) {
        this.rXs = gestureGalleryUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.rXs.finish();
        return true;
    }
}
