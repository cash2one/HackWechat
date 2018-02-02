package com.tencent.mm.ui.account;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.w;

class LoginUI$29 implements OnClickListener {
    final /* synthetic */ LoginUI xPJ;

    LoginUI$29(LoginUI loginUI) {
        this.xPJ = loginUI;
    }

    public final void onClick(View view) {
        LoginUI.bq(this.xPJ, this.xPJ.getString(R.l.eke, new Object[]{w.cfi()}));
    }
}
