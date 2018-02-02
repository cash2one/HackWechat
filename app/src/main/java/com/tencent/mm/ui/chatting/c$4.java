package com.tencent.mm.ui.chatting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ae.k;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.z.ar;

class c$4 implements OnCancelListener {
    final /* synthetic */ k flZ;
    final /* synthetic */ c yqf;

    c$4(c cVar, k kVar) {
        this.yqf = cVar;
        this.flZ = kVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.flZ);
        an.aRi().b(2, this.yqf);
    }
}
