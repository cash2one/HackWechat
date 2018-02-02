package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI.6;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.z.ar;

class SayHiWithSnsPermissionUI$6$2 implements OnCancelListener {
    final /* synthetic */ o pln;
    final /* synthetic */ 6 plo;

    SayHiWithSnsPermissionUI$6$2(6 6, o oVar) {
        this.plo = 6;
        this.pln = oVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.pln);
    }
}
