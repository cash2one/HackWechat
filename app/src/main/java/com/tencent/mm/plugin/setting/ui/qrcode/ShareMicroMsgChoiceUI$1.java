package com.tencent.mm.plugin.setting.ui.qrcode;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ShareMicroMsgChoiceUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ ShareMicroMsgChoiceUI qgE;

    ShareMicroMsgChoiceUI$1(ShareMicroMsgChoiceUI shareMicroMsgChoiceUI) {
        this.qgE = shareMicroMsgChoiceUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.qgE.aWs();
        this.qgE.finish();
        return true;
    }
}
