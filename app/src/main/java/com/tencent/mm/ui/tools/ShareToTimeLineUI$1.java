package com.tencent.mm.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class ShareToTimeLineUI$1 implements OnCancelListener {
    final /* synthetic */ ShareToTimeLineUI zmU;

    ShareToTimeLineUI$1(ShareToTimeLineUI shareToTimeLineUI) {
        this.zmU = shareToTimeLineUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.zmU.finish();
    }
}
