package com.tencent.mm.ui.bindmobile;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.appbrand.jsapi.g.d;
import com.tencent.mm.z.ar;

class FindMContactIntroUI$10 implements OnCancelListener {
    final /* synthetic */ FindMContactIntroUI ymj;

    FindMContactIntroUI$10(FindMContactIntroUI findMContactIntroUI) {
        this.ymj = findMContactIntroUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (FindMContactIntroUI.i(this.ymj) != null) {
            ar.CG().b((int) d.CTRL_INDEX, FindMContactIntroUI.i(this.ymj));
            FindMContactIntroUI.j(this.ymj);
        }
    }
}
