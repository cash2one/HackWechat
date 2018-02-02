package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.d;

class m$3 implements OnClickListener {
    final /* synthetic */ int kvg;
    final /* synthetic */ Activity oZ;
    final /* synthetic */ m xHN;

    m$3(m mVar, int i, Activity activity) {
        this.xHN = mVar;
        this.kvg = i;
        this.oZ = activity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.kvg == 32) {
            d.pPH.a(462, 6, 1, true);
        } else if (this.kvg == 96) {
            d.pPH.a(462, 7, 1, true);
        } else {
            d.pPH.a(462, 8, 1, true);
        }
        dialogInterface.dismiss();
        MMAppMgr.b(this.oZ, true);
        this.oZ.finish();
    }
}
