package com.tencent.mm.pluginsdk.ui.preference;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.z.ar;

class a$2 implements OnCancelListener {
    final /* synthetic */ o pln;
    final /* synthetic */ a vsY;

    a$2(a aVar, o oVar) {
        this.vsY = aVar;
        this.pln = oVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.pln);
    }
}
