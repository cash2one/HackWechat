package com.tencent.mm.plugin.qqmail.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.qqmail.b.n;
import com.tencent.mm.z.ar;

class a$4 implements OnCancelListener {
    final /* synthetic */ a prY;
    final /* synthetic */ n prZ;

    a$4(a aVar, n nVar) {
        this.prY = aVar;
        this.prZ = nVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.prZ);
    }
}
