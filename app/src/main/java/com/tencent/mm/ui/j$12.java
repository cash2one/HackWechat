package com.tencent.mm.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelsimple.al;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

class j$12 implements OnClickListener {
    final /* synthetic */ j xFL;

    j$12(j jVar) {
        this.xFL = jVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        String obj = this.xFL.qiC.getText().toString();
        this.xFL.qiC.setText("");
        this.xFL.qiC.clearFocus();
        t.a(this.xFL.xFE, this.xFL.qiC);
        if (obj == null || obj.equals("")) {
            h.a(this.xFL.xFE, R.l.eSM, R.l.dGO, new OnClickListener(this) {
                final /* synthetic */ j$12 xFU;

                {
                    this.xFU = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            return;
        }
        this.xFL.cmu();
        ar.CG().a(384, this.xFL.xFH);
        k alVar = new al(obj, "", "", "");
        ar.CG().a(alVar, 0);
        j jVar = this.xFL;
        Context context = this.xFL.xFE;
        this.xFL.getString(R.l.dGO);
        jVar.iln = h.a(context, this.xFL.getString(R.l.eLF), true, new 2(this, alVar));
    }
}
