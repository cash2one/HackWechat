package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.v;

class SnsPermissionUI$2 implements OnCancelListener {
    final /* synthetic */ SnsPermissionUI rEO;
    final /* synthetic */ v rEP;

    SnsPermissionUI$2(SnsPermissionUI snsPermissionUI, v vVar) {
        this.rEO = snsPermissionUI;
        this.rEP = vVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        SnsPermissionUI.a(this.rEO);
        g.Dk();
        g.Di().gPJ.c(this.rEP);
    }
}
