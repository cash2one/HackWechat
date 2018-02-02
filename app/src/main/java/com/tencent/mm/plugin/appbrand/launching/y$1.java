package com.tencent.mm.plugin.appbrand.launching;

import android.widget.Toast;
import com.tencent.mm.sdk.platformtools.ac;

class y$1 implements Runnable {
    final /* synthetic */ String gID;

    y$1(String str) {
        this.gID = str;
    }

    public final void run() {
        Toast.makeText(ac.getContext(), this.gID, 0).show();
    }
}
