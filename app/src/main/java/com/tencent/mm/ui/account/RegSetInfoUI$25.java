package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.c.b;

class RegSetInfoUI$25 implements OnClickListener {
    final /* synthetic */ RegSetInfoUI xSg;

    RegSetInfoUI$25(RegSetInfoUI regSetInfoUI) {
        this.xSg = regSetInfoUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        b.oH("R400_100_signup");
        Intent intent = new Intent(this.xSg, LoginUI.class);
        intent.addFlags(67108864);
        this.xSg.startActivity(intent);
        this.xSg.finish();
    }
}
