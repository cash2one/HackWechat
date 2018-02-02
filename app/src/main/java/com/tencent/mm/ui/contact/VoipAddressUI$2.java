package com.tencent.mm.ui.contact;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class VoipAddressUI$2 implements OnClickListener {
    final /* synthetic */ VoipAddressUI yUZ;

    VoipAddressUI$2(VoipAddressUI voipAddressUI) {
        this.yUZ = voipAddressUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.yUZ.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    }
}
