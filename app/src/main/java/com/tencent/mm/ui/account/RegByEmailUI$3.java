package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelfriend.u;
import com.tencent.mm.z.ar;

class RegByEmailUI$3 implements OnCancelListener {
    final /* synthetic */ u xNM;
    final /* synthetic */ RegByEmailUI xQa;

    RegByEmailUI$3(RegByEmailUI regByEmailUI, u uVar) {
        this.xQa = regByEmailUI;
        this.xNM = uVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.xNM);
    }
}
