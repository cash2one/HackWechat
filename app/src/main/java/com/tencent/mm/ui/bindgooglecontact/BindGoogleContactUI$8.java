package com.tencent.mm.ui.bindgooglecontact;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.z.ar;

class BindGoogleContactUI$8 implements OnCancelListener {
    final /* synthetic */ BindGoogleContactUI ykD;

    BindGoogleContactUI$8(BindGoogleContactUI bindGoogleContactUI) {
        this.ykD = bindGoogleContactUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        BindGoogleContactUI.f(this.ykD);
        if (BindGoogleContactUI.g(this.ykD) != null) {
            ar.CG().c(BindGoogleContactUI.g(this.ykD));
        }
    }
}
