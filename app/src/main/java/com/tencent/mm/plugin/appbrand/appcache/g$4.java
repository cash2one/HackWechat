package com.tencent.mm.plugin.appbrand.appcache;

import android.widget.Toast;
import com.tencent.mm.sdk.platformtools.ac;

class g$4 implements Runnable {
    final /* synthetic */ g iDU;
    final /* synthetic */ String iDZ;

    g$4(g gVar, String str) {
        this.iDU = gVar;
        this.iDZ = str;
    }

    public final void run() {
        Toast.makeText(ac.getContext(), this.iDZ, 1).show();
        this.iDU.quit();
    }
}
