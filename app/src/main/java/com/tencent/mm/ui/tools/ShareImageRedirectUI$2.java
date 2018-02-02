package com.tencent.mm.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class ShareImageRedirectUI$2 implements OnClickListener {
    final /* synthetic */ ShareImageRedirectUI zmH;

    ShareImageRedirectUI$2(ShareImageRedirectUI shareImageRedirectUI) {
        this.zmH = shareImageRedirectUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zmH.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
        this.zmH.finish();
    }
}
