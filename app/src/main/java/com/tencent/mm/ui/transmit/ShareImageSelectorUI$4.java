package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class ShareImageSelectorUI$4 implements OnClickListener {
    final /* synthetic */ ShareImageSelectorUI zpM;

    ShareImageSelectorUI$4(ShareImageSelectorUI shareImageSelectorUI) {
        this.zpM = shareImageSelectorUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zpM.finish();
    }
}
