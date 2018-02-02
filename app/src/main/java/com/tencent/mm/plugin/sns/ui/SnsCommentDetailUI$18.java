package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SnsCommentDetailUI$18 implements OnMenuItemClickListener {
    final /* synthetic */ SnsCommentDetailUI rAr;

    SnsCommentDetailUI$18(SnsCommentDetailUI snsCommentDetailUI) {
        this.rAr = snsCommentDetailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (SnsCommentDetailUI.b(this.rAr) != null) {
            SnsCommentDetailUI.b(this.rAr).iJ(false);
        }
        this.rAr.finish();
        return true;
    }
}
