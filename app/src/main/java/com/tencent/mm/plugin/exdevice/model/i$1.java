package com.tencent.mm.plugin.exdevice.model;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.z.ar;

class i$1 implements OnCancelListener {
    final /* synthetic */ o lMQ;
    final /* synthetic */ i$a lMR;
    final /* synthetic */ i lMS;

    i$1(i iVar, o oVar, i$a com_tencent_mm_plugin_exdevice_model_i_a) {
        this.lMS = iVar;
        this.lMQ = oVar;
        this.lMR = com_tencent_mm_plugin_exdevice_model_i_a;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.lMQ);
        i.a(this.lMS).dismiss();
        i.b(this.lMS);
        if (this.lMR != null) {
            this.lMR.eH(false);
        }
    }
}
