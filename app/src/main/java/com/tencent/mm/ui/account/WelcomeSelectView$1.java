package com.tencent.mm.ui.account;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.c.a;

class WelcomeSelectView$1 implements OnClickListener {
    final /* synthetic */ WelcomeSelectView xST;

    WelcomeSelectView$1(WelcomeSelectView welcomeSelectView) {
        this.xST = welcomeSelectView;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("not_auth_setting", true);
        intent.putExtra("from_login_history", true);
        a.ifs.r(intent, this.xST.getContext());
    }
}
