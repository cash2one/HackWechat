package com.tencent.mm.ui.account.mobile;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.account.LoginUI;

class c$1 implements OnClickListener {
    final /* synthetic */ MobileInputUI xTP;
    final /* synthetic */ c xTQ;

    c$1(c cVar, MobileInputUI mobileInputUI) {
        this.xTQ = cVar;
        this.xTP = mobileInputUI;
    }

    public final void onClick(View view) {
        this.xTP.nZZ[0] = 1;
        Intent intent = new Intent();
        intent.putExtra("from_switch_account", this.xTP.xPG);
        intent.setClass(this.xTP, LoginUI.class);
        this.xTP.startActivity(intent);
        this.xTP.finish();
    }
}
