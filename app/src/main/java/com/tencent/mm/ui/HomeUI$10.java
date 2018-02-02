package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.x;

class HomeUI$10 implements OnClickListener {
    final /* synthetic */ int iGh;
    final /* synthetic */ HomeUI xGv;

    HomeUI$10(HomeUI homeUI, int i) {
        this.xGv = homeUI;
        this.iGh = i;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        try {
            an.startSettingItent(HomeUI.d(this.xGv), this.iGh);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.LauncherUI.HomeUI", e, "", new Object[0]);
        }
    }
}
