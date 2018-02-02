package com.tencent.mm.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class ShareImageRedirectUI$3 implements OnClickListener {
    final /* synthetic */ ShareImageRedirectUI zmH;

    ShareImageRedirectUI$3(ShareImageRedirectUI shareImageRedirectUI) {
        this.zmH = shareImageRedirectUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zmH.finish();
    }
}
