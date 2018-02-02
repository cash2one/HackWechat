package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ae.k;
import com.tencent.mm.ui.account.b.1;
import com.tencent.mm.z.ar;

class b$1$1 implements OnCancelListener {
    final /* synthetic */ k flZ;
    final /* synthetic */ 1 xNr;

    b$1$1(1 1, k kVar) {
        this.xNr = 1;
        this.flZ = kVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.flZ);
    }
}
