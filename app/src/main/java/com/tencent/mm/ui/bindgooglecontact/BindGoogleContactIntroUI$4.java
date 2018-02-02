package com.tencent.mm.ui.bindgooglecontact;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.z.ar;

class BindGoogleContactIntroUI$4 implements OnCancelListener {
    final /* synthetic */ BindGoogleContactIntroUI ykv;

    BindGoogleContactIntroUI$4(BindGoogleContactIntroUI bindGoogleContactIntroUI) {
        this.ykv = bindGoogleContactIntroUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(BindGoogleContactIntroUI.c(this.ykv));
    }
}
