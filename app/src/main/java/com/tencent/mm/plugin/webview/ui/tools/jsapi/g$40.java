package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.widget.Toast;
import com.tencent.mm.R;

class g$40 implements Runnable {
    final /* synthetic */ g tIj;

    g$40(g gVar) {
        this.tIj = gVar;
    }

    public final void run() {
        Toast.makeText(g.i(this.tIj), g.i(this.tIj).getString(R.l.emi), 0).show();
    }
}
