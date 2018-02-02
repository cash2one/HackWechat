package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.xweb.f;

class d$6 implements OnClickListener {
    final /* synthetic */ f mZO;
    final /* synthetic */ d tKb;

    d$6(d dVar, f fVar) {
        this.tKb = dVar;
        this.mZO = fVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.mZO.cancel();
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
        this.tKb.onClose();
    }
}
