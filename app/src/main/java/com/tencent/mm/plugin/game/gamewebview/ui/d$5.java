package com.tencent.mm.plugin.game.gamewebview.ui;

import android.net.Uri;
import com.tencent.mm.pluginsdk.model.app.g;

class d$5 implements Runnable {
    final /* synthetic */ Uri kvf;
    final /* synthetic */ d mZC;

    d$5(d dVar, Uri uri) {
        this.mZC = dVar;
        this.kvf = uri;
    }

    public final void run() {
        g.d(d.t(this.mZC), this.kvf);
    }
}
