package com.tencent.mm.plugin.webview.model;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.webview.model.y.d;

class y$c$4 implements OnClickListener {
    final /* synthetic */ d tsn;

    public y$c$4(d dVar) {
        this.tsn = dVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.tsn.goBack();
    }
}
