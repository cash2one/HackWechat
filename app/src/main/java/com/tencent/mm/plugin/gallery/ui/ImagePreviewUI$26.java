package com.tencent.mm.plugin.gallery.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ImagePreviewUI$26 implements OnMenuItemClickListener {
    final /* synthetic */ ImagePreviewUI mUl;

    ImagePreviewUI$26(ImagePreviewUI imagePreviewUI) {
        this.mUl = imagePreviewUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        ImagePreviewUI.i(this.mUl);
        return true;
    }
}
