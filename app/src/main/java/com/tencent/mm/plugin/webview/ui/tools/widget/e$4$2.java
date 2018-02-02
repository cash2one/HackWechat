package com.tencent.mm.plugin.webview.ui.tools.widget;

import com.tencent.mm.plugin.webview.ui.tools.widget.e.4;
import java.util.Map;

class e$4$2 implements Runnable {
    final /* synthetic */ Map tAz;
    final /* synthetic */ 4 tKr;

    e$4$2(4 4, Map map) {
        this.tKr = 4;
        this.tAz = map;
    }

    public final void run() {
        if (this.tKr.tKp.tFj != null) {
            this.tKr.tKp.tFj.am(this.tAz);
        }
    }
}
