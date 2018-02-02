package com.tencent.mm.plugin.masssend.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.masssend.a.f;
import com.tencent.mm.z.ar;

class MassSendMsgUI$12 implements OnCancelListener {
    final /* synthetic */ MassSendMsgUI onR;
    final /* synthetic */ f onl;

    MassSendMsgUI$12(MassSendMsgUI massSendMsgUI, f fVar) {
        this.onR = massSendMsgUI;
        this.onl = fVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.onl);
    }
}
