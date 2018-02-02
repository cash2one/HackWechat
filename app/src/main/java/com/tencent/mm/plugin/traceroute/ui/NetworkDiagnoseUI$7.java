package com.tencent.mm.plugin.traceroute.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class NetworkDiagnoseUI$7 implements OnClickListener {
    final /* synthetic */ NetworkDiagnoseUI sfP;

    NetworkDiagnoseUI$7(NetworkDiagnoseUI networkDiagnoseUI) {
        this.sfP = networkDiagnoseUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        NetworkDiagnoseUI.e(this.sfP);
        this.sfP.finish();
    }
}
