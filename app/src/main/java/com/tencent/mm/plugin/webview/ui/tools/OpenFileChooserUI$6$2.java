package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.ui.tools.OpenFileChooserUI.6;
import com.tencent.mm.ui.base.h;

class OpenFileChooserUI$6$2 implements Runnable {
    final /* synthetic */ 6 twV;

    OpenFileChooserUI$6$2(6 6) {
        this.twV = 6;
    }

    public final void run() {
        h.a(this.twV.twU, this.twV.twU.getString(R.l.eWR), this.twV.twU.getString(R.l.dGO), this.twV.twU.getString(R.l.dFs), false, new 1(this));
    }
}
