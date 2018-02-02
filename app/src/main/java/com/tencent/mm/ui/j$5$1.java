package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.j.5;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class j$5$1 implements Runnable {
    final /* synthetic */ DialogInterface xFN;
    final /* synthetic */ 5 xFO;

    j$5$1(5 5, DialogInterface dialogInterface) {
        this.xFO = 5;
        this.xFN = dialogInterface;
    }

    public final void run() {
        ar.Hg();
        if (c.isSDCardAvailable()) {
            Intent intent = new Intent();
            intent.putExtra("had_detected_no_sdcard_space", true);
            d.b(this.xFO.xFL.xFE, "clean", ".ui.CleanUI", intent);
        } else {
            u.fI(this.xFO.xFL.xFE);
        }
        this.xFN.dismiss();
        g.pQN.a(282, 1, 1, false);
    }
}
