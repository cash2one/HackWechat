package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.k.b;
import com.tencent.mm.ui.tools.a.c;

class SnsCommentUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ SnsCommentUI rBv;

    SnsCommentUI$2(SnsCommentUI snsCommentUI) {
        this.rBv = snsCommentUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        int i;
        if (SnsCommentUI.a(this.rBv) == 0) {
            b.zB();
        }
        if (SnsCommentUI.a(this.rBv) == 2) {
            i = 200;
        } else {
            i = b.zA();
        }
        c GN = c.d(SnsCommentUI.b(this.rBv)).GN(i);
        GN.znM = true;
        GN.a(new 1(this));
        return false;
    }
}
