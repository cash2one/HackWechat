package com.tencent.mm.plugin.photoedit.ui;

import android.view.MenuItem;
import com.tencent.mm.ui.base.p$d;

class MMNewPhotoEditUI$4 implements p$d {
    final /* synthetic */ MMNewPhotoEditUI pdv;

    MMNewPhotoEditUI$4(MMNewPhotoEditUI mMNewPhotoEditUI) {
        this.pdv = mMNewPhotoEditUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        MMNewPhotoEditUI.a(this.pdv, i);
    }
}
