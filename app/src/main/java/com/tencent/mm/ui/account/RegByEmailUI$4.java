package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.c.b;

class RegByEmailUI$4 implements OnClickListener {
    final /* synthetic */ RegByEmailUI xQa;

    RegByEmailUI$4(RegByEmailUI regByEmailUI) {
        this.xQa = regByEmailUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.xQa.finish();
        b.oH("L2_signup");
        Intent intent = new Intent(this.xQa, LoginPasswordUI.class);
        intent.putExtra("email_address", RegByEmailUI.g(this.xQa));
        this.xQa.startActivity(intent);
    }
}
