package com.tencent.mm.plugin.profile.ui;

import android.app.ProgressDialog;
import com.tencent.mm.sdk.platformtools.af;
import java.util.TimerTask;

class n$3 extends TimerTask {
    final /* synthetic */ af kCy;
    final /* synthetic */ ProgressDialog lpj;

    n$3(ProgressDialog progressDialog, af afVar) {
        this.lpj = progressDialog;
        this.kCy = afVar;
    }

    public final void run() {
        if (this.lpj != null) {
            this.lpj.dismiss();
            this.kCy.sendEmptyMessage(0);
        }
    }
}
