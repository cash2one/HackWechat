package com.tencent.mm.ui.bindmobile;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.appbrand.jsapi.g.d;
import com.tencent.mm.z.ar;

class FindMContactAlertUI$10 implements OnCancelListener {
    final /* synthetic */ FindMContactAlertUI ymg;

    FindMContactAlertUI$10(FindMContactAlertUI findMContactAlertUI) {
        this.ymg = findMContactAlertUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (FindMContactAlertUI.h(this.ymg) != null) {
            ar.CG().b(d.CTRL_INDEX, FindMContactAlertUI.h(this.ymg));
            FindMContactAlertUI.i(this.ymg);
            FindMContactAlertUI.j(this.ymg);
        }
    }
}
