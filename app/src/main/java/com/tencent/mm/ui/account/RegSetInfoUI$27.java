package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.c.b;

class RegSetInfoUI$27 implements OnClickListener {
    final /* synthetic */ RegSetInfoUI xSg;

    RegSetInfoUI$27(RegSetInfoUI regSetInfoUI) {
        this.xSg = regSetInfoUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        b.oH("R500_100");
        Intent intent = new Intent(this.xSg, RegByEmailUI.class);
        intent.addFlags(67108864);
        this.xSg.startActivity(intent);
        this.xSg.finish();
    }
}
