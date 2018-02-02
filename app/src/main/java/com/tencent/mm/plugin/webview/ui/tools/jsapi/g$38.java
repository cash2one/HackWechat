package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.widget.Toast;
import com.tencent.mm.R;

class g$38 implements Runnable {
    final /* synthetic */ g tIj;

    g$38(g gVar) {
        this.tIj = gVar;
    }

    public final void run() {
        Toast.makeText(g.i(this.tIj), g.i(this.tIj).getString(R.l.emh), 0).show();
    }
}
