package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.z.ak.a;

class g$107 implements OnCancelListener {
    final /* synthetic */ String gIT;
    final /* synthetic */ g tIj;

    g$107(g gVar, String str) {
        this.tIj = gVar;
        this.gIT = str;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        a.hfL.hK(this.gIT);
        g.a(this.tIj, g.j(this.tIj), "profile:cancel", null);
    }
}
