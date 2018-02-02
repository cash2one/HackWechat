package com.tencent.mm.ui.bindmobile;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.appbrand.jsapi.g.d;
import com.tencent.mm.z.ar;

class FindMContactLearmMoreUI$4 implements OnCancelListener {
    final /* synthetic */ FindMContactLearmMoreUI ymn;

    FindMContactLearmMoreUI$4(FindMContactLearmMoreUI findMContactLearmMoreUI) {
        this.ymn = findMContactLearmMoreUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (FindMContactLearmMoreUI.e(this.ymn) != null) {
            ar.CG().b((int) d.CTRL_INDEX, FindMContactLearmMoreUI.e(this.ymn));
            FindMContactLearmMoreUI.f(this.ymn);
        }
    }
}
