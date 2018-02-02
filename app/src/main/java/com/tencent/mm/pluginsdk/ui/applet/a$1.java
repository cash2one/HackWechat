package com.tencent.mm.pluginsdk.ui.applet;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class a$1 implements OnCancelListener {
    final /* synthetic */ a vmY;

    a$1(a aVar) {
        this.vmY = aVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        a.a(this.vmY, false, this.vmY.vmR, this.vmY.vmW);
    }
}
