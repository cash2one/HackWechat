package com.tencent.mm.plugin.readerapp.ui;

import android.app.ProgressDialog;
import com.tencent.mm.sdk.platformtools.af;
import java.util.TimerTask;

class b$4 extends TimerTask {
    final /* synthetic */ af kCy;
    final /* synthetic */ ProgressDialog lpj;

    b$4(ProgressDialog progressDialog, af afVar) {
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
