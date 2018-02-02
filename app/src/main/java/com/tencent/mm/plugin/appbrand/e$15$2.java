package com.tencent.mm.plugin.appbrand;

import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.e.15;
import com.tencent.mm.plugin.appbrand.e.17;
import com.tencent.mm.plugin.appbrand.ui.j;
import com.tencent.mm.sdk.platformtools.x;

class e$15$2 implements Runnable {
    final /* synthetic */ 15 irl;

    e$15$2(15 15) {
        this.irl = 15;
    }

    public final void run() {
        x.d("MicroMsg.AppBrandRuntime", "AppBrandPrepareTask done. runOnUiThread");
        e eVar = this.irl.irf;
        boolean j = j.j(eVar.iqt);
        if (eVar.Yz() && j) {
            Toast makeText = Toast.makeText(eVar.iqt, q.j.iBM, 1);
            makeText.setGravity(17, 0, 0);
            makeText.show();
            eVar.iqt.finish();
        } else {
            eVar.a(new 17(eVar));
        }
        this.irl.irf.iqW = true;
        this.irl.irf.YC();
    }
}
