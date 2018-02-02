package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class PreviewHdHeadImg$2 implements OnMenuItemClickListener {
    final /* synthetic */ PreviewHdHeadImg qhv;

    PreviewHdHeadImg$2(PreviewHdHeadImg previewHdHeadImg) {
        this.qhv = previewHdHeadImg;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.qhv.finish();
        return true;
    }
}
