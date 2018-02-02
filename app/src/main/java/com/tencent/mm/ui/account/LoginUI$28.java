package com.tencent.mm.ui.account;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.w;

class LoginUI$28 implements OnClickListener {
    final /* synthetic */ LoginUI xPJ;

    LoginUI$28(LoginUI loginUI) {
        this.xPJ = loginUI;
    }

    public final void onClick(View view) {
        LoginUI.bq(this.xPJ, this.xPJ.getString(R.l.etx) + w.cfi());
    }
}
