package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.ui.account.RegByMobileSetNickUI.1;
import com.tencent.mm.z.ar;

class RegByMobileSetNickUI$1$1 implements OnCancelListener {
    final /* synthetic */ y xRf;
    final /* synthetic */ 1 xRg;

    RegByMobileSetNickUI$1$1(1 1, y yVar) {
        this.xRg = 1;
        this.xRf = yVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.xRf);
    }
}
