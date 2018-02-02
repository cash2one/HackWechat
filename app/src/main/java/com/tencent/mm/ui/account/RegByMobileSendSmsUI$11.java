package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.z.ar;

class RegByMobileSendSmsUI$11 implements OnCancelListener {
    final /* synthetic */ RegByMobileSendSmsUI xQV;
    final /* synthetic */ y xQY;

    RegByMobileSendSmsUI$11(RegByMobileSendSmsUI regByMobileSendSmsUI, y yVar) {
        this.xQV = regByMobileSendSmsUI;
        this.xQY = yVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.xQY);
        ar.CG().b(126, this.xQV);
    }
}
