package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.modelfriend.s;

class RegByMobileSendSmsUI$14 implements OnClickListener {
    final /* synthetic */ RegByMobileSendSmsUI xQV;
    final /* synthetic */ s xQZ;

    RegByMobileSendSmsUI$14(RegByMobileSendSmsUI regByMobileSendSmsUI, s sVar) {
        this.xQV = regByMobileSendSmsUI;
        this.xQZ = sVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        RegByMobileSendSmsUI.a(this.xQV, this.xQZ.getUsername(), this.xQZ.NV());
    }
}
