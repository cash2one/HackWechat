package com.tencent.mm.plugin.luckymoney.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import java.util.Iterator;

class i$2 implements OnCancelListener {
    final /* synthetic */ i ocx;

    i$2(i iVar) {
        this.ocx = iVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (this.ocx.tipDialog != null && this.ocx.ilQ.isEmpty()) {
            this.ocx.tipDialog.dismiss();
            Iterator it = this.ocx.ilR.iterator();
            while (it.hasNext()) {
                k kVar = (k) it.next();
                g.Dk();
                g.Di().gPJ.c(kVar);
            }
            this.ocx.ilR.clear();
        }
    }
}
