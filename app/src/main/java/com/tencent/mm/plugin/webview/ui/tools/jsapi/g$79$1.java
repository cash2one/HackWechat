package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.g.a.ff;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g.79;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;

class g$79$1 implements OnCancelListener {
    final /* synthetic */ 79 tJf;

    g$79$1(79 79) {
        this.tJf = 79;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        b ffVar = new ff();
        ffVar.fuq.fut = 3;
        a.xef.m(ffVar);
        g.a(this.tJf.tIj, this.tJf.tIg, "translateVoice:fail", null);
    }
}
