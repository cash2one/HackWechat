package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SnsCommentUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ SnsCommentUI rBv;

    SnsCommentUI$3(SnsCommentUI snsCommentUI) {
        this.rBv = snsCommentUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.rBv.aWs();
        this.rBv.finish();
        return true;
    }
}
