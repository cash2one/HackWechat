package com.tencent.mm.plugin.sight.decode.a;

import android.view.View;
import com.tencent.mm.plugin.sight.decode.a.b.k;
import com.tencent.mm.sdk.platformtools.x;

class b$k$3 implements Runnable {
    final /* synthetic */ View quh;
    final /* synthetic */ k quj;

    b$k$3(k kVar, View view) {
        this.quj = kVar;
        this.quh = view;
    }

    public final void run() {
        x.v("MicroMsg.SightPlayController", "set background drawable null");
        this.quh.setBackgroundDrawable(null);
    }
}
