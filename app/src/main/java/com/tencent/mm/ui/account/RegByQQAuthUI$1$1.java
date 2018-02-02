package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.ui.account.RegByQQAuthUI.1;
import com.tencent.mm.z.ar;

class RegByQQAuthUI$1$1 implements OnCancelListener {
    final /* synthetic */ y xRH;
    final /* synthetic */ 1 xRI;

    RegByQQAuthUI$1$1(1 1, y yVar) {
        this.xRI = 1;
        this.xRH = yVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.xRH);
    }
}
