package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.profile.a.b;
import com.tencent.mm.z.ar;

class c$14 implements OnCancelListener {
    final /* synthetic */ c piX;
    final /* synthetic */ b pja;

    c$14(c cVar, b bVar) {
        this.piX = cVar;
        this.pja = bVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.pja);
        ar.CG().b(1363, this.piX);
    }
}
