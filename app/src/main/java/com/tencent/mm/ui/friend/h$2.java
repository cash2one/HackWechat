package com.tencent.mm.ui.friend;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ap.b;
import com.tencent.mm.z.ar;

class h$2 implements OnCancelListener {
    final /* synthetic */ b zdA;
    final /* synthetic */ h zdz;

    h$2(h hVar, b bVar) {
        this.zdz = hVar;
        this.zdA = bVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.zdA);
        this.zdz.zdy.nl(false);
    }
}
