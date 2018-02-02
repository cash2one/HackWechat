package com.tencent.mm.plugin.dbbackup;

import android.app.ProgressDialog;
import android.content.Context;
import com.tencent.mm.sdk.platformtools.ag;

class c$3 implements b {
    final /* synthetic */ long hAU;
    final /* synthetic */ ProgressDialog lpj;
    final /* synthetic */ c lpk;
    final /* synthetic */ Context val$context;

    c$3(c cVar, ProgressDialog progressDialog, long j, Context context) {
        this.lpk = cVar;
        this.lpj = progressDialog;
        this.hAU = j;
        this.val$context = context;
    }

    public final void ou(int i) {
        ag.y(new 1(this, i));
    }
}
