package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class HomeUI$17 implements OnClickListener {
    final /* synthetic */ HomeUI xGv;

    HomeUI$17(HomeUI homeUI) {
        this.xGv = homeUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        HomeUI.d(this.xGv).startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    }
}
