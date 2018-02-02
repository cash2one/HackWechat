package com.tencent.mm.plugin.readerapp.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.readerapp.a.a;

class ReaderAppUI$9 implements OnMenuItemClickListener {
    final /* synthetic */ ReaderAppUI pAY;

    ReaderAppUI$9(ReaderAppUI readerAppUI) {
        this.pAY = readerAppUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        a.ifs.d(new Intent().putExtra("Contact_User", ReaderAppUI.f(this.pAY)), this.pAY);
        return true;
    }
}
