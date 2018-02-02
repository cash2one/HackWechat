package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class ShareImageSelectorUI$7 implements OnCancelListener {
    final /* synthetic */ ShareImageSelectorUI zpM;

    ShareImageSelectorUI$7(ShareImageSelectorUI shareImageSelectorUI) {
        this.zpM = shareImageSelectorUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ShareImageSelectorUI.b(this.zpM);
    }
}
