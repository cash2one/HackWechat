package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.widget.Toast;
import com.tencent.mm.R;

class g$39 implements Runnable {
    final /* synthetic */ g tIj;

    g$39(g gVar) {
        this.tIj = gVar;
    }

    public final void run() {
        Toast.makeText(g.i(this.tIj), g.i(this.tIj).getString(R.l.emj), 0).show();
    }
}
