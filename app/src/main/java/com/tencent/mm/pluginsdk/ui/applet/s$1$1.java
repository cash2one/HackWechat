package com.tencent.mm.pluginsdk.ui.applet;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.pluginsdk.ui.applet.s.1;
import com.tencent.mm.z.ar;

class s$1$1 implements OnCancelListener {
    final /* synthetic */ 1 voB;

    s$1$1(1 1) {
        this.voB = 1;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.voB.voA.pZz);
        this.voB.voA.mIl = null;
    }
}
