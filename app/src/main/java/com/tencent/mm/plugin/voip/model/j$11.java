package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.compatible.e.b;
import com.tencent.mm.sdk.platformtools.x;

class j$11 implements OnClickListener {
    final /* synthetic */ Context smE;
    final /* synthetic */ j smu;

    public j$11(j jVar, Context context) {
        this.smu = jVar;
        this.smE = context;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.Voip.VoipMgr", "show Permission settings");
        b.aL(this.smE);
        if (j.b(this.smu)) {
            if (j.e(this.smu)) {
                this.smu.bGP();
            } else {
                this.smu.bGQ();
            }
        } else if (j.e(this.smu)) {
            this.smu.bGL();
        } else {
            this.smu.bGN();
        }
    }
}
