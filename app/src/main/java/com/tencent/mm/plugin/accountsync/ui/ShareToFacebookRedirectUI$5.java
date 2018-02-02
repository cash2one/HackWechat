package com.tencent.mm.plugin.accountsync.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.ui.account.FacebookAuthUI;

class ShareToFacebookRedirectUI$5 implements OnClickListener {
    final /* synthetic */ ShareToFacebookRedirectUI ilI;

    ShareToFacebookRedirectUI$5(ShareToFacebookRedirectUI shareToFacebookRedirectUI) {
        this.ilI = shareToFacebookRedirectUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent(this.ilI.mController.xIM, FacebookAuthUI.class);
        intent.putExtra("is_force_unbind", true);
        this.ilI.mController.xIM.startActivityForResult(intent, 0);
    }
}
