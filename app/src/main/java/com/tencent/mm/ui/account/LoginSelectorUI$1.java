package com.tencent.mm.ui.account;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.c.a;

class LoginSelectorUI$1 implements OnClickListener {
    final /* synthetic */ LoginSelectorUI xPw;

    LoginSelectorUI$1(LoginSelectorUI loginSelectorUI) {
        this.xPw = loginSelectorUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("not_auth_setting", true);
        a.ifs.r(intent, this.xPw.mController.xIM);
    }
}
