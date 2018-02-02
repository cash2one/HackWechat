package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.webview.a.a;

class g$13 implements OnClickListener {
    final /* synthetic */ g tIj;

    g$13(g gVar) {
        this.tIj = gVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        a.ifs.h(new Intent(), g.i(this.tIj));
    }
}
