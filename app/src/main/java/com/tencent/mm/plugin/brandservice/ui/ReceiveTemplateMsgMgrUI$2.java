package com.tencent.mm.plugin.brandservice.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.brandservice.a.e;
import com.tencent.mm.z.ar;

class ReceiveTemplateMsgMgrUI$2 implements OnCancelListener {
    final /* synthetic */ ReceiveTemplateMsgMgrUI kGN;
    final /* synthetic */ e kGO;

    ReceiveTemplateMsgMgrUI$2(ReceiveTemplateMsgMgrUI receiveTemplateMsgMgrUI, e eVar) {
        this.kGN = receiveTemplateMsgMgrUI;
        this.kGO = eVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.kGO);
    }
}
