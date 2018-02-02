package com.tencent.mm.ui.account;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class LoginUI$27 implements OnClickListener {
    final /* synthetic */ LoginUI xPJ;

    LoginUI$27(LoginUI loginUI) {
        this.xPJ = loginUI;
    }

    public final void onClick(View view) {
        this.xPJ.startActivity(new Intent(this.xPJ, FacebookLoginUI.class));
    }
}
