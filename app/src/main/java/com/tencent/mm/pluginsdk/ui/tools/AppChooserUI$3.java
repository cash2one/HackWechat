package com.tencent.mm.pluginsdk.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class AppChooserUI$3 implements OnClickListener {
    final /* synthetic */ AppChooserUI vwh;

    AppChooserUI$3(AppChooserUI appChooserUI) {
        this.vwh = appChooserUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (AppChooserUI.c(this.vwh) != null && AppChooserUI.c(this.vwh).vwl != null) {
            AppChooserUI.a(this.vwh, AppChooserUI.c(this.vwh).vwl.activityInfo.packageName, false);
        }
    }
}
