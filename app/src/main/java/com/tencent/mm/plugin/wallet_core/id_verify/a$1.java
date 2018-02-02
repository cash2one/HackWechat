package com.tencent.mm.plugin.wallet_core.id_verify;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.g.a.su;
import com.tencent.mm.g.a.tf;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements Runnable {
    final /* synthetic */ Intent gHX;
    final /* synthetic */ Activity icz;
    final /* synthetic */ su sJg;
    final /* synthetic */ a sJh;

    a$1(a aVar, su suVar, Intent intent, Activity activity) {
        this.sJh = aVar;
        this.sJg = suVar;
        this.gHX = intent;
        this.icz = activity;
    }

    public final void run() {
        this.sJg.fqI = null;
        a.a(this.sJh);
        if (bh.ov(a.b(this.sJh)) || bh.ov(a.c(this.sJh))) {
            this.sJh.ah(this.icz);
            if (a.d(this.sJh) == -1) {
                b tfVar = new tf();
                tfVar.fLI.result = a.d(this.sJh);
                a.xef.m(tfVar);
                return;
            }
            return;
        }
        x.i("MicroMsg.RealNameVerifyProcess", "real name verify process end,jump to " + a.b(this.sJh) + a.c(this.sJh));
        boolean z = this.sJh.msB.getBoolean("process_finish_stay_orgpage", true);
        this.gHX.putExtra("key_process_is_end", true);
        this.gHX.putExtra("key_process_is_stay", z);
        a.a(this.sJh, this.icz, a.b(this.sJh), a.c(this.sJh), a.d(this.sJh), this.gHX, z);
        if (a.d(this.sJh) == -1) {
            tfVar = new tf();
            tfVar.fLI.result = a.d(this.sJh);
            a.xef.m(tfVar);
        }
    }
}
