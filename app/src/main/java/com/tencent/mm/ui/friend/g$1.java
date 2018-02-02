package com.tencent.mm.ui.friend;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelsimple.ae;
import com.tencent.mm.z.ar;

class g$1 implements OnCancelListener {
    final /* synthetic */ ae zdw;
    final /* synthetic */ g zdx;

    g$1(g gVar, ae aeVar) {
        this.zdx = gVar;
        this.zdw = aeVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.zdw);
        this.zdx.zdu.o(false, this.zdx.vmW);
    }
}
