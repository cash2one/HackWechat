package com.tencent.mm.ui.bindmobile;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class FindMContactLearmMoreUI$6 implements OnClickListener {
    final /* synthetic */ FindMContactLearmMoreUI ymn;

    FindMContactLearmMoreUI$6(FindMContactLearmMoreUI findMContactLearmMoreUI) {
        this.ymn = findMContactLearmMoreUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.ymn.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    }
}
