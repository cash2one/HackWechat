package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.bk.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class h$7 implements OnClickListener {
    final /* synthetic */ h xFs;

    h$7(h hVar) {
        this.xFs = hVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (h.p(this.xFs) != null) {
            ar.Hg();
            c.CU().set(4104, Boolean.valueOf(!h.p(this.xFs).isChecked()));
        }
        LauncherUI launcherUI = (LauncherUI) this.xFs.getContext();
        if (launcherUI != null) {
            launcherUI.xGS.xGh.Yp("tab_find_friend");
        }
        a.dV(this.xFs.getContext());
    }
}
