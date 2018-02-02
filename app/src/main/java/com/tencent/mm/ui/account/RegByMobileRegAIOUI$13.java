package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.z.ar;

class RegByMobileRegAIOUI$13 implements OnClickListener {
    final /* synthetic */ RegByMobileRegAIOUI xQK;

    RegByMobileRegAIOUI$13(RegByMobileRegAIOUI regByMobileRegAIOUI) {
        this.xQK = regByMobileRegAIOUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        b.b(false, ar.CB() + "," + this.xQK.getClass().getName() + ",RE200_200," + ar.fH("RE200_200") + ",2");
        b.oH("RE200_100");
    }
}
