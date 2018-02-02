package com.tencent.mm.ui.account.mobile;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.z.ar;

class h$7 implements OnCancelListener {
    final /* synthetic */ y xQY;
    final /* synthetic */ h xUN;

    h$7(h hVar, y yVar) {
        this.xUN = hVar;
        this.xQY = yVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.xQY);
        ar.CG().b(126, this.xUN);
    }
}
