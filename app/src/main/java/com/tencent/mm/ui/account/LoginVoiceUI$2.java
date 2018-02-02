package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.z.ar;

class LoginVoiceUI$2 implements OnCancelListener {
    final /* synthetic */ v xOp;
    final /* synthetic */ LoginVoiceUI xPM;

    LoginVoiceUI$2(LoginVoiceUI loginVoiceUI, v vVar) {
        this.xPM = loginVoiceUI;
        this.xOp = vVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.xOp);
        this.xPM.cnO();
    }
}
