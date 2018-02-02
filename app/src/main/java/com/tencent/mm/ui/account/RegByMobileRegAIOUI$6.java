package com.tencent.mm.ui.account;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.c.a;

class RegByMobileRegAIOUI$6 implements OnClickListener {
    final /* synthetic */ RegByMobileRegAIOUI xQK;

    RegByMobileRegAIOUI$6(RegByMobileRegAIOUI regByMobileRegAIOUI) {
        this.xQK = regByMobileRegAIOUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("country_name", RegByMobileRegAIOUI.i(this.xQK));
        intent.putExtra("couttry_code", RegByMobileRegAIOUI.d(this.xQK));
        a.ifs.b(intent, this.xQK);
    }
}
