package com.tencent.mm.wallet_core.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import java.util.Iterator;

class g$3 implements OnCancelListener {
    final /* synthetic */ g zHZ;

    g$3(g gVar) {
        this.zHZ = gVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (this.zHZ.ilS != null && this.zHZ.ilQ.isEmpty()) {
            this.zHZ.ilS.dismiss();
            Iterator it = this.zHZ.ilR.iterator();
            while (it.hasNext()) {
                k kVar = (k) it.next();
                g.Dk();
                g.Di().gPJ.c(kVar);
            }
            this.zHZ.ilR.clear();
        }
    }
}
