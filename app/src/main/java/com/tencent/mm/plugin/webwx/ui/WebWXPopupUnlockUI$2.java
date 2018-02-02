package com.tencent.mm.plugin.webwx.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class WebWXPopupUnlockUI$2 implements OnDismissListener {
    final /* synthetic */ WebWXPopupUnlockUI tOS;

    WebWXPopupUnlockUI$2(WebWXPopupUnlockUI webWXPopupUnlockUI) {
        this.tOS = webWXPopupUnlockUI;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        this.tOS.finish();
    }
}
