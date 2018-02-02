package com.tencent.mm.ui.bindgooglecontact;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class BindGoogleContactUI$5 implements OnClickListener {
    final /* synthetic */ BindGoogleContactUI ykD;

    BindGoogleContactUI$5(BindGoogleContactUI bindGoogleContactUI) {
        this.ykD = bindGoogleContactUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ar.Hg();
        c.CU().set(208905, Boolean.valueOf(true));
        this.ykD.finish();
    }
}
