package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.ui.account.RegByMobileSendSmsUI.16;
import com.tencent.mm.z.ar;

class RegByMobileSendSmsUI$16$1 implements OnCancelListener {
    final /* synthetic */ y xQY;
    final /* synthetic */ 16 xRa;

    RegByMobileSendSmsUI$16$1(16 16, y yVar) {
        this.xRa = 16;
        this.xQY = yVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.xQY);
    }
}
