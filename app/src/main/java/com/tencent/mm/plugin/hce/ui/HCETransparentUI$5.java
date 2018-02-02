package com.tencent.mm.plugin.hce.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class HCETransparentUI$5 implements OnClickListener {
    final /* synthetic */ int fmb;
    final /* synthetic */ String hnj;
    final /* synthetic */ HCETransparentUI nAu;

    HCETransparentUI$5(HCETransparentUI hCETransparentUI, int i, String str) {
        this.nAu = hCETransparentUI;
        this.fmb = i;
        this.hnj = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        HCETransparentUI.a(this.nAu, this.fmb, this.hnj);
    }
}
