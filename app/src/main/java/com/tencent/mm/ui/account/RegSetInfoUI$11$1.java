package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.ui.account.RegSetInfoUI.11;
import com.tencent.mm.z.ar;

class RegSetInfoUI$11$1 implements OnCancelListener {
    final /* synthetic */ y xQY;
    final /* synthetic */ 11 xSm;

    RegSetInfoUI$11$1(11 11, y yVar) {
        this.xSm = 11;
        this.xQY = yVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.xQY);
        ar.CG().b(126, this.xSm.xSg);
    }
}
