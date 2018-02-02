package com.tencent.mm.plugin.appbrand.appcache;

import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.appcache.ag.b;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.task.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;

class ag$b$1 implements Runnable {
    final /* synthetic */ String fgU;
    final /* synthetic */ int iGj;
    final /* synthetic */ String iGk;
    final /* synthetic */ b iGl;

    ag$b$1(b bVar, String str, int i, String str2) {
        this.iGl = bVar;
        this.fgU = str;
        this.iGj = i;
        this.iGk = str2;
    }

    public final void run() {
        d.aJ(this.fgU, this.iGj);
        Toast.makeText(ac.getContext(), ac.getContext().getString(j.iAS, new Object[]{bh.az(this.iGk, this.fgU)}), 1).show();
    }
}
