package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.d;

class m$5 implements OnClickListener {
    final /* synthetic */ int kvg;
    final /* synthetic */ Activity oZ;
    final /* synthetic */ m xHN;

    m$5(m mVar, int i, Activity activity) {
        this.xHN = mVar;
        this.kvg = i;
        this.oZ = activity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.kvg == 33) {
            d.pPH.a(462, 15, 1, true);
        } else if (this.kvg == 97) {
            d.pPH.a(462, 16, 1, true);
        } else {
            d.pPH.a(462, 17, 1, true);
        }
        dialogInterface.dismiss();
        this.xHN.pyw = true;
        MMAppMgr.b(this.oZ, true);
        this.oZ.finish();
    }
}
