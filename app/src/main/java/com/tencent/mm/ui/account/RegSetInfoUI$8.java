package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.z.ar;

class RegSetInfoUI$8 implements OnCancelListener {
    final /* synthetic */ y xQY;
    final /* synthetic */ RegSetInfoUI xSg;

    RegSetInfoUI$8(RegSetInfoUI regSetInfoUI, y yVar) {
        this.xSg = regSetInfoUI;
        this.xQY = yVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.xQY);
        ar.CG().b(126, this.xSg);
    }
}
