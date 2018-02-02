package com.tencent.mm.ui.chatting.gallery;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ImageGalleryGridUI$5 implements OnMenuItemClickListener {
    final /* synthetic */ ImageGalleryGridUI yEd;

    ImageGalleryGridUI$5(ImageGalleryGridUI imageGalleryGridUI) {
        this.yEd = imageGalleryGridUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.yEd.onBackPressed();
        return true;
    }
}
