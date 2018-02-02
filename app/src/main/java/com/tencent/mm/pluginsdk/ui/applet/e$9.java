package com.tencent.mm.pluginsdk.ui.applet;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.ui.base.i;

class e$9 implements OnClickListener {
    final /* synthetic */ i vnn;
    final /* synthetic */ a vnp;

    e$9(i iVar, a aVar) {
        this.vnn = iVar;
        this.vnp = aVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.vnn.dismiss();
        if (this.vnp != null) {
            this.vnp.a(false, null, 0);
        }
    }
}
