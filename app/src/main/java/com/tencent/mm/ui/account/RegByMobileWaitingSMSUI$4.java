package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class RegByMobileWaitingSMSUI$4 implements OnClickListener {
    final /* synthetic */ RegByMobileWaitingSMSUI xRA;

    RegByMobileWaitingSMSUI$4(RegByMobileWaitingSMSUI regByMobileWaitingSMSUI) {
        this.xRA = regByMobileWaitingSMSUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        RegByMobileWaitingSMSUI.g(this.xRA);
        this.xRA.finish();
    }
}
