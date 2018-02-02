package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.z.ar;

class BindFacebookUI$1 implements OnCancelListener {
    final /* synthetic */ BindFacebookUI xNy;

    BindFacebookUI$1(BindFacebookUI bindFacebookUI) {
        this.xNy = bindFacebookUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (BindFacebookUI.a(this.xNy) != null) {
            ar.CG().c(BindFacebookUI.a(this.xNy));
        }
    }
}
