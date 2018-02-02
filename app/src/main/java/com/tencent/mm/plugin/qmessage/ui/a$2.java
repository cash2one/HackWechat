package com.tencent.mm.plugin.qmessage.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.qmessage.a.b;
import com.tencent.mm.z.ar;

class a$2 implements OnCancelListener {
    final /* synthetic */ b pnE;
    final /* synthetic */ a pnF;

    a$2(a aVar, b bVar) {
        this.pnF = aVar;
        this.pnE = bVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.pnE);
    }
}
