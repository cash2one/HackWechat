package com.tencent.mm.pluginsdk.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class BioHelperUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ BioHelperUI vjs;

    BioHelperUI$1(BioHelperUI bioHelperUI) {
        this.vjs = bioHelperUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.vjs.finish();
        return true;
    }
}
