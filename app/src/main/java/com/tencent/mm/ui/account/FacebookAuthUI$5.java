package com.tencent.mm.ui.account;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.modelsimple.h;
import com.tencent.mm.z.ar;

class FacebookAuthUI$5 implements OnClickListener {
    final /* synthetic */ FacebookAuthUI xNS;

    FacebookAuthUI$5(FacebookAuthUI facebookAuthUI) {
        this.xNS = facebookAuthUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        FacebookAuthUI.a(this.xNS, ProgressDialog.show(this.xNS, this.xNS.getString(R.l.dGO), this.xNS.getString(R.l.eej), true));
        FacebookAuthUI.d(this.xNS).setOnCancelListener(FacebookAuthUI.c(this.xNS));
        ar.CG().a(new h(h.hMI), 0);
    }
}
