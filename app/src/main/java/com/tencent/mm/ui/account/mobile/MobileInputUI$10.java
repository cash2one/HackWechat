package com.tencent.mm.ui.account.mobile;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.c.a;

class MobileInputUI$10 implements OnClickListener {
    final /* synthetic */ MobileInputUI xUi;

    MobileInputUI$10(MobileInputUI mobileInputUI) {
        this.xUi = mobileInputUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("country_name", this.xUi.hEx);
        intent.putExtra("couttry_code", this.xUi.countryCode);
        a.ifs.b(intent, this.xUi);
    }
}
