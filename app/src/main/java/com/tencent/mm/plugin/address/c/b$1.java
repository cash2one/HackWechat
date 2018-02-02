package com.tencent.mm.plugin.address.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ae.k;
import com.tencent.mm.z.ar;
import java.util.Iterator;

class b$1 implements OnCancelListener {
    final /* synthetic */ b imh;

    b$1(b bVar) {
        this.imh = bVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (this.imh.ilS != null && this.imh.ilQ.isEmpty()) {
            this.imh.ilS.dismiss();
            Iterator it = this.imh.ilR.iterator();
            while (it.hasNext()) {
                ar.CG().c((k) it.next());
            }
            this.imh.ilR.clear();
        }
    }
}
