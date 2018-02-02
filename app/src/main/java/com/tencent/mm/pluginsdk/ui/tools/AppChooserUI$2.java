package com.tencent.mm.pluginsdk.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class AppChooserUI$2 implements OnClickListener {
    final /* synthetic */ AppChooserUI vwh;

    AppChooserUI$2(AppChooserUI appChooserUI) {
        this.vwh = appChooserUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (AppChooserUI.c(this.vwh) != null && AppChooserUI.c(this.vwh).vwl != null) {
            ar.Hg();
            c.CU().set(AppChooserUI.a(this.vwh, 274528), AppChooserUI.c(this.vwh).vwl.activityInfo.packageName);
            AppChooserUI.a(this.vwh, AppChooserUI.c(this.vwh).vwl.activityInfo.packageName, true);
        }
    }
}
