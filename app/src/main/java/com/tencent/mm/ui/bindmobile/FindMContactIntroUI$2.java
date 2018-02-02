package com.tencent.mm.ui.bindmobile;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class FindMContactIntroUI$2 implements OnClickListener {
    final /* synthetic */ FindMContactIntroUI ymj;

    FindMContactIntroUI$2(FindMContactIntroUI findMContactIntroUI) {
        this.ymj = findMContactIntroUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.ymj.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    }
}
