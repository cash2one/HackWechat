package com.tencent.mm.ui.account;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.ui.account.mobile.MobileInputUI;

class LoginIndepPass$14 implements OnMenuItemClickListener {
    final /* synthetic */ LoginIndepPass xPi;

    LoginIndepPass$14(LoginIndepPass loginIndepPass) {
        this.xPi = loginIndepPass;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        b.oH("L200_100");
        Intent intent = new Intent(this.xPi, MobileInputUI.class);
        intent.putExtra("mobile_input_purpose", 1);
        intent.addFlags(67108864);
        this.xPi.startActivity(intent);
        this.xPi.finish();
        return true;
    }
}
