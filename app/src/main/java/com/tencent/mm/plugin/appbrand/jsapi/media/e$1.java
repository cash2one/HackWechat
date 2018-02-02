package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.platformtools.d;
import com.tencent.mm.plugin.appbrand.q.j;

class e$1 implements Runnable {
    final /* synthetic */ e jnI;
    final /* synthetic */ Context val$context;

    e$1(e eVar, Context context) {
        this.jnI = eVar;
        this.val$context = context;
    }

    public final void run() {
        Toast.makeText(this.val$context, this.val$context.getString(j.dXO, new Object[]{d.Wc()}), 1).show();
    }
}
