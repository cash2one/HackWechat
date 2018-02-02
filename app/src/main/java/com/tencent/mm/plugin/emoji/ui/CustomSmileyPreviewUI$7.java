package com.tencent.mm.plugin.emoji.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class CustomSmileyPreviewUI$7 implements OnMenuItemClickListener {
    final /* synthetic */ CustomSmileyPreviewUI lBm;

    CustomSmileyPreviewUI$7(CustomSmileyPreviewUI customSmileyPreviewUI) {
        this.lBm = customSmileyPreviewUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        CustomSmileyPreviewUI.f(this.lBm);
        return true;
    }
}
