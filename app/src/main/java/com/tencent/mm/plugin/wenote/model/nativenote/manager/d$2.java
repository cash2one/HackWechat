package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.content.Context;
import android.widget.Toast;

class d$2 implements Runnable {
    final /* synthetic */ String mwr;
    final /* synthetic */ d tSZ;
    final /* synthetic */ Context val$context;

    d$2(d dVar, Context context, String str) {
        this.tSZ = dVar;
        this.val$context = context;
        this.mwr = str;
    }

    public final void run() {
        Toast.makeText(this.val$context, this.mwr, 0).show();
    }
}
