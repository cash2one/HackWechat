package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mm.bk.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class ab$4 implements OnClickListener {
    final /* synthetic */ CheckBox smw;
    final /* synthetic */ ab xMg;

    ab$4(ab abVar, CheckBox checkBox) {
        this.xMg = abVar;
        this.smw = checkBox;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.smw != null) {
            ar.Hg();
            c.CU().set(4104, Boolean.valueOf(!this.smw.isChecked()));
        }
        LauncherUI cmG = LauncherUI.cmG();
        if (cmG != null) {
            cmG.xGS.xGh.Yp("tab_find_friend");
        }
        a.dV(ab.c(this.xMg));
    }
}
