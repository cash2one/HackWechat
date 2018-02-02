package com.tencent.mm.plugin.emoji.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class CustomSmileyPreviewUI$6 implements OnMenuItemClickListener {
    final /* synthetic */ CustomSmileyPreviewUI lBm;

    CustomSmileyPreviewUI$6(CustomSmileyPreviewUI customSmileyPreviewUI) {
        this.lBm = customSmileyPreviewUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.lBm.finish();
        return true;
    }
}
