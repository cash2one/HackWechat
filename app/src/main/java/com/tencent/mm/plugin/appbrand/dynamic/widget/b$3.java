package com.tencent.mm.plugin.appbrand.dynamic.widget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class b$3 implements OnDismissListener {
    final /* synthetic */ b iVG;

    b$3(b bVar) {
        this.iVG = bVar;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        if (this.iVG.iVA != null) {
            this.iVG.iVA.setAdapter(null);
        }
    }
}
