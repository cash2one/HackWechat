package com.tencent.mm.plugin.dbbackup;

import android.app.ProgressDialog;
import android.content.Context;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.z.br;

class c$1 implements b {
    final /* synthetic */ br lpi;
    final /* synthetic */ ProgressDialog lpj;
    final /* synthetic */ c lpk;
    final /* synthetic */ Context val$context;

    c$1(c cVar, br brVar, ProgressDialog progressDialog, Context context) {
        this.lpk = cVar;
        this.lpi = brVar;
        this.lpj = progressDialog;
        this.val$context = context;
    }

    public final void ou(int i) {
        this.lpi.HY();
        ag.y(new 1(this, i));
    }
}
