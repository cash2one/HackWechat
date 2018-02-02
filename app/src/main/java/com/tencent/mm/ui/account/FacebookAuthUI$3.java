package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.z.ar;

class FacebookAuthUI$3 implements OnCancelListener {
    final /* synthetic */ FacebookAuthUI xNS;

    FacebookAuthUI$3(FacebookAuthUI facebookAuthUI) {
        this.xNS = facebookAuthUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (FacebookAuthUI.a(this.xNS) != null) {
            ar.CG().c(FacebookAuthUI.a(this.xNS));
        }
    }
}
