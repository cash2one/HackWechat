package com.tencent.mm.ui.bindgooglecontact;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ap.a;

class BindGoogleContactUI$4 implements OnClickListener {
    final /* synthetic */ BindGoogleContactUI ykD;
    final /* synthetic */ String ykE;

    BindGoogleContactUI$4(BindGoogleContactUI bindGoogleContactUI, String str) {
        this.ykD = bindGoogleContactUI;
        this.ykE = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        BindGoogleContactUI.a(this.ykD, this.ykE, a.hyR);
    }
}
