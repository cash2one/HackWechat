package com.tencent.mm.plugin.qqmail.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class ReadMailUI$13 implements OnMenuItemClickListener {
    final /* synthetic */ ReadMailUI puG;

    ReadMailUI$13(ReadMailUI readMailUI) {
        this.puG = readMailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        h.a(this.puG, null, this.puG.getResources().getStringArray(R.c.bqT), this.puG.getResources().getString(R.l.eCf), false, new 1(this));
        return false;
    }
}
