package com.tencent.mm.plugin.accountsync.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.appbrand.jsapi.v;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class b$1 implements OnCancelListener {
    final /* synthetic */ b ikD;

    public b$1(b bVar) {
        this.ikD = bVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        x.w("MicroMsg.DoInit", "do init canceled");
        ar.CG().c(this.ikD.frb);
        if (this.ikD.frb.getType() == v.CTRL_INDEX) {
            ar.CG().b(v.CTRL_INDEX, this.ikD);
        } else if (this.ikD.frb.getType() == 138) {
            ar.CG().b(138, this.ikD);
        }
    }
}
