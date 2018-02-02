package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class c$2 implements OnClickListener {
    final /* synthetic */ c zpA;

    c$2(c cVar) {
        this.zpA = cVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        c cVar = this.zpA;
        if (cVar.pyk != null) {
            cVar.pyk.dismiss();
            cVar.pyk = null;
        }
        cVar.zpz.cyk();
    }
}
