package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelfriend.x;
import com.tencent.mm.ui.account.RegSetInfoUI.16;
import com.tencent.mm.z.ar;

class RegSetInfoUI$16$1 implements OnCancelListener {
    final /* synthetic */ x xSn;
    final /* synthetic */ 16 xSo;

    RegSetInfoUI$16$1(16 16, x xVar) {
        this.xSo = 16;
        this.xSn = xVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.xSn);
        ar.CG().b(429, this.xSo.xSg);
    }
}
