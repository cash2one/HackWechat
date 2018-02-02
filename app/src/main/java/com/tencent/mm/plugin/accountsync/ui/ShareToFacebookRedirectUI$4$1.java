package com.tencent.mm.plugin.accountsync.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.accountsync.ui.ShareToFacebookRedirectUI.4;

class ShareToFacebookRedirectUI$4$1 implements OnCancelListener {
    final /* synthetic */ 4 ilK;

    ShareToFacebookRedirectUI$4$1(4 4) {
        this.ilK = 4;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ShareToFacebookRedirectUI.f(this.ilK.ilI).dismiss();
        this.ilK.ilI.finish();
    }
}
