package com.tencent.mm.ui.transmit;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class RetransmitPreviewUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ RetransmitPreviewUI zoX;

    RetransmitPreviewUI$1(RetransmitPreviewUI retransmitPreviewUI) {
        this.zoX = retransmitPreviewUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.zoX.finish();
        return true;
    }
}
