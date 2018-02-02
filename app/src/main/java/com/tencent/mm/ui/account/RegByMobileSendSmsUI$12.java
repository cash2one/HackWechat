package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.z.ar;

class RegByMobileSendSmsUI$12 implements OnClickListener {
    final /* synthetic */ RegByMobileSendSmsUI xQV;
    final /* synthetic */ s xQZ;

    RegByMobileSendSmsUI$12(RegByMobileSendSmsUI regByMobileSendSmsUI, s sVar) {
        this.xQV = regByMobileSendSmsUI;
        this.xQZ = sVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ar.CG().a(701, this.xQV);
        RegByMobileSendSmsUI.a(this.xQV, this.xQZ.getUsername(), this.xQZ.NV());
    }
}
