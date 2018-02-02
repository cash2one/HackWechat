package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.c.b;

class RegByEmailUI$2 implements OnClickListener {
    final /* synthetic */ RegByEmailUI xQa;

    RegByEmailUI$2(RegByEmailUI regByEmailUI) {
        this.xQa = regByEmailUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        b.oH(RegByEmailUI.f(this.xQa));
        this.xQa.aWs();
        this.xQa.finish();
    }
}
