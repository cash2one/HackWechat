package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class HomeUI$14 implements OnClickListener {
    final /* synthetic */ HomeUI xGv;

    HomeUI$14(HomeUI homeUI) {
        this.xGv = homeUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        HomeUI.d(this.xGv).startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    }
}
