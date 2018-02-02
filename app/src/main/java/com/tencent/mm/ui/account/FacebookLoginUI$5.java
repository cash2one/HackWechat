package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.z.ar;

class FacebookLoginUI$5 implements OnCancelListener {
    final /* synthetic */ FacebookLoginUI xOf;

    FacebookLoginUI$5(FacebookLoginUI facebookLoginUI) {
        this.xOf = facebookLoginUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (FacebookLoginUI.b(this.xOf) != null) {
            ar.CG().c(FacebookLoginUI.b(this.xOf));
        }
    }
}
