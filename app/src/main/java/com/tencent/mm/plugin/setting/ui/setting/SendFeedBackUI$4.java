package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class SendFeedBackUI$4 implements OnClickListener {
    final /* synthetic */ SendFeedBackUI qhI;

    SendFeedBackUI$4(SendFeedBackUI sendFeedBackUI) {
        this.qhI = sendFeedBackUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.qhI.finish();
    }
}
