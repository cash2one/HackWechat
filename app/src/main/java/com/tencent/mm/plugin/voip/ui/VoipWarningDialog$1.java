package com.tencent.mm.plugin.voip.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class VoipWarningDialog$1 implements OnCancelListener {
    final /* synthetic */ VoipWarningDialog ssB;

    VoipWarningDialog$1(VoipWarningDialog voipWarningDialog) {
        this.ssB = voipWarningDialog;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.ssB.finish();
    }
}
