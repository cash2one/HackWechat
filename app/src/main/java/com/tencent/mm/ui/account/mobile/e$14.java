package com.tencent.mm.ui.account.mobile;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.z.ar;

class e$14 implements OnCancelListener {
    final /* synthetic */ s xPl;
    final /* synthetic */ e xTT;

    e$14(e eVar, s sVar) {
        this.xTT = eVar;
        this.xPl = sVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.xPl);
    }
}
