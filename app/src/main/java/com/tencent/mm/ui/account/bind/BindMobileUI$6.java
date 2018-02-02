package com.tencent.mm.ui.account.bind;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.c.a;

class BindMobileUI$6 implements OnClickListener {
    final /* synthetic */ BindMobileUI xTx;

    BindMobileUI$6(BindMobileUI bindMobileUI) {
        this.xTx = bindMobileUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("country_name", BindMobileUI.f(this.xTx));
        intent.putExtra("couttry_code", BindMobileUI.g(this.xTx));
        a.ifs.b(intent, this.xTx);
    }
}
