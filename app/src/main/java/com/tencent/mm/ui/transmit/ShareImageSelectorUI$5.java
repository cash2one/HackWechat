package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class ShareImageSelectorUI$5 implements OnClickListener {
    final /* synthetic */ ShareImageSelectorUI zpM;

    ShareImageSelectorUI$5(ShareImageSelectorUI shareImageSelectorUI) {
        this.zpM = shareImageSelectorUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (ShareImageSelectorUI.ts() == 1) {
            ShareImageSelectorUI.c(this.zpM);
        }
    }
}
