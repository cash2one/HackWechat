package com.tencent.mm.ui.account;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.account.mobile.MobileInputUI;

class LoginUI$9 implements OnClickListener {
    final /* synthetic */ LoginUI xPJ;

    LoginUI$9(LoginUI loginUI) {
        this.xPJ = loginUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(this.xPJ, MobileInputUI.class);
        int[] iArr = new int[5];
        iArr[0] = 2;
        intent.putExtra("mobile_input_purpose", 1);
        intent.putExtra("kv_report_login_method_data", iArr);
        intent.putExtra("from_switch_account", LoginUI.i(this.xPJ));
        this.xPJ.startActivity(intent);
        this.xPJ.finish();
    }
}
