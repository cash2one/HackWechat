package com.tencent.mm.plugin.readerapp.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ReaderAppUI$8 implements OnMenuItemClickListener {
    final /* synthetic */ ReaderAppUI pAY;

    ReaderAppUI$8(ReaderAppUI readerAppUI) {
        this.pAY = readerAppUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.pAY.finish();
        return true;
    }
}
