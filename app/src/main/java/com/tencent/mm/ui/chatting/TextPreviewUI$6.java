package com.tencent.mm.ui.chatting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class TextPreviewUI$6 implements OnMenuItemClickListener {
    final /* synthetic */ TextPreviewUI yxT;

    TextPreviewUI$6(TextPreviewUI textPreviewUI) {
        this.yxT = textPreviewUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.yxT.finish();
        return true;
    }
}
